<template>
  <div >
   <el-row :gutter="0" type="flex" justify="space-between" align="middle">
     <el-col :span="3">
       <span>已选课程</span>
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
      :data="myCoursesData"
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
          <el-button @click="enterclass(scope.row.classId)">进入课程</el-button>
        </template>

      </el-table-column>
   </el-table>
  </div>
</template>

<script>
  const axios = require('axios');
  export default {
      name:"MyCourses" ,
    created() {
      var self = this;
      if(this.$cookies.isKey("stuid")){
        this.stuid = this.$cookies.get("stuid");
      };
      axios
        .get('http://localhost:8081/student/course/getCourseInfoByStuId', {
          params: {
            StuId: this.stuid,
          }
        })
        .then(response => (self.myCoursesData = response.data.courses))
        .catch(function (error) { // 请求失败处理
          console.log(error);
        });
    },
      data() {
        return {
          myCoursesData:[],
          input: '',
          stuid: '',
        };
      },
      methods:{
        find(){
          var self = this;
          axios
            .get('http://localhost:8081/student/course/getCourseInfoByStuIdClassName', {
              params: {
                StuId: 2020001,
                ClassName: this.input,
              }
            })
            .then(response => (self.myCoursesData = response.data.courses))
            .catch(function (error) { // 请求失败处理
              console.log(error);
          });
        },
        enterclass(id){//进入课程
          this.$cookies.set("claid", id,"0");
          this.$router.push("/course");
        },
      },
  }
</script>

<style scoped>
.card {
    margin-top: 13px;
    margin-left: 13px;
  }

  .opemtime {
    font-size: 10px;
    color: #999;
    margin-top: 30px;
    float: left;

  }

  .teachername {
    font-size: 13px;
    color: #999;
    padding-top: 20px;
    float: left;
  }

  .classname {
    padding: 70px;
    float: left;

  }

  .bottom {
    margin-top: 13px;
    line-height: 12px;
  }

  .button {
    padding: 0;
    float: right;
  }

  .image {
    width: 100%;
    display: block;
  }
</style>
