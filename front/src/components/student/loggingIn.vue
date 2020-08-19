<template>
  <div id="login">
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
          <H3>登入</H3>
        </el-col>
      </el-row>
    </div>
    <div>
      <el-row :gutter="0" type="flex" justify="space-between" align="middle">
        <el-col :span="24">
          <p>请使用此页面来登录在线考试&培训系统。为了避免任何安全漏洞的机会，千万不要在其他网站上登入您的账号和密码。</p>
        </el-col>
      </el-row>
    </div>
    <div>
      <el-form :model="ruleForm" ref="ruleForm">
        <el-form-item label="手机号" prop="phone">
          <el-input v-model="ruleForm.phone" id="phone"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input v-model="ruleForm.password" id="password"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm('ruleForm')" >登入</el-button>
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
  name:"loggingIn",
  data() {
    return {
      ruleForm: {
        phone: '',
        password: ''
      }
    }
  },
  methods: {
    submitForm(ruleForm) {
      var result2;
      axios
        .get('http://localhost:8081/student/student/loginByAccoutAndPassword', {
          params: {
            phone:document.getElementById('phone').value,
            password:document.getElementById('password').value,
          }
        })
        .then(response => {
            var result = response.data.data;

            if(result==true) {
              axios
                  .get('http://localhost:8081/student/student/getStudentById', {
                     params: {
                         phone:document.getElementById('phone').value,
                     }
                   })
                  .then(response2 => {result2=response2;
                           this.$cookies.set("stuid", result2.data.data,"0");
                    })
            this.$router.push('/StudentMain');
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
