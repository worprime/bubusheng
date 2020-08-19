<template>
  <div class="container">
    <el-form ref="form" :model="form" label-width="80px">
      <el-form-item label="课程章节">
        <el-input v-model="form.chapter"></el-input>
      </el-form-item>
      <el-form-item label="上传课件">
        <el-upload class="Upload"
                   drag
                   name="ppt"
                   multiple>
          <i class="el-icon-upload"></i>
          <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
        </el-upload>
      </el-form-item>
      <el-form-item label="上传文档">
        <el-upload class="Upload"
                   drag
                   name="document"
                   multiple>
          <i class="el-icon-upload"></i>
          <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
        </el-upload>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onUpload">确认上传</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
// const classId = UrlParam.paramValues("classid");
const axios = require('axios');
export default {
name: "UploadCourse",
  data(){
    return{
      form:{
        chapter:'第一章'
      }
    }
  },
  methods:{
    onUpload() {
        {
          axios
            .post('http://localhost:8081/course/coursedata/course/uploadData',{
              params:{
                classId:2020111,
                chapter: this.form.chapter,
                ppt: this.ppt,
                document:this.document,
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
        }
      }


  }
}
</script>

<style scoped>
.container{
  margin-left: 20%;
  margin-right: 20%;
}
</style>
