<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../js/pagecard.js"></script>
<style type="text/css">
.row {
  margin: 0px auto;
  width:960px;
}
p{
   overflow: hidden;
   white-space: nowrap;
   text-overflow: ellipsis;
}
.nav-link{
  cursor: pointer;
}
</style>
</head>
<body>
  <div class="container" id="goods_list">
    <div class="row">
      <div class="col-md-3" v-for="vo in list">
		    <div class="thumbnail">
		      <a :href="'../goods/detail.do?no='+vo.no">
		        <img :src="vo.goods_poster" style="width:240px;height: 160px">
		        <div class="caption">
		          <p>{{vo.goods_name}}</p>
		        </div>
		      </a>
		    </div>
		</div>
    </div>
    <div class="row text-center" style="margin-top: 10px">
        <pagecard></pagecard>
    </div>
  </div>
  <script>
   let app=Vue.createApp({
	   data(){
		   return {
			   list:[],
			   startPage:0,
			   endPage:0,
			   totalpage:0,
			   curpage:1
		   }
	   },
	   mounted(){
		   this.dataRecv()
	   },
	   methods:{
		   dataRecv(){
			   axios.get('http://localhost:8080/web/goods/list_vue.do',{
				   params:{
					   page:this.curpage
				   }
			   }).then(response=>{
				  console.log(response.data) 
				  this.list=response.data.list
				  this.curpage=response.data.curpage
				  this.totalpage=response.data.totalpage
				  this.startPage=response.data.startPage
				  this.endPage=response.data.endPage
			   })
		   },
		   range(start,end){
			   let arr=[]
			   let len=end-start
			   for(let i=0;i<=len;i++)
			   {
				  arr[i]=start
				  start++
			   }
			   return arr
		   },
		   prev(page){
			   this.curpage=page
			   this.dataRecv()
		   },
		   next(page){
			   this.curpage=page
			   this.dataRecv()
		   },
		   pageChange(page){
			   this.curpage=page
			   this.dataRecv()
		   }
	   },
	   components:{
		   'pagecard':pagecard
	   }
   }).mount("#goods_list")
  </script>
</body>
</html>