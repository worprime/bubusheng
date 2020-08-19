<template>
  <div>
    <div class="header">
     <el-row :gutter="0" type="flex" justify="space-between" align="middle">
       <el-col :span="6">
         <H3>在线考试&培训系统</H3>
       </el-col>
       <el-col :span="2" :offset="13">
         <el-link :underline="false" href="https://element.eleme.io">个人中心</el-link>
       </el-col>
       <el-col :span="3">
         <i class="el-icon-user"></i>
       </el-col>
     </el-row>
     <el-row :gutter="0" type="flex" justify="space-between" align="left" margin-top="20px">
      <el-divider width="70%"></el-divider>
     </el-row>
    </div>
    <div class="body" height="400px">
      <el-row >
          <el-col :span="3" class="aside">
            <el-card  style="width: 100%;">
            <el-menu

              :default-active="activeIndex"
              @select="handleSelect"
              >
                <el-menu-item index="1" >

                  <span style="color:'#F7EC1D'">课程选择</span>
                </el-menu-item>
                  ——————
                <el-menu-item index="2">
                  <span >我的课程</span>
                </el-menu-item>
                  ——————
                <el-menu-item index="3" >
                  <span >我的考试</span>
                </el-menu-item>
                  ——————
                <el-menu-item index="4">
                  <span >我的成绩</span>
                </el-menu-item>
              ——————
                <el-menu-item index="5">
                     <span >个人信息</span>
                </el-menu-item>
            </el-menu>
            </el-card>
          </el-col>



        <el-col :span="19" :offset="1" class="main">
          <el-card class="box-card" style="width: 90%;text-align: left;margin-left: 40px">
            <router-view></router-view>
          </el-card>

        </el-col>

      </el-row>
    </div>
    <div class="foot">
        <el-row type="flex"  >
          <el-col :span="3" >
            <span style="font-size: 30px; ">
              精品课程
            </span>

          </el-col>
        </el-row>
        <el-row >
          <el-col :span="6" gutter="5">
            <span style="color: #BFC2C5; ">
              ——————————————————————————
            </span>
          </el-col>
        </el-row >
        <el-row>
          <el-col :span="5"  :offset="1" class="featured">
            <el-card :body-style="{ padding: '0px' }" class="card">
              <img src="http://pic5.photophoto.cn/20071214/0033033955287991_b.jpg" class="image">
              <div style="padding: 14px;">
                <el-row>
                 <span style="font-size: 15px; color: #292B2C; float:left;">
                   宇宙新概念
                 </span>
                </el-row>
                <el-row>
                 <span style="font-size: 10px; color: #494A4B; float:left; padding-left: 20px; margin-top: 5px">
                   张三
                 </span>
                </el-row>
                <el-row>
                 <span style="font-size: 10px; color: #434445; float:right; padding-left: 20px; ">
                   开课时间：2020.8.8
                 </span>
                </el-row>
                <el-button type="text" class="button" style="float:right" @click="joinclass(2020111)">加入课程</el-button>
              </div>
            </el-card>
          </el-col>
          <el-col :span="5"  :offset="1" class="featured">
            <el-card :body-style="{ padding: '0px' }" class="card">
              <img src="http://pic5.photophoto.cn/20071214/0033033955287991_b.jpg" class="image">
              <div style="padding: 14px;">
                <el-row>
                 <span style="font-size: 15px; color: #292B2C; float:left;">
                   社会学概论
                 </span>
                </el-row>
                <el-row>
                 <span style="font-size: 10px; color: #494A4B; float:left; padding-left: 20px; margin-top: 5px">
                   张三
                 </span>
                </el-row>
                <el-row>
                 <span style="font-size: 10px; color: #434445; float:right; padding-left: 20px; ">
                   开课时间：2020.9.9
                 </span>
                </el-row>
                <el-button type="text" class="button" style="float:right" @click="joinclass(2020120)">加入课程</el-button>
              </div>
            </el-card>
          </el-col>
          <el-col :span="5"  :offset="1" class="featured">
            <el-card :body-style="{ padding: '0px' }" class="card">
              <img src="http://pic5.photophoto.cn/20071214/0033033955287991_b.jpg" class="image">
              <div style="padding: 14px;">
                <el-row>
                 <span style="font-size: 15px; color: #292B2C; float:left;">
                   体育旅游
                 </span>
                </el-row>
                <el-row>
                 <span style="font-size: 10px; color: #494A4B; float:left; padding-left: 20px; margin-top: 5px">
                   张三
                 </span>
                </el-row>
                <el-row>
                 <span style="font-size: 10px; color: #434445; float:right; padding-left: 20px; ">
                   开课时间：2020.8.8
                 </span>
                </el-row>
                <el-button type="text" class="button" style="float:right" @click="joinclass(2020122)">加入课程</el-button>
              </div>
            </el-card>
          </el-col>
          <el-col :span="5"  :offset="1" class="featured">
            <el-card :body-style="{ padding: '0px' }" class="card">
              <img src="http://pic5.photophoto.cn/20071214/0033033955287991_b.jpg" class="image">
              <div style="padding: 14px;">
                <el-row>
                 <span style="font-size: 15px; color: #292B2C; float:left;">
                   宇宙新概念
                 </span>
                </el-row>
                <el-row>
                 <span style="font-size: 10px; color: #494A4B; float:left; padding-left: 20px; margin-top: 5px">
                  王五
                 </span>
                </el-row>
                <el-row>
                 <span style="font-size: 10px; color: #434445; float:right; padding-left: 20px; ">
                   开课时间：2020.8.8
                 </span>
                </el-row>
                <el-button type="text" class="button" style="float:right" @click="joinclass(2020222)">加入课程</el-button>
              </div>
            </el-card>
          </el-col>
        </el-row>
    </div>
  </div>
</template>

<script>
  import Vue from 'vue'

  const axios = require('axios');
  export default {
      name:"StudentMain",
      created() {
        if(this.$cookies.isKey("stuid")){
          this.stuid = this.$cookies.get("stuid");
        };
      },
      data() {
        return {
          activeIndex:"1",
          stuid:'',
        };
      },
      methods:{
        handleSelect(key, keyPath) {
          switch (key) {
            case '1':
              this.$router.push('/SelectCourse');
              break;
            case '2':
              this.$router.push('/MyCourses');
              break;
            case '3':
              this.$router.push('/MyTest');
              break;
            case '4':
              this.$router.push('/MyGrades');
            case '5':
              this.$router.push('/afterLogin_c3')
          }
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
      }
  }

</script>

<style scoped>

  .aside{
    margin-top:60px;
    margin-bottom: 60px;

  }

  .body{

  }

  .bg-purple {
    background: #FFFFFF;
  }

  .foot{
    margin-top: 30px;
    margin-left: 20px;
  }

  .top{
    border-top: 90px;
  }

  .featured{
    margin-top: 20px;
  }

  .image {
    height: 150px;
    width: 230px;
  }

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
    color: #494A4B;
    padding-top: 20px;
    float: left;
  }

  .classname {
    padding: 70px;
    float: left;

  }

</style>
