<template>
  <div >
   <el-row :gutter="0" type="flex" justify="space-between" align="middle">
     <el-col :span="3">
       <span>选择课程</span>
     </el-col>
     <el-col :span="6" :offset="2">
       <el-input type="text" placeholder="根据课程名搜索" v-model="input" maxlength="10" clearable>
         <el-button slot="append" icon="el-icon-search" @click="find"></el-button>
       </el-input>
     </el-col>
   </el-row>
   <el-row :gutter="0" type="flex" justify="space-between" align="left">
    <el-divider width="70%"></el-divider>
   </el-row>
   <el-table
      :data="coursesData"
      height="350"
      border
      style="width: 100%">
      <el-table-column
        prop="className"
        label="课程名"
        width="130"
        align="center">
      </el-table-column>
      <el-table-column
        prop="classId"
        label="课程号"
        width="100"
        align="center">
      </el-table-column>
      <el-table-column
        prop="teacherName"
        label="教师"
        width="80"
        align="center">
      </el-table-column>
      <el-table-column
        prop="intro"
        label="简介"
        width="170"
        align="center">
      </el-table-column>
      <el-table-column
        prop="beginning"
        label="开课时间"
        align="center">
      </el-table-column>
      <el-table-column
        prop="type"
        label="类型"
        width="100"
        align="center">
      </el-table-column>
      <el-table-column
      label="操作"
      width="120"
      align="center">
        <template slot-scope="scope">
          <el-button @click="joinclass(scope.row.classId)">加入课程</el-button>
        </template>
      </el-table-column>
   </el-table>
  </div>
</template>

<script>
  import Vue from 'vue'

  const axios = require('axios');
  export default {
      name:"SelectCourse" ,
      created() {
        if(this.$cookies.isKey("stuid")){
          this.stuid = this.$cookies.get("stuid");
        };
        var self = this;
        axios
          .get('http://localhost:8081/student/course/getAllCourse', {
            params: {

            }
          })
          .then(response => (self.coursesData = response.data.courses))
          .catch(function (error) { // 请求失败处理
            console.log(error);
          });
      },
      methods: {
        find(){
          var self = this;
          axios
            .get('http://localhost:8081/student/course/getCourseByClassName', {
              params: {
                ClassName: this.input,
              }
            })
            .then(response => (self.coursesData = response.data.courses))
            .catch(function (error) { // 请求失败处理
              console.log(error);
            });
        },
        joinclass(classid){
          axios
            .get('http://localhost:8081/student/studentgrade/studentJoinClass', {
              params: {
                stuId: this.stuid,
                classId: classid,
              }
            })
            .then(response => (this.getData(response.data)))
            .catch(function (error) { // 请求失败处理
              console.log(error);
            });
        },
        getData(data) {
          if (data.status == 200) {
            Vue.prototype.$message(
              {
                message: '加入课程成功',
                type: 'success'
              }
            )
          }
          if (data.status == 201) {
            Vue.prototype.$message(
              {
                message: '加入失败，已加入该课程',
                type: 'fail'
              }
            )
          }
          else {
            Vue.prototype.$message.error('加入出错');
          }
        },

      },
      data (){
        return {
          coursesData:[],
          input: '',
          stuid: '',
          classid: '',
        }
      }
  }
</script>

<style scoped>

</style>
