<template>
  <div class="hello">
    <div class="bg-purple">
      <el-row :gutter="0" type="flex" align="middle">
        <el-col :span="8"><div>
          <h3>在线考试&培训政策</h3>
        </div></el-col>
        <el-col :span="8"><div>
          <el-input type="text" placeholder="请输入课程" v-model="input" maxlength="10" clearable>
            <el-button slot="append" icon="el-icon-search"></el-button>
          </el-input>
        </div></el-col>
        <el-col :span="4"><div>
          <router-link to="/afterLogin">个人中心</router-link>
        </div></el-col>
        <el-col :span="4">
          <div class="demo-basic--circle">
            <div class="block"><el-avatar :size="50" :src="circleUrl"></el-avatar></div>
          </div>
        </el-col>
      </el-row>
    </div>
    <div>
      <el-row :gutter="0" type="flex" align="middle">
        <el-col :span="8">
          <el-image
            style="width: 100px; height: 100px"
            :src="url"
            :fit="fill">
          </el-image>
        </el-col>
        <el-col :span="8"><div>
          <h3>编译原理</h3>
        </div></el-col>
        <el-col :span="8"><div>
          <h3>授课教师：</h3>
          <h3>李明</h3>
        </div></el-col>
      </el-row>
    </div>
    <div class="menu">
      <el-row class="tac">
        <el-col :span="3">
          <el-menu
            default-active="1"
            class="el-menu-vertical-demo"
            @open="handleOpen"
            @close="handleClose"
            @select="change">
            <el-menu-item index="1">
              <i class="el-icon-menu"></i>
              <span slot="title">课程介绍</span>
            </el-menu-item>
            <el-menu-item index="2">
              <i class="el-icon-menu"></i>
              <span slot="title">视频资源</span>
            </el-menu-item>
            <el-menu-item index="3" >
              <i class="el-icon-document"></i>
              <span slot="title">练习题</span>
            </el-menu-item>
            <el-menu-item index="4" >
              <i class="el-icon-document"></i>
              <span slot="title">考试</span>
            </el-menu-item>
            <el-menu-item index="5" >
              <i class="el-icon-document"></i>
              <span slot="title">课程公告</span>
            </el-menu-item>
          </el-menu>
        </el-col>
        <el-col :span="20">
          <comp1 v-if="option1"></comp1>
          <comp2 v-if="option2"></comp2>
        </el-col>
      </el-row>
    </div>
    <div class=" bg-purple">
      <p>联系我们：15043466013</p>
    </div>
  </div>
</template>

<script>
var temp;
const axios = require('axios');
import course_c1 from '@/components/student/course_c1'
import course_c2 from '@/components/student/course_c2'
export default {
  name: 'course',
  components:{
    comp1:course_c1,
    comp2:course_c2
  },
  created(){
    if(this.$cookies.isKey("classid")){
      temp = this.$cookies.get("classid");
    }
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
  data () {
    return {
      tabPosition: 'left',
      circleUrl: "https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png",
      msg: 'Welcome to Your Vue.js App',
      sizeList: ["medium"],
      url: 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
      option1:true,
      option2:false
    }
  },
  methods: {
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    },
    change(index){
      if(index=="1"){
        this.option1=true;
        this.option2=false;
      }
      if(index=="2"){
        this.option1=false;
        this.option2=true;
      }
    }
  }
}
</script>


<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.bg-purple {
  background: #d3dce6;
}
.container{
  margin-top: 20px
}
</style>
