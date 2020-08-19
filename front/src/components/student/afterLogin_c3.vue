<template>
  <div>
  <el-form ref="form" :model="form" label-width="80px">
    <el-form-item label="用户名">
      <el-input v-model="form.name" id="name"></el-input>
    </el-form-item>
    <el-form-item label="性别">
        <el-input v-model="form.sex" id="sex"></el-input>
    </el-form-item>
    <el-form-item label="年龄">
      <el-input v-model="form.age" id="age"></el-input>
    </el-form-item>
    <el-form-item label="手机号">
      <el-input v-model="form.phone" id="phone"></el-input>
    </el-form-item>
    <el-form-item label="密码">
      <el-input v-model="form.password" id="password"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="onSubmit">更改提交</el-button>
      <el-button>取消</el-button>
    </el-form-item>
  </el-form>
  </div>
</template>

<script>
var temp;
const axios=require('axios');
export default {
  name: "afterLogin_c3",
  data(){
    return {
      form: {
        name: '',
        region: '',
        date1: '',
        date2: '',
        delivery: false,
        type: [],
        resource: '',
        desc: '',
        id:''
      }
    }
  },
  created(){
    //初始化工作
    if(this.$cookies.isKey("stuid")){
      temp = this.$cookies.get("stuid");
    }
    axios
      .get('http://localhost:8081/student/student/getAllStudent', {
        params: {
          id:temp
        }
      })
      .then(response => {
           document.getElementById("name").value=response.data.data.studentName;
           document.getElementById("sex").value=response.data.data.sex;
           document.getElementById("age").value=response.data.data.age;
           document.getElementById("phone").value=response.data.data.phone;
           document.getElementById("password").value=response.data.data.password;
      })
  },
  methods: {
    onSubmit() {
      axios
        .get('http://localhost:8081/student/student/updateStudent', {
          params: {
            stuId:temp,
            stuName:document.getElementById("name").value,
            sex:document.getElementById("sex").value,
            age:document.getElementById("age").value,
            password:document.getElementById("password").value,
            phone:document.getElementById("phone").value
          }
        })
        .then(response => {
          var success=response.data;
          console.log(success);
          if(success==true){
            alert("个人信息更改成功！");
          }

        })
    }
  }
}
</script>

<style scoped>

</style>
