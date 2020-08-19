<template>
  <div>
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item class="text" style="font-size: 20px">課程管理</el-breadcrumb-item>
      <el-breadcrumb-item class="text" style="font-size: 20px">課程信息</el-breadcrumb-item>
    </el-breadcrumb>
    <h1 class="text" style="margin-left: 40%;font-size: 34px">課程信息</h1>
    <el-card class="box-card" style="width: 80%;text-align: center;margin-left: 40px">
      <el-form ref="form" :model="form" label-width="80px">
        <el-form-item label="課程ID:" class="text">
          {{form.classId}}
        </el-form-item>
        <el-form-item label="課程名稱:" class="text">
          {{form.className}}
        </el-form-item>
        <el-form-item label="課程类型:" class="text">
          {{form.type}}
        </el-form-item>
        <el-form-item label="教師Id:" class="text">
          {{form.teacherId}}
        </el-form-item>
        <el-form-item label="教師:" class="text">
          {{form.teacherName}}
        </el-form-item>
        <el-form-item label="開課時間:" class="text">
          {{form.beginning}}
        </el-form-item>
        <el-form-item label="簡介:" class="text">
          {{form.intro}}
        </el-form-item>
      </el-form>
      <h1 class="text" style="font-size: 34px;text-align: center;margin-left: 100px">學生信息</h1>
      <el-table
        :data="tableData"
        style="width: 50%;margin-left: 30%"
        border
      >
        <el-table-column
          prop="studentId"
          label="ID"
          width="180">
        </el-table-column>
        <el-table-column
          prop="studentName"
          label="學生姓名"
          width="180">
        </el-table-column>
        <el-table-column
          prop="score"
          label="學生分數">
        </el-table-column>
        <el-table-column
          fixed="right"
          label="操作"
          width="80"
        >
          <template slot-scope="scope">
            <el-button icon="el-icon-more" @click="changeDetail(scope.row.studentId)"></el-button>
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
    name: "CourseDetailPage",
    created() {
      this.setFormData(this.$route.query.form);
      axios
        .get('http://localhost:8081/admin/getStudentByClass', {
          params: {
            id: this.form.classId,
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
          classId: '',
          className: '',
          teacherId: '',
          teacherName: '',
          beginning: '',
          intro: '',
          type: ''
        },
        tableData: [],
        currentPage: 1,
        pagesize: 10,
        total: 0
      }
    },
    methods: {
      changeDetail(id) {
        axios
          .get('http://localhost:8081/admin/getStudentById', {
            params: {
              id: id
            }
          })
          .then(response => (this.setData(response.data.data)))
          .catch(function (error) { // 请求失败处理
            console.log(error);
          });
      },
      getData(data) {
        this.tableData= data.data;
        this.total = data.total;
      },
      setFormData(data) {
        this.form = {
          classId: data.classId,
          className: data.className,
          type: data.type,
          teacherId: data.teacherId,
          teacherName: data.teacherName,
          beginning: data.beginning,
          intro: data.intro,
        };
      },
      setData(data) {
        this.$router.push({path: "/Main/StudentDetail", query: {form: data}});
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
