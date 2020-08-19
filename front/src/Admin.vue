<template>
  <div id="admin" style="height: 100%">
    <router-view></router-view>
  </div>
</template>

<script>
  import AdminMainPage from "../../../front/src/components/Admin/AdminMainPage"
  import Login from "../../../front/src/components/Admin/Login"
  import Vue from 'vue'
  const axios = require('axios');
  export default {
    name: 'Admin',
    components: {
      Login,
      AdminMainPage
    },
    created() {
      if (this.$cookies.isKey('uid')) {
        axios
          .get('http://localhost:8081/admin/Login', {
            params: {
              uid: this.$cookies.get("uid")
            }
          })
          .then(response => (this.isExist(response.data)))
          .catch(function (error) { // 请求失败处理
            Vue.prototype.$message.error('请求失败')
          })
      } else {
        this.$router.push("/Login");
      }

    }
    , beforeCreate() {
      document.querySelector('body').setAttribute('style', 'margin: 0;height: 100%;'),
        document.querySelector('html').setAttribute('style', 'height: 100%;')
    },
    beforeDestroy() {
      document.querySelector('body').removeAttribute('style'),
        document.querySelector('html').removeAttribute('style')
    },
    methods: {
      isExist(data) {
        if (data.isExist == true) {
          this.$router.push("/Main");
        }
      }
    }
  }
</script>

<style scoped>

</style>
