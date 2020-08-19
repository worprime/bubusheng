<template>
<div class="container">
  <el-form ref="form" :model="form" label-width="80px">
    <el-form-item label="课程名">
      <el-input v-model="form.name"></el-input>
    </el-form-item>
    <el-form-item label="授课老师">
      <el-input v-model="form.teacher"></el-input>
    </el-form-item>
    <el-form-item label="课程简介">
      <el-input type="textarea" v-model="form.desc"></el-input>
    </el-form-item>
    <el-form-item label="课程时间">
      <el-col :span="11">
        <el-date-picker type="date" placeholder="选择日期" v-model="form.date1" style="width: 100%;"></el-date-picker>
      </el-col>
    </el-form-item>
    <el-form-item label="课程类型">
      <el-input v-model="form.type"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="onSubmit">保存信息</el-button>
      <el-button>取消</el-button>
    </el-form-item>
  </el-form>
</div>
</template>

<script>
// const classId = UrlParam.paramValues("classId");
const axios = require('axios');
export default {
  name: "TeacherCourse",
  data() {
    return {
      form: {
        name: '',
        teacher: '',
        desc: '',
        date1: '',
        date2: '',
        time: '',


      }
    }
  },
  methods: {
    onSubmit() {
      {
        {
          axios
            .get('http://localhost:8081/course/course/course/updateCourse', {
              params: {
                classId: 2020111,
                teacherName: this.form.teacher,
                className: this.form.name,
                intro: this.form.desc,
                beginning: this.form.date1,
                type: this.type,
              }
            })
            .then(response => {
              if (response.data.status === 200) {
                Vue.prototype.$message.success('提交成功');
              } else {
                Vue.prototype.$message.error('提交失敗');
              }
            })
            .catch(function (error) { // 请求失败处理
              Vue.prototype.$message.error('提交失敗');
            });
        }
      }
    }
  }
}
</script>

<style scoped>
 .container{
   margin-right: 20%;
   margin-left: 20%;

 }
</style>
