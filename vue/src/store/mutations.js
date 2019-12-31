import * as types from '@/store/mutation_types'

export default {
  [types.PERSON] (state, person) {
    state.person = person
  },
  [types.ERROR_STATE] (state, errorState) {
    state.errorState = errorState
  },
  [types.IS_AUTH] (state, isAuth) {
    state.isAuth = isAuth
  },
  [types.CONTEXT] (state, context) {
    state.context = context
  },
  [types.SIDEBARS] (state, sidebars) {
    state.sidebars = sidebars
  },
  [types.HEADER_MESSAGE] (state, headingMessage) {
    state.headingMessage = headingMessage
  }
}

