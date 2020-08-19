<template>
  <div>
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item class="text" style="font-size: 20px">{{lastPathName}}</el-breadcrumb-item>
      <el-breadcrumb-item class="text" style="font-size: 20px">申請信息</el-breadcrumb-item>
    </el-breadcrumb>
    <h1 class="text" style="margin-left: 40%;font-size: 34px">課程申請</h1>
    <el-card class="box-card" style="width: 80%;text-align: center;margin-left: 40px">
      <template>
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="ID:" class="text">{{form.id}}
          </el-form-item>
          <el-form-item label="課程名稱:" class="text">{{form.className}}
          </el-form-item>
          <el-form-item label="課程类型:" class="text">{{form.type}}
          </el-form-item>
          <el-form-item label="教師Id:" class="text">{{form.teacherId}}
          </el-form-item>
          <el-form-item label="教師:" class="text">{{form.teacherName}}
          </el-form-item>
          <el-form-item label="開課時間:" class="text">{{form.beginning}}
          </el-form-item>
          <el-form-item label="簡介:" class="text">{{form.intro}}
          </el-form-item>
          <el-form-item label="結果:" class="text" v-show="isShow!=true">{{form.result}}
          </el-form-item>
          <el-form-item v-show="isShow">
            <el-button type="primary" @click="onSubmit" class="text">审核通過</el-button>
            <el-button type="primary" @click="unSubmit" class="text">审核不通過</el-button>
          </el-form-item>
        </el-form>
      </template>
    </el-card>
  </div>
</template>

<script>

  const axios = require('axios');
  import Vue from 'vue'

  export default {
    name: "AuditDetailPage",
    created() {
      this.lastPathName = this.$route.query.lastPathName
      this.setData(this.$route.query.form);
    },
    data() {
      return {
        form: {
          id: '',
          className: '',
          type: '',
          teacherId: '',
          teacherName: '',
          beginning: '',
          intro: '',
          result: ''
        },
        lastPathName: '',
        isShow:false
      }
    },
    methods: {
      onSubmit() {
        axios
          .get('http://localhost:8081/admin/SubmitAudit', {
            params: {
              id: this.form.id
            }
          })
          .then(response => {
            if (response.data.status===200) {
              Vue.prototype.$message(
                {
                  message: '提交成功',
                  type: 'success'
                }
              )
              this.$router.back(-1);
            }else{
              Vue.prototype.$message.error('提交失敗');
            }

          })
          .catch(function (error) { // 请求失败处理
            Vue.prototype.$message.error('提交失敗');
          });
      },
      unSubmit() {
        axios
          .get('http://localhost:8081/admin/unSubmitAudit', {
            params: {
              id: this.form.id
            }
          })
          .then(response => {
            if (response.data.status===200) {
              Vue.prototype.$message(
                {
                  message: '提交成功',
                  type: 'success'
                }
              )
              this.$router.back(-1);
            }else{
              Vue.prototype.$message.error('提交失敗');
            }

          })
          .catch(function (error) { // 请求失败处理
            Vue.prototype.$message.error('提交失敗');
          });
      },
      setData(data) {
        this.form = {
          id: data.id,
          className: data.className,
          type: data.type,
          teacherId: data.teacherId,
          teacherName: data.teacherName,
          beginning: data.beginning,
          intro: data.intro,
          applicationTime: data.applicationTime,
          result: data.result,
          desc: data.desc
        };
        this.id = data.id
        if (data.result==="未审核"){
          this.isShow = true
        }
      }
    }
  }
</script>

<style scoped>
  .text {
    font-size: 16px;
    font-family: YouYuan;
    text-align: left;
  }
</style>
