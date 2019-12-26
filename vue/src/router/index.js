import Vue from 'vue'
import Router from 'vue-router'
import List from '@/components/board/List'
import Remove from '@/components/board/Remove'
import Search from '@/components/board/Search'
import Update from '@/components/board/Update'
import Write from '@/components/board/Write'
import Join from '@/components/member/Join'
import Login from '@/components/member/Login'
import MyPage from '@/components/member/MyPage'
import MyPageUpdate from '@/components/member/MyPageUpdate'
import Admin from '@/components/member/Admin'

Vue.use(Router)

export default new Router({
	mode: 'history',
	routes : [
		{path: '/list',name: 'list', component: List},
		{path: '/remove',name: 'remove', component: Remove},
		{path: '/update',name: 'update', component: Update},
		{path: '/search',name: 'search', component: Search},
		{path: '/write',name: 'write', component: Write},
		{path: '/join',name: 'join', component: Join},
		{path: '/login',name: 'login', component: Login},
		{path: '/myPage',name: 'myPage', component: MyPage},
		{path: '/myPageUpdate',name: 'myPageUpdate', component: MyPageUpdate},
		{path: '/admin',name: 'admin', component: Admin}
	]
})