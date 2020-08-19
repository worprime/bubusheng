<template>
  <div>
    <el-breadcrumb separator-class="el-icon-arrow-right"  >
      <el-breadcrumb-item class="text" style="font-size: 20px">教師管理</el-breadcrumb-item>
      <el-breadcrumb-item class="text" style="font-size: 20px">教師信息</el-breadcrumb-item>
    </el-breadcrumb>
    <h1 class="text" style="margin-left: 40%;font-size: 34px">教師信息</h1>
    <el-card class="box-card" style="width: 80%;text-align: center;margin-left: 40px">
      <el-form ref="form" :model="form" label-width="80px">
        <el-form-item label="ID:" class="text">
          {{form.teacherId}}
        </el-form-item>
        <el-form-item label="名稱:" class="text">
          {{form.teacherName}}
        </el-form-item>
        <el-form-item label="手机号:" class="text">
          {{form.phone}}
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="this.delete" class="text">刪除用戶</el-button>
        </el-form-item>
      </el-form>
      <h1 class="text" style="font-size: 34px;text-align: center;margin-left: 60px">教授課程</h1>
      <el-table
        :data="tableData"
        border
      >
        <el-table-column
          prop="classId"
          label="課程ID"
          width="180">
        </el-table-column>
        <el-table-column
          prop="className"
          label="课程名稱"
          >
        </el-table-column>
        <el-table-column
          prop="beginning"
          label="開始時間"
          width="180">
        </el-table-column>
        <el-table-column
          prop="type"
          label="课程类型"
          width="180">
        </el-table-column>
        <el-table-column
          fixed="right"
          label="操作"
          width="80"
        >
          <template slot-scope="scope">
            <el-button icon="el-icon-more" @click="changeDetail(scope.row.classId)"></el-button>
          </template>

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
    name: "TeacherDetailPage",
    created() {
      this.setFormData(this.$route.query.form);
      console.log(this.form.teacherId)
      axios
        .get('http://localhost:8081/admin/getCourseByTeacherId', {
          params: {
            id: this.form.teacherId,
            currentPage: 0,
            limit: 10
          }
        })
        .then(response => (this.getData(response.data)))
        .catch(function (error) { // 请求失败处理
          console.log(error);
        });
    },
    data() {
      return {
        form: {
          id: '',
          name: '',
          phone: ''
        },
        tableData: [],
        currentPage: 1,
        pagesize: 10,
        total: 0
      }
    },
    methods: {
      onSubmit() {
        console.log('submit!');
      },
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
        this.tableData = data.data;
        this.total = data.total;
      },
      changeDetail(id) {
        axios
          .get('http://localhost:8081/admin/getCourseById', {
            params: {
              id: id
            }
          })
          .then(response => (this.setData(response.data.data)))
          .catch(function (error) { // 请求失败处理
            console.log(error);
          });
      },
      deleteUser() {
        axios
          .get('http://localhost:8081/admin/deleteTeacher', {
            params: {
              id: this.form.teacherId
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
      },
      setFormData(data) {
        this.form = {
          teacherId: data.teacherId,
          teacherName: data.teacherName,
          phone: data.phone,
        }}
        ,
          setData(data){
          this.$router.push({path: "/Main/CourseDetail", query: {form: data}});
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
