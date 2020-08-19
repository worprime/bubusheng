<template>
  <div >
   <el-row :gutter="0" type="flex" justify="space-between" align="middle">
     <el-col :span="3">
       <span>已出成绩</span>

     </el-col>
     <el-col :span="6" :offset="2">
       <el-input  placeholder="根据课程名搜索" v-model="input" maxlength="20" clearable>
         <el-button slot="append" icon="el-icon-search" @click="find"></el-button>
       </el-input>
     </el-col>
   </el-row>
   <el-row :gutter="0" type="flex" justify="space-between" align="left">
    <el-divider width="70%"></el-divider>
   </el-row>
   <el-table
      :data="gradesData"
      height="350"
      border
      style="width: 100%">
      <el-table-column
        prop="className"
        label="课程名"
        width="200">
      </el-table-column>
      <el-table-column
        prop="courseId"
        label="课程号"
        width="100">
      </el-table-column>
      <el-table-column
        prop="teacher"
        label="教师">
      </el-table-column>
      <el-table-column
        prop="grades"
        label="成绩">
      </el-table-column>
   </el-table>
  </div>

</template>

<script>
  const axios = require('axios');
  export default {
      name:"MyGrades" ,
      created() {
        if(this.$cookies.isKey("stuid")){
          this.stuid = this.$cookies.get("stuid");
        };
        var self = this;
        axios
          .get('http://localhost:8081/student/studentgrade/getCourseGradeByStuId', {
            params: {
              Stuid: this.stuid,
            }
          })
          .then(response => (self.gradesData = response.data.gradesData))
          .catch(function (error) { // 请求失败处理
            console.log(error);
          });
      },
    data() {
      return {
        gradesData: [],
        input: '',
        stuid: '',
      }
    },
    methods:{
      find(){
        var self = this;
        axios
          .get('http://localhost:8081/student/studentgrade/getCourseGradeByStuIdClassId', {
            params: {
              StuId: 2020001,
              ClassName:this.input,
            }
          })
          .then(response => (self.gradesData = response.data.gradesData))
          .catch(function (error) { // 请求失败处理
            console.log(error);
          });
      },

    }
  }
</script>

<style scoped>

</style>
