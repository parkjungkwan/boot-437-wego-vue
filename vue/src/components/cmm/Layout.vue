<template>
	<div id="wrapper">
		<header>
			<div v-switch="headingCheck">
                    <h2 v-case="admin">관리자 화면</h2>
                    <h2 v-case="student">학생화면</h2>
                    <h2 v-case="preAuth">공통화면 </h2>
               </div>
		</header>
		<aside id="sidebar">
			<slot name="sidebar"></slot>
		</aside>
		<section id="content">
			<slot name="content" :title="contnent"></slot>
		</section>
		<footer>
			<slot name="footer" :title="footer"></slot>
		</footer>
	</div>
</template>
<script>
import { vSwitch, vCase, vDefault } from 'v-switch-case'
import {store} from "../../store"
export default {
	data(){
		return {
               header : '헤더부분',
               contnent : '컨텐츠부분',
               footer : '푸터부분'
		}
     },
     directives: {
          'switch': vSwitch,
          'case': vCase,
          'default': vDefault
     },
	computed:{
		headingCheck: function(){
			return store.state.headingType
		}
	}
		
}
</script>
<style scoped>
/* 전체 구조 */
#wrapper {
     padding: 5px;
     width: 960px;
     margin: 20px auto;
}
header {
     height: 100px;
     padding: 0 15px;
}
#content {
     width: 696px;
     float: left;
     padding: 5px 15px;
    min-height: 300px;
}
#sidebar {
     width: 200px;
     padding: 5px 15px;
     float: left;
}
footer {
     clear: both;
     padding: 0 15px;
}
/* 가로폭 980보다 작을 때 사용할 @media query */
@media screen and (max-width: 980px) {     
     #pagewrap {
           width: 94%;
     }
     #content {
           clear: both;
           padding: 1% 4%;
           width: auto;
           float: none;
     }
     #sidebar {
           clear: both;
           padding: 1% 4%;
           width: auto;
           float: none;
     }
     header, footer {
           padding: 1% 4%;
     }
}
/* 공통 */
#content {
     background: #f8f8f8;
}
#sidebar {
     background: #f0efef;
}
header, #content, #middle, #sidebar {
     margin-bottom: 5px;
}
#pagewrap, header, #content, #middle, #sidebar, footer {
     border: solid 1px #ccc;
}
</style>