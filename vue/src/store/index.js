import Vue from 'vue'
import Vuex from 'vuex'
import getters from '@/store/getters'
import mutations from '@/store/mutations'
import states from '@/store/states'
import person from '@/store/modules/person'
import article from '@/store/modules/article'

Vue.use(Vuex)

export const store = new Vuex.Store({
	modules: {
		states,
		getters,
		mutations,
		person,
		article

	},
	strict: true
  
})