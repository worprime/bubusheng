<template>
  <div class="login_container">
    <div class="login_box">
      <!-- 头像区域 -->
      <div>
        <h1 style="text-align: center;font-size: 30px;font-family: YouYuan;">后台管理</h1>
      </div>
      <!-- 登录表单区域 -->
      <el-form
        ref="loginFormRef"
        :model="loginForm"
        :rules="loginFormRules"
        label-width="0px"
        class="login_form"
      >
        <!-- 用户名 -->
        <el-form-item prop="username">
          <el-input v-model="loginForm.username" prefix-icon="iconfont person icon-person"></el-input>
        </el-form-item>
        <!-- 密码框 -->
        <el-form-item prop="password">
          <el-input
            v-model="loginForm.password"
            prefix-icon="iconfont lock icon-lock"
            type="password"
          ></el-input>
        </el-form-item>
        <!-- 提交按钮 -->
        <el-form-item class="btns">
          <el-button type="primary" @click="onSubmit">提交</el-button>
          <el-button type="info" @click="onReset">重置</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
  const axios = require('axios');
  import Vue from 'vue'

  export default {
    name: 'Login',
    beforeCreate() {
      document.querySelector('body').setAttribute('style', 'background-image: url("http://39.98.127.39:3000/group15/bubusheng/raw/master/vue_bubusheng/src/assets/background.jpg");background-size:100% 100%;')
    }
    ,
    data() {
      return {
        loginForm: {
          username: '',
          password: ''
        },
        loginFormRules: {
          username: [
            {required: true, message: '请输入用户名', trigger: 'blur'},
            {min: 3, max: 10, message: '长度在3-10位之间'}
          ],
          password: [
            {required: true, message: '请输入密码', trigger: 'blur'},
            {min: 6, max: 15, message: '长度在6-15位之间'}
          ]
        }
      }
    },
    methods: {
      onSubmit() {
        if (this.loginForm.username === ''){
          Vue.prototype.$message(
            {
              message: '您输入的用户名不能为空!',
              type: 'error'
            })
        }
        else if (this.loginForm.password === ''){
          Vue.prototype.$message(
            {
              message: '您输入的密码不能为空！',
              type: 'error'
            })
        }else {
          axios
            .get('http://localhost:8081/admin/Login', {
              params: {
                account: this.loginForm.username,
                password: this.loginForm.password
              }
            })
            .then(response => (this.getData(response.data)))
            .catch(function (error) { // 请求失败处理
              Vue.prototype.$message.error('请求失败')
            });
        }
      },
      getData(data) {
        if (data.isExist == true) {
          Vue.prototype.$message(
            {
              message: '登录成功',
              type: 'success'
            }
          )
          this.$cookies.set("uid", data.uid,"0");
          this.$router.push("Main");
        } else {
          Vue.prototype.$message.error('用户名或密码不正确');
        }
      }
      ,
      onReset() {
        // console.log(this)
        this.$refs.loginFormRef.resetFields()
      }

    }
  }
</script>

<style scoped>

  .login_container {
    background: #2b4b6b;
    height: 100%;
  }

  .login_box {
    width: 450px;
    height: 300px;
    background-color: #ffffff;
    border-radius: 3px;
    position: absolute;
    left: 50%;
    top: 50%;
    transform: translate(-50%, -50%);
  }


  .btns {
    display: flex;
    justify-content: flex-end;
  }

  .login_form {
    position: absolute;
    bottom: 0;
    width: 100%;
    padding: 0 20px;
    box-sizing: border-box;
  }
</style>
