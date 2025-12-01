<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	1. vue
		1) 라이브러리 로드
			<script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
			<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
		2) 태그 안에 속성이나 데이터를 제어 : 디렉티브(v-)
			반복문 : v-for="vo in list"
								------ [{}, {}, {}...]
					v-for="() in list"
			조건문 : v-if="조건문"
					v-if ~ v-else
			양방향 : v-model="변수명"
			변수연결 : v-bind => :
			show/hide => v-show="조건"
		3)객체 생성
			Vue.createApp({
				// Model => 데이터 관리
				data(){ ======== setup()
					return {
						관리할 변수 설정
					}
				},
				mounted(){
					window.onload=function(){}
					$(function(){}))
				},
				computed:{
					숫자 변환 / 날짜 변환
				},
				watch:{
					component의 값이 변경되는 경우 감지
				},
				methods:{
					// 사용자 정의method
				},
				components:{
					
				}
			)}.mounted("제어하는 HTML 영역")
						--------------- View
			1) ViewModel에서 데이터 변경
				=> 이벤트 / 서버에서 값 읽기
			2) Model에 저장
			3) Model에 저장된 값을 View(HTML)로 전송
			  ------------ MVVM(***)
			
			생명주기
			created = mounted = updated = unmounted
 --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.row{
	margin: 0px auto;
	width: 900px;
}
</style>
<script src="http://code.jquery.com/jquery.js"></script>
</head>
<body>
	<div class="container" id="food_detail">
		<div class="row">
			<table class="table">
				<tr>
					<td width="30%" class="text-center" rowspan="9">
						<img :src="vo.poster" style="width:100%">
					</td>
					<td colspan="2">
						<h3><span id="name">{{vo.name}}&nbsp;</span><span style="color:orange">{{vo.score}}</span></h3>
					</td>
				</tr>
				<tr>
					<td width="15%" style="color:gray">주소</td>
					<td width="55%">{{vo.address}}</td>
				</tr>
				<tr>
					<td width="15%" style="color:gray">전화</td>
					<td width="55%">{{vo.phone}}</td>
				</tr>
				<tr>
					<td width="15%" style="color:gray">음식 종류</td>
					<td width="55%">{{vo.type}}</td>
				</tr>
				<tr>
					<td width="15%" style="color:gray">가격대</td>
					<td width="55%">{{vo.price}}</td>
				</tr>
				<tr>
					<td width="15%" style="color:gray">주차</td>
					<td width="55%">{{vo.parking}}</td>
				</tr>
				<tr>
					<td width="15%" style="color:gray">영업시간</td>
					<td width="55%">{{vo.time}}</td>
				</tr>
				<tr>
					<td width="15%" style="color:gray">테마</td>
					<td width="55%">{{vo.theme}}</td>
				</tr>
				<tr>
					<td width="15%" style="color:gray">좋아요</td>
					<td width="55%">{{like}}</td>
				</tr>
			</table>
			<table class="table">
				<tr>
					<td>{{vo.context}}</td>
				</tr>
				<tr>
					<td class="text-right">
						<a href="javascript:history.back()" class="btn bnt-sm btn-danger">목록</a>
					</td>
				</tr>
			</table>
			<table class="table">
				<tr>
					<td>
						<div id="map" style="width:100%;height:350px;"></div>
					</td>
				</tr>
			</table>
		</div>
	</div>
<script>
	let detailApp=Vue.createApp({
		data(){
			return {
				vo:{},
				images:[],
				fno:${fno}
			}
		},
		mounted(){
			axios.get('../food/detail_vue.do',{
				params:{
					fno:this.fno
				}
			}).then(response=>{
				console.log(response.data)
				this.vo=response.data
				this.images=response.data.images.split(",")
				if(window.kakao && window.kakao.maps)
				{
					this.initMap()
				}
				else
				{
					this.addScript()	
				}
			})
		},
		computed:{
			like(){
				return parseInt(this.vo.likecount).toLocaleString()
			}
		},
		methods:{
			addScript(){
				const script=document.createElement("script")
				/* global kakao */
				script.onload=()=>kakao.maps.load(this.initMap)
				script.src="http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=6ae49e824de560c4d4a79bf5be38eee9&libraries=services"
				document.head.appendChild(script)
			},
			initMap(){
				var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
			    mapOption = {
			        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
			        level: 3 // 지도의 확대 레벨
			    };  

			// 지도를 생성합니다    
			var map = new kakao.maps.Map(mapContainer, mapOption); 

			// 주소-좌표 변환 객체를 생성합니다
			var geocoder = new kakao.maps.services.Geocoder();

			// 주소로 좌표를 검색합니다
			geocoder.addressSearch(this.vo.address, function(result, status) {

			    // 정상적으로 검색이 완료됐으면 
			     if (status === kakao.maps.services.Status.OK) {

			        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

			        // 결과값으로 받은 위치를 마커로 표시합니다
			        var marker = new kakao.maps.Marker({
			            map: map,
			            position: coords
			        });

			        // 인포윈도우로 장소에 대한 설명을 표시합니다
			        var infowindow = new kakao.maps.InfoWindow({
			            content: '<div style="width:150px;text-align:center;padding:6px 0;">'+$('#name').text()+'</div>'
			        });
			        infowindow.open(map, marker);

			        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
			        map.setCenter(coords);
			    } 
			});    
			}
		}
	}).mount("#food_detail")
</script>
</body>
</html>