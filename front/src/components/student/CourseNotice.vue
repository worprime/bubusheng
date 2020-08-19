<template>
  <el-card class="box-card" style="width: 60%;text-align: left;margin-left: 40px">
    <el-row v-for="(item, i) in noticelist" >
        <el-row>
          <span style="font-size: 20px; color:#A6ACB3">
            {{item.noticeName}}
          </span>
        </el-row>

        <span style="font-size: 15px; color:#F3F4F5; ">
         ——————————————
        </span>
        <el-row>
          <span style="font-size: 15px; color:gray; padding-left: 20px">
            {{item.notice}}
          </span>
        </el-row>
        <el-row>
          <span style="font-size: 12px; color:gray; float: right">
            {{item.time}}
          </span>
        </el-row>
        <el-divider></el-divider>
    </el-row>
  </el-card>
</template>

<script>
  const axios = require('axios');
  export default {
      name:"CourseNotice" ,
      created(){
               this.classId = 111;
               axios
                 .get('http://localhost:8081//student/notice//getNoticeByClassId', {
                   params: {
                     ClassId: this.classId
                   }
                 })
                 .then(response => (this.getData(response.data)))
                 .catch(function (error) { // 请求失败处理
                   console.log(error);
                 });
      },
      data() {
        return {
          noticelist:[],
          classId: '',
        }
      },
      methods:{
        getData(data) {
          this.noticelist = data.noticedata;
        }
      }
  }
</script>

<style scoped>

</style>
