<template>
  <div class="container">
  <el-table
    :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
    style="width: 600px">
    <el-table-column
      label="studentId"
      prop="studentId">
    </el-table-column>
    <el-table-column
      label="Name"
      prop="name">
    </el-table-column>
    <el-table-column
      label="annotation"
      prop="annotation">
    </el-table-column>
    <el-table-column
      label="Score"
      prop="Score">
    </el-table-column>
    <el-table-column
      align="right">
      <template slot="header" slot-scope="scope">
        <el-input
          v-model="search"
          size="mini"
          placeholder="输入关键字搜索"/>
      </template>
      <template slot-scope="scope">
        <el-button
          size="mini"
          @click="handleMark(scope.$index, scope.index.score)">Mark</el-button>
        <el-button
          size="mini"
          @click="handleMark(scope.$index, scope.index.annotation)">Annotation</el-button>
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
// var classId=UrlParam.paramValues("classid");
const axios = require('axios');
export default {
  name: "MarkPapers",
  created() {
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
  data() {
    return {
      tableData: [{
        name:"张三",
        studentId:2020101,
        annotation:"",
        score:"" ,
      },{
        name:"张三",
        studentId:2020101,
        annotation:"",
        score: "",
      },{
        name:"张三",
        studentId:2020101,
        annotation:"",
        score:"" ,
      },{
        name:"张三",
        studentId:2020101,
        annotation:"",
        score: "",
      },{
        name:"张三",
        studentId:2020101,
        annotation:"",
        score: "",
      },],
      currentPage: 1,
      pagesize: 10,
      total: 0,
      search: ''

    }

  },
  methods:{
    handleMark(index, row) {
      axios
        .get('http://localhost:8081/course/studentgrade/course/setStudentGrade',{
          params:{
            studentId:this.index.studentId,
            classId: 2020111,
            score: this.index.score,
            annotation:this.index.annotation,
          }
        })
        .then(response => {
          if (response.data.status===200) {
            Vue.prototype.$message.success('提交成功');
          }else{
            Vue.prototype.$message.error('提交失敗');
          }
        })
        .catch(function (error) { // 请求失败处理
          Vue.prototype.$message.error('提交失敗');
        });
    },
    },

}
</script>

<style scoped>
  .container{
    margin-right: 20%;
    margin-left: 20%;
  }
</style>
