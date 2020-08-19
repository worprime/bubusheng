<template>
  <div>
    <div class="header">
      <el-row :gutter="0" type="flex" justify="space-between" align="middle">
        <el-col :span="24">
          <H3>在线考试&培训系统</H3>
        </el-col>
      </el-row>
      <el-row :gutter="0" type="flex" justify="space-between" align="left" margin-top="20px">
        <el-divider width="70%"></el-divider>
      </el-row>
    </div>
    <div>
      <el-row :gutter="0" type="flex" justify="space-between" align="middle">
        <el-col :span="24">
          <H3>注册</H3>
        </el-col>
      </el-row>
    </div>
    <div>

    </div>
    <div>
      <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
        <el-form-item label="手机号" prop="phone">
          <el-input v-model="ruleForm.phone" id="phone"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password" >
          <el-input type="password" v-model="ruleForm.password" id="password"></el-input>
        </el-form-item>
        <el-form-item label="用户名" prop="username">
          <el-input v-model="ruleForm.username"  id="username"></el-input>
        </el-form-item>
        <el-form-item label="年龄" prop="age" >
          <el-input v-model="ruleForm.age" id="age"></el-input>
        </el-form-item>
        <el-form-item label="性别" prop="sex">
          <el-input v-model="ruleForm.sex"  id="sex"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm('ruleForm')">注册</el-button>
          <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
      </el-form>
    </div>
    <div class="hello bg-purple">
      <p>联系我们：15043466013</p>
    </div>
  </div>
</template>

<script>
const axios=require('axios');
export default {
  name:"register",
  data() {
    return {
      ruleForm: {
        phone:'',
        password:'',
        stuName:'',
        age: '',
        sex:''
      },
    };
  },
  methods: {
    submitForm(formName) {
      axios
        .get('http://localhost:8081/student/student/insertStudent', {
          params: {
            stuName:document.getElementById('username').value,
            sex:document.getElementById('sex').value,
            age:document.getElementById('age').value,
            password:document.getElementById('password').value,
            phone:document.getElementById('phone').value
          }
        })
        .then(response => {
          var result = response.data.data;
          if(result==true) {
            console.log("成功了");
            this.$router.push('/afterLogin');
          }
        })
        .catch(function (error) { // 请求失败处理
          console.log(error);
        });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  }
}

</script>

<style scoped>

.bg-purple {
  background: #d3dce6;
}

</style>
