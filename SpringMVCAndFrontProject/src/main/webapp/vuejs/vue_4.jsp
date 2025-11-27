<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container {
	margin-top: 50px;
}

.row {
	margin: 0px auto;
	width: 800px;
}
</style>
</head>
<body>
	<div class="container">
		<h1 class="text-center">Vue 생명주기(생명 ~ 소멸)</h1>
		<div class="row">
			입력:<input type="text" size=30 class="input-sm" v-model="msg">
			<p>
				{{msg}}
			</p>
		</div>
	</div>
<script>
	let a=Vue.createApp({
		// Model => 데이터 관리
		// data() 안에 있는 변수가 변경이 되면 바로 HTML에 적용
		/* 
			설정 변수
				정수
				no : 0,
				no: 0.0,
				bCheck : false,
				msg:'',
				detail:{} => VO 단위
				list:[] => List단위
		*/
		data(){
				return {
					msg:''
				}
		},
		beforeCreate(){
			console.log("Vue 객체 생성전 : beforeCreate() Call")
			// componentWillCreate()
		},
		create(){
			console.log("Vue 객체 생성 완료 : create() Call")
			// componsentDidCreate()
		},
		beforeMount(){
			console.log("브라우저 화면 출력 전 : beforeMount() Call")
			// comopnentWillMount()
		},
		mounted(){
			console.log("브라우저 화면 출력 완료 : mounted() Call")
			// $(function()), window.onload
			// componentDidMount()
		},
		beforeUpdate(){
			console.log("데이터를 변경하기 전 : beforeUpdate() Call")
			// componenetWillUpdate()
		},
		updated(){
			console.log("데이터 변경 완료 : updated() Call")
			// componentDidUpdate()
		},
		beforeUnmount(){
			console.log("다른 화면 이동 전 : beforeUnmount() Call")
			// componentWillUnMount()
		},
		unmounted(){
			console.log("다른 화면 이동 완료: Vue 객체 소멸 : unmounted() Call")
			// componentDidUnMount()
		}/*
		methods:{
			// 사용자 정의 함수
		},
		components:{
			
		},
		computed:{
			
		},
		watch:{
			
		}*/
	}).mount(".container")
</script>
</body>
</html>