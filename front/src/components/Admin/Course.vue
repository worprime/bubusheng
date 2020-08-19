<template>
  <div>
    <el-row>
      <el-radio-group v-model="key">
        <el-radio-button label="ClassId"></el-radio-button>
        <el-radio-button label="ClassName"></el-radio-button>
        <el-radio-button label="TeacherName"></el-radio-button>
      </el-radio-group>
      <el-input v-model="input" placeholder="请输入内容" style="width: 200px"></el-input>
      <el-button @click="this.search">查詢</el-button>
      <el-button @click="this.reset">取消</el-button>
    </el-row>
    <el-table
      :data="tableData"
      border
      style="width: 100%;margin-top: 20px"
      empty-text="暂无数据"
    >
      <el-table-column
        prop="classId"
        label="序號"
        width="60"
      >
      </el-table-column>
      <el-table-column
        prop="className"
        label="課程名稱"
        width="180"
      >
      </el-table-column>
      <el-table-column
        prop="type"
        label="类型">
      </el-table-column>
      <el-table-column
        prop="teacherName"
        label="教師">
      </el-table-column>
      <el-table-column
        prop="beginning"
        label="開課時間">
      </el-table-column>
      <el-table-column
        prop="intro"
        label="簡介">
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
  </div>
</template>

<script>
  import Vue from 'vue'
  const axios = require('axios');
  export default {
    name: "Course",
    mounted() {
      axios
        .get('http://localhost:8081/admin/getAllCourse', {
          params: {
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
        currentPage: 1,
        pagesize: 10,
        total: 10,
        tableData: [],
        input: '',
        key: ''
      }
    },
    methods: {
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
      handleSizeChange: function (size) {
        this.pagesize = size;
      },
      handleCurrentChange: function (currentPage) {
        this.currentPage = currentPage;
        axios
          .get('http://localhost:8081/admin/getAllCourse', {
            params: {
              currentPage: this.currentPage,
              limit: this.pagesize
            }
          })
          .then(response => (this.getData(response.data)))
          .catch(function (error) { // 请求失败处理
            console.log(error);
          });
      }
      ,
      search() {
        if (this.key === '' ){
          Vue.prototype.$message(
            {
              message: '請選擇搜索类型!',
              type: 'error'
            })
        }else if(this.input === ''){
          Vue.prototype.$message(
            {
              message: '請輸入搜索關鍵字!',
              type: 'error'
            })
        }else {
          axios
            .get('http://localhost:8081/admin/getCourseByKey', {
              params: {
                currentPage: this.currentPage,
                limit: this.pagesize,
                key: this.key,
                keyword: this.input
              }
            })
            .then(response => (this.getData(response.data)))
            .catch(function (error) { // 请求失败处理
              console.log(error);
            });
        }
      },
      getData(data) {
        this.tableData = data.data;
        this.total = data.total;
      },
      reset() {
        axios
          .get('http://localhost:8081/admin/getAllCourse', {
            params: {
              currentPage: 0,
              limit: 10,
              result: "未审核"
            }
          })
          .then(response => (this.getData(response.data)))
          .catch(function (error) { // 请求失败处理
            console.log(error);
          });
        this.key = '';
        this.input = '';
      },
      setData(data) {
        this.$router.push({path: "/Main/CourseDetail", query: {form: data}});
      }
    }
  }
</script>

<style scoped>

</style>
