<template>
<div>	
     <a @click.prevent="logout">로그아웃</a>
     <a @click.prevent="widthdrawal">회원탈퇴</a>
</div>
</template>
<script>
import axios from "axios"
import {store} from "../../store"
export default{
    methods : {
        logout(){
            store.state.person = {}
            store.state.authCheck = false
            store.state.sidebar = 'preSidebar'
            this.$router.push({path: '/login'})
            },
            withdrawal(){
                axios
                .delete(`${this.context}/withdrawal/${store.state.person.userid}`)
                .then(
                    alert(`회원탈퇴 성공`)
                )
                .catch(()=>{
                    alert(`회원탈퇴 실패`)
                })
                this.$router.push({path: '/login'})
            }
    }
    
}
</script>
