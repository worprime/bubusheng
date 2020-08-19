<template>
  <div>
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item class="text" style="font-size: 20px">學生管理</el-breadcrumb-item>
      <el-breadcrumb-item class="text" style="font-size: 20px">學生信息</el-breadcrumb-item>
    </el-breadcrumb>
    <h1 class="text" style="margin-left: 40%;font-size: 34px">學生信息</h1>
    <el-card class="box-card" style="width: 80%;text-align: center;margin-left: 40px">
      <el-form ref="form" :model="form" label-width="80px">
        <el-form-item label="ID:" class="text">
          {{form.studentId}}
        </el-form-item>
        <el-form-item label="名稱:" class="text">
          {{form.studentName}}
        </el-form-item>
        <el-form-item label="性別:" class="text">
          {{form.sex}}
        </el-form-item>
        <el-form-item label="手机:" class="text">
          {{form.phone}}
        </el-form-item>
        <el-form-item label="年齡:" class="text">
          {{form.age}}
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="this.delete" class="text">刪除用戶</el-button>
        </el-form-item>
      </el-form>
      <h1 class="text" style="font-size: 34px;text-align: center;margin-left: 60px">課程分數</h1>
      <el-table
        :data="tableData"
        style="width: 50%;margin-left: 30%"
        border>
        <el-table-column
          prop="classId"
          label="課程ID"
          width="180">
        </el-table-column>
        <el-table-column
          prop="className"
          label="课程名稱"
          width="180">
        </el-table-column>
        <el-table-column
          prop="score"
          label="分數">
        </el-table-column>
      </el-table>
      <el-pagination
        background
        layout="total, sizes, prev, pager, next, jumper"
        :total="total"
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="currentPage"
        style="text-align:center;padding-top: 20px;"
      >
      </el-pagination>
    </el-card>
  </div>
</template>

<script>

  const axios = require('axios');
  export default {
    name: "StudentDetailPage",
    created() {
      this.setData(this.$route.query.form);
      axios
        .get('http://localhost:8081/admin/getStudentGrade', {
          params: {
            id: this.form.studentId,
            currentPage: 0,
            limit: 10
          }
        })
        .then(response => (this.tableData = response.data.data))
        .catch(function (error) { // 请求失败处理
          console.log(error);
        });
    },
    data() {
      return {
        form: {
          studentId: '',
          studentName: '',
          sex: '',
          phone: '',
          age:''
        },
        tableData: [],
        currentPage: 1,
        pagesize: 10,
        total: 0
      }
    },
    methods: {
      delete() {
        this.$confirm('此操作将删除该用戶, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.deleteUser();
          this.$message({
            type: 'success',
            message: '删除成功!'
          });
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });
        });
      },
      getData(data) {
        this.form.id = data.id;
      },
      changeDetail(id) {
        eventBus.$emit('path', '{name: ClassDetailPage}');
        eventBus.$emit('detail', `{id: ${id}}`);
      },
      deleteUser() {
        axios
          .get('http://localhost:8081/admin/deleteStudent', {
            params: {
              id: this.form.studentId
            }
          })
          .then(response => {
            if (response.data.status===200) {
              this.$router.back(-1);
            }else{
              Vue.prototype.$message.error('提交失敗');
            }
          })
          .catch(function (error) { // 请求失败处理
            Vue.prototype.$message.error('提交失敗');
          });
      }
      ,
      setData(data) {
        this.form = {
          studentId: data.studentId,
          studentName: data.studentName,
          sex: data.sex,
          phone: data.phone,
          age : data.age
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
