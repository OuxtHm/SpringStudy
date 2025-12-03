<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
<style type="text/css">
.row{
	margin: 0px auto;
	width: 960px;
}

</style>
</head>
<body>
	<div class="container" id="detail_app">
		<div class="row">
			<h1 class="text-center">상품 상세보기</h1>
			<table class="table">
				<tbody>
					<tr>
						<td class="text-center" width="40%" rowspan="5">
							<img :src="vo.goods_poster" style="width: 100%">
						</td>
						<td colspan="2">
							<b>{{vo.goods_name}}</b>
						</td>
					</tr>
					<tr>
						<td colspan="2">{{vo.goods_sub}}</td>
					</tr>
					<tr>
						<td width=25%>{{vo.goods_discount}}%</td>
						<td width=35%>{{vo.goods_price}}</td>
					</tr>
					<tr>
						<td width=25%>배송</td>
						<td width=35%>무료</td>
					</tr>
					<tr>
						<td colspan="2" class="text-center">
							<button type=button class="btn-lg btn-primary" @click="buyBtn()">구매</button>
							<button type=button class="btn-lg btn-primary" @click="go()">목록</button>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
<script>
   var IMP = window.IMP; 
   IMP.init("imp68206770");
   let detailApp=Vue.createApp({
	   data(){
		   return {
			   vo:{},
			   no:${no}
		   }
	   },
	   mounted(){
		   axios.get('http://localhost:8080/web/goods/detail_vue.do',{
			   params:{
				   no:this.no
			   }
		   }).then(response=>{
			   console.log(response.data)
			   this.vo=response.data
		   })
	   },
	   methods:{
		   go(){
			  location.href="../goods/list.do";  
		   },
		   buyBtn(){
			 this.requestPay(this.vo.goods_name,this.vo.price)  
		   },
		   requestPay(name,price) {
			    IMP.request_pay({
			        pg: "html5_inicis",
			        pay_method: "card",
			        merchant_uid: "ORD20180131-0000011",   // 주문번호
			        name: name ,
			        amount: price,         // 숫자 타입
			        buyer_email: '',
			        buyer_name: '',
			        buyer_tel:'',
			        buyer_addr: '',
			        buyer_postcode: ''
			    }, function (rsp) { // callback
			    	
			    	alert("구매가 완료되었습니다.\n마이페이지에서 확인하세요")
			    	
			   });
			}
	   }
   }).mount("#detail_app")
  </script>
</html>