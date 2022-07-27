import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

import search from "./modules/search";

export default new Vuex.Store({
  state: {},
  getters: {},
  mutations: {},
  actions: {},
  modules: {
    search: search,
  },
});
