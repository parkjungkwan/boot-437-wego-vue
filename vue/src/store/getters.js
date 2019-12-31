import { mapGetters } from 'vuex'

export default {
  // ...
  computed: {
    // getter를 객체 전개 연산자(Object Spread Operator)로 계산하여 추가합니다.
    ...mapGetters([
      'doneTodosCount',
      'anotherGetter',
      // ...
    ])
  },
  
  getErrorState: state => state.errorState,
  getIsAuth: state => state.isAuth,
  getContext: state => state.context,
  getSidebars: state => state.sidebars,
  getHeaderMessage: state => state.headerMessage


}
  
   /*    [
        {menu:"학생목록",link:"/students"},
        {menu:"조건별 학생검색",link:"/studentsFindSome"},
				{menu:"학생성적수정",link:"/update"},
				{menu:"ID 학생검색",link:"/studentFindOne"}
			] */