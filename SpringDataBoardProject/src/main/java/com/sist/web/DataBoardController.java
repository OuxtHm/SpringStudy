package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URLEncoder;
import java.util.*;

import javax.servlet.http.HttpServletResponse;

import com.sist.service.*;
import com.sist.vo.*;

@Controller
public class DataBoardController {
	@Autowired
	private DataBoardService dService;
	
	@GetMapping("databoard/list.do")
	public String databoard_list(String page, Model model)
	{
		// Model model : JSP / HTML => 데이터 전송 객체 = request 대체
		if(page == null)
			page = "1";
		int curpage = Integer.parseInt(page);
		int rowSize = 10;
		int start = (curpage - 1) * rowSize;	// OFFSET => 0    : rownum => 1
		List<DataBoardVO> list = dService.databoardListData(start);
		int count = dService.databoardRowCount(); 
		int totalpage = (int)(Math.ceil(count / 10.0));
		count = count-((rowSize * curpage) - rowSize);
		
		// JSP 전송
		model.addAttribute("list", list);
		model.addAttribute("count", count);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("curpage", curpage);
					
		return "databoard/list";
	}
	
	@GetMapping("databoard/insert.do")
	public String databoad_insert()
	{
		return "databoard/insert";
	}
	@PostMapping("databoard/insert_ok.do")
	public String databoard_insert_ok(DataBoardVO vo)
	{
		String path = "c:\\upload";
		List<MultipartFile> list = vo.getFiles();
		if(list == null)	// 파일이 없는 상태
		{
			vo.setFilename("");
			vo.setFilesize("");
			vo.setFilecount(0);
		}
		else	// 파일 올리기
		{
			try {
				String filename = "";
				String filesize = "";
				
				for(MultipartFile mf : list)
				{
					String oname = mf.getOriginalFilename();
					File file = new File(path+"\\" + oname);
					
					if(file.exists()) // 파일 중복체크
					{
						String name = oname.substring(0, oname.lastIndexOf("."));
						String ext = oname.substring(oname.lastIndexOf("."));
						int count = 1;
						while(file.exists())
						{
							String newName = name + "(" + count + ")" + ext;
							file = new File(path + "\\" + newName);
							count++;
						}
					}
					
					mf.transferTo(file);
					filename += file.getName() + ",";
					filesize += file.length() + ",";
				}
				filename = filename.substring(0, filename.lastIndexOf(","));
				filesize = filesize.substring(0, filesize.lastIndexOf(","));
				
				vo.setFilename(filename);
				vo.setFilesize(filesize);
				vo.setFilecount(list.size());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			dService.databoardInsert(vo);
		}
		return "redirect:list.do";
	}
	
	@GetMapping("databoard/detail.do")
	public String databoard_detail(int no, Model model)
	{
		// 오라클에서 데이터 읽기
		DataBoardVO vo = dService.databoardDetailData(no);
		if(vo.getFilecount() > 0)
		{
			List<String> fList = new ArrayList<String>();
			List<String> sList = new ArrayList<String>();
			String[] f = vo.getFilename().split(",");
			String[] s = vo.getFilesize().split(",");
			fList = Arrays.asList(f);
			sList = Arrays.asList(s);
			
			model.addAttribute("fList", fList);
			model.addAttribute("sList", sList);
		}
		
		model.addAttribute("vo", vo);
		
		return "databoard/detail";
	}
	
	/*
		Spring => Model 제작
		--------------------
		리턴형 : void => 다운로드(화면이동 / 화면 이동이 없는 경우) 
				String => 파일 변경(화면변경)
		메소드 찾기 -> URL 주소를 이용한다.
		  |
		매개변수
			=> 사용자가 보내준 데이터 : 일반 데이터 / VO
			=> 데이터 전송이 있는 경우 : Model model
			=> Cookie : request / response 
			   Session : HttpSession session
			=> 필요한 데이터나 객체 => 매개변수를 통해서 가지고 온다
				
	*/
	@GetMapping("databoard/download.do")
	public void databoard_download(String fn, HttpServletResponse response)
	{
		try {
			// 1. 파일 정보
			String path="c:\\upload";
			File file = new File(path+"\\"+fn);
			
			// 2. header 전송 : 파일명 / 파일 크기 
			response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fn,"UTF-8"));
			response.setContentLength((int)file.length());
			
			// 3. 다운로드
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
			BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
			
			byte[] buffer = new byte[1024];	// 저장
			// TCP => 1024 / UDP => 512
			
			int i = 0;	// 읽은 바이트 수
			while((i = bis.read(buffer, 0, 1024)) != -1)
			{
				bos.write(buffer, 0, i);
			}
			bis.close();
			bos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping("databoard/delete.do")
	public String databoard_delete(int no, Model model)
	{
		model.addAttribute("no", no);
		
		return "databoard/delete";
	}
	
	@PostMapping(value="databoard/delete_ok.do", produces="text/html;charset=UTF-8")
	@ResponseBody
	// 화면이동 => HTML / JavaScript에 필요한 데이터를 전송
	// 단점 : 한글이 깨진다.
	public String databoard_delete_ok(int no, String pwd)
	{
		String res = "";
		DataBoardVO vo = dService.databoardFileInfoData(no);
		boolean bCheck = dService.databoardDelete(no, pwd);
		
		if(bCheck)
		{
			res="<script>"
				+ "location.href=\"list.do\""
				+ "</script>";
			
			// 파일 제거
			try {
				if(vo.getFilecount() > 0)
				{
					String path="c:\\upload";
					StringTokenizer st = new StringTokenizer(vo.getFilename(), ",");
					while(st.hasMoreTokens())
					{
						File file = new File(path+"\\" +st.nextToken());
						file.delete();
					}
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else
		{
			res="<script>"
				+ "alert(\"비밀번호가 틀립니다.\");"
				+ "history.back()"
				+ "</script>";
		}
		return res;
	}
	
	@GetMapping("databoard/update.do")
	public String databoard_update(int no, Model model)
	{
		// 이전 데이터를 읽어서 update.jsp로 전송
		DataBoardVO vo = dService.databoardUpdateData(no);
		model.addAttribute("vo", vo);
		
		return "databoard/update";
	}
	
	@PostMapping(value="databoard/update_ok.do", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String databoard_update_ok(DataBoardVO vo)
	{	
		String res = "";
		boolean bCheck = dService.databoardUpdate(vo);
		
		if(bCheck)
		{
			res="<script>"
				+ "location.href=\"detail.do?no="+vo.getNo()+"\""
				+ "</script>";
		}
		else
		{
			res="<script>"
				+ "alert(\"비밀번호가 틀립니다.\");"
				+ "history.back()"
				+ "</script>";
		}
	
		return res;
	}
}
