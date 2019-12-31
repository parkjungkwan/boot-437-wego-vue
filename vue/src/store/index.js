import Vue from 'vue'
import Vuex from 'vuex'
import getters from '@/store/getters'
import actions from '@/store/actions'
import mutations from '@/store/mutations'
import states from '@/store/states'

Vue.use(Vuex)

export const store = new Vuex.Store({
	modules: {
		states,
		getters,
		actions,
		mutations
	},
	strict: true
  
})