<template>
  <div class="container">
    <el-table
      :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()) | !search ||data.ID.toLowerCase().includes(search.toLowerCase()))"
      height="400"
      border
      style="width: 600px">
      <el-table-column
        prop="name"
        label="姓名"
        width="180">
      </el-table-column>
      <el-table-column
        prop="studentId"
        label="学号"
        width="180">
      </el-table-column>
      <el-table-column
        prop="score"
        label="成绩">
      </el-table-column>
      <el-table-column
        align="right">
        <template slot="header" slot-scope="scope">
          <el-input
            v-model="search"
            size="mini"
            placeholder="输入关键字搜索"/>
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

// const classId = UrlParam.paramValues("classid");
const axios = require('axios');
export default {

  name: "StudentScore",
  mounted() {
    this.setData(this.$route.query.form);
    axios
      .get('http://localhost:8081/course/studentgrade/course/getStudentGrade', {
        params: {
          classId: 2020111,
          currentPage: 0,
          limit: 10
        }
      })
      .then(response => (this.tableData = response.data.data))
      .catch(function (error) { // 请求失败处理
        console.log(error);
      });
  },
  data(){
    return{
      tableData:[
        {
          name:"张三",
          studentId:2020101,
          score: 80,
        },{
          name:"张三",
          studentId:2020101,
          score: 80,
        },{
          name:"张三",
          studentId:2020101,
          score: 80,
        },{
          name:"张三",
          studentId:2020101,
          score: 80,
        },{
          name:"张三",
          studentId:2020101,
          score: 80,
        },
      ],
      currentPage: 1,
      pagesize: 10,
      total: 0,
      search:''
    }
  },
  methods:{
    getData(data) {
      this.tableData = data.data;
      this.total = data.total;
    },

  }


}
</script>

<style scoped>
.container{
  margin-right: 20%;
  margin-left: 20%;
}
</style>
