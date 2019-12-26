<template>
	<div id="app">
		<layout>
			<template #header="header">
				<h1>{{header.title}}</h1>
				<component :is="!loginCheck ? 'pre-auth' : 'post-auth'"></component>
			</template>
			<template #sidebar="sidebar">
				<div v-switch="sidebarType">
					<div v-case="'sidebar-type'">
						<ul class="menu">
							<li v-for="i of preSidebars" :key="i.menu" >
								<router-link :to="i.link">{{i.menu}}</router-link>
							</li>
						</ul>
					</div>
					<div v-case="'sidebar-type'">
						<ul class="menu">
								<li v-for="i of managerSidebars" :key="i.menu" >
									<router-link :to="i.link">{{i.menu}}</router-link>
								</li>
						</ul>
					</div>
					<div v-case="'sidebar-type'">
						<ul class="menu">
								<li v-for="i of studentSidebars" :key="i.menu" >
									<router-link :to="i.link">{{i.menu}}</router-link>
								</li>
						</ul>
					</div>
				</div>
			</template>
			<!--<template #sidebar="sidebar"> </template> -->
			<template #content="content"><router-view/></template>
			<template #footer="footer">{{footer.title}}</template>
		</layout>
	</div>
</template>
<script>
import Layout from "@/components/cmm/Layout.vue"
import PostAuth from "@/components/cmm/PostAuth.vue"
import PreAuth from "@/components/cmm/PreAuth.vue"
import ManagerSidebars from "@/components/cmm/ManagerSidebars.vue"
import PreSidebars from "@/components/cmm/PreSidebars.vue"
import StudentSidebars from "@/components/cmm/StudentSidebars.vue"
import { store } from "@/store"

 

export default{
	components : {Layout, PreAuth, PostAuth,
	ManagerSidebars, PreSidebars, StudentSidebars
	},
	data(){
		return {
			managerSidebars: [
				{menu:"글쓰기",link:"/write"},
				{menu:"학생목록",link:"/list"},
				{menu:"학생성적수정",link:"/update"},
				{menu:"글삭제",link:"/remove"},
				{menu:"검색",link:"/search"}
			],
			studentSidebars: [
				{menu:"내정보보기",link:"/write"},
				{menu:"비밀번호변경",link:"/write"},
				{menu:"글쓰기",link:"/write"},
				{menu:"목록",link:"/list"},
				{menu:"글수정",link:"/update"},
				{menu:"글삭제",link:"/remove"},
				{menu:"검색",link:"/search"}
			],
			preSidebars: [
				{menu:"게시글 목록",link:"/list"},
				{menu:"게시글 검색",link:"/search"}
			],

			sidebarType: 'sidebar-type'
		}
	},
	computed:{
		loginCheck: function(){
			return store.state.authCheck
		}
		
	}
}
</script>
<style scoped>
ul.menu {
    position:relative;
    padding: 5px 5px 5px 5px;
    list-style: none;
    font-style: italic;
}
ul.menu a {
    text-decoration:none;
}
</style>