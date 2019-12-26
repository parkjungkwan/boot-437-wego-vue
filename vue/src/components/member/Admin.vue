<template #content="content"><student-list></student-list></template>
<script>
import StudentList from "@/components/member/StudentList.vue"
import {store} from "../../store"
export default{
	components: {
		StudentList
	},
	data(){
		return {
			context : 'http://localhost:8080/',
			name: store.state.name,
			person : store.state.person,
			sidebars: [
						{menu:"학생등록",link:"/write"},
						{menu:"학생목록",link:"/list"},
						{menu:"학생정보수정",link:"/update"},
						{menu:"학생정보삭제",link:"/remove"},
						{menu:"학생검색",link:"/search"}],
			authCheck : true
		}
		
	}
}
</script>
<style scoped>
    .back {width: 700px; margin: 0 ;}
    .sub {width: 100%; height: 600px; margin: 0 auto; text-align: center;}
    .pull-left {float: left;}
    .pull-right {float: right;}
    .top {margin-top: 1%;}
    .rt {margin-right: 1%;}
    .size {width: 49.5%; height: 100%;}
</style>