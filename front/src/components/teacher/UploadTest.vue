<template>
  <div class="container">
    <el-form ref="form" :model="form" label-width="80px">
      <el-form-item label="课程编号">
        <el-input v-model="form.classId"></el-input>
      </el-form-item>
      <el-form-item label="考试时间">
        <el-col :span="11">
          <el-time-picker  placeholder="选择开始时间" v-model="form.testTime" style="width: 100%;"></el-time-picker>
        </el-col>
        <el-col class="line" :span="2">-</el-col>
        <el-col :span="11">
          <el-time-picker placeholder="选择截止时间" v-model="form.deadline" style="width: 100%;"></el-time-picker>
        </el-col>
      </el-form-item>
      <el-form-item label="上传试卷">
        <el-upload class="Upload"
                   drag
                   name="test"
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
name: "UploadTest",
  data(){
  return{
    form:{
      classId:2020111,
      testTime:'',
      deadline:'',

    },
  }
  },
  methods:{

    changFile(file, fileList) {
      console.log(fileList);
      //选择文件后，给fileList对象赋值
      this.fileList = fileList
    },

    onUpload(){


        let data = new FormData();

        // todo 非常重要，一定要加file.raw，从浏览器中查看需要使用binary类型，后台才能正确接收
        this.form.files = this.fileList[0].raw
        console.log(this.fileList[0].raw)


        // 将form表单中的值都赋值给FormData传递给后台
        for(let key in this.form){
          console.log(this.form[key])
          data.append(key,this.form[key])
        }

        this.axios
          .get('http://localhost:8081/course/coursedata/course/insertTestpaper',
            {data}
            )// 第一种，直就传个json数据，不需要设置headers

          // .post('/user/apply',this.form)// 第三种，可以直接传递这个form（推荐）

          .then(resp => {
            console.log('请求本地接口OK')
            this.$message({
              message: "上传成功",
              type: 'success'
            });
          })
          .catch(function (error) { // 请求失败处理
            console.log('上传失败' + error);
            this.$message({
              message: "上传失败",
              type: 'error'
            });
          });
      },
  },
}
</script>

<style scoped>
 .container{
   margin-left: 20%;
   margin-right: 20%;
 }
</style>
