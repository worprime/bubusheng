<template>
  <div class="container">
    <el-form ref="form" :model="form" label-width="160px">
      <el-form-item label="公告标题">
        <el-input v-model="form.title"></el-input>
      </el-form-item>
      <el-form-item label="公告内容">
        <el-input type="textarea" v-model="form.desc"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit" id="btn">发布公告</el-button>
        <el-button>取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
// const classId = UrlParam.paramValues("classid");

const axios = require('axios');
export default {

  name: "Announce",


  data() {
    return {
      form: {
        title: '',
        desc: '',
      }

    }
  },
  methods: {
    //   onSubmit()
    //   {
    //     this.$axios({
    //       url: 'http://localhost:8081/course/notice/course/insertNotice',
    //       method: 'GET',
    //       params: {
    //         classId:2020002,
    //         notice: this.form.desc,
    //         time:new Date().toLocaleString(),
    //         noticeName: this.form.title,
    //       },
    //       data: {},
    //       headers: {}
    //     }).then(response =>{
    //     console.log("发布成功！")// response是http状态2xx的响应结果，响应数据是response.data
    //     }).catch(error =>{
    //     console.log(error);// error是http状态4xx、5xx的响应结果，错误响应对象是error.response，错误响应数据是error.response.data
    //     })}
    // }

    onSubmit() {
      axios
        .get('http://localhost:8081/course/notice/course/insertNotice', {
          params: {
            classId: 2020111,
            notice: this.form.desc,
            time: new Date().toLocaleString(),
            noticeName: this.form.title,
          }
        })
        .then(response => {
          if (response.data.status===200) {
            Vue.prototype.$message.success('提交成功');
          }else{
            Vue.prototype.$message.error('提交失敗');
          }
        })
        .catch(function (error) { // 请求失败处理
          Vue.prototype.$message.error('提交失敗');
        });
    },

  }
}

</script>

<style scoped>
.container{
  margin-right: 20%;
  margin-left: 20%;
}
</style>
