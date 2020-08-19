<template>
  <div>
   <el-row :gutter="0" type="flex" justify="space-between" align="middle">
     <el-col :span="3">
       <span>所有课程考试</span>
     </el-col>
   </el-row>
   <el-row :gutter="0" type="flex" justify="space-between" align="left">
    <el-divider width="70%"></el-divider>
   </el-row>
   <el-table
      :data="testData"
      height="350"
      border
      style="width: 100%"
      :row-class-name="tableRowClassName">
      <el-table-column
        prop="courseName"
        label="课程名"
        width="250">
      </el-table-column>
      <el-table-column
        prop="teacher"
        label="教师"
        width="130">
      </el-table-column>
      <el-table-column
        prop="testOpen"
        label="考试是否开始">
      </el-table-column>
      <el-table-column
        prop="ddl"
        label="截止日期">
      </el-table-column>
   </el-table>
  </div>
</template>

<script>

  const axios = require('axios');
  export default {
      name:"MyTest",
      created() {
        if(this.$cookies.isKey("stuid")){
          this.stuid = this.$cookies.get("stuid");
        };
        var self = this;
        axios
          .get('http://localhost:8081/student/studentgrade/getCourseTestByStuid', {
            params: {
              Stuid: this.stuid,
            }
          })
          .then(response => (self.testData = response.data.testData))
          .catch(function (error) { // 请求失败处理
            console.log(error);
          });
      },
      methods: {

      },
      data() {
        return {
          testData: [],
          stuid:'',
        }
      },

  }
</script>

<style scoped>
  .el-table .warning-row {
    background: oldlace;
  }

  .el-table .success-row {
    background: #f0f9eb;
  }
</style>
