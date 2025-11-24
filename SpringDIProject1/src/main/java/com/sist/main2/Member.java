package com.sist.main2;

public class Member {
   private int no;
   private String name;
   private String address;
   
   public Member(int no, String name, String address) {
      this.no = no;
      this.name = name;
      this.address = address;
   }
   
   public Member() {
      
   }

   public int getNo() {
      return no;
   }

   public void setNo(int no) {
      this.no = no;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }
   
   public void init() {
      System.out.println("===== 사원 정보 =====");
   }
   
   public void destroy() {
      System.out.println("프로그램 종료");
   }
   // 개발자가 호출
   // 생성 = 소멸 = 초기값 대입
   
   public void print() {
      System.out.println("번호: " + no);
      System.out.println("이름: " + name);
      System.out.println("주소: " + address);
   }
}
