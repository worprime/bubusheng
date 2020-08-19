<template>
  <div class="hello">
    <div class="header bg-purple">
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
              <span slot="title">成绩单</span>
            </el-menu-item>
            <el-menu-item index="2">
              <i class="el-icon-menu"></i>
              <span slot="title">课程表</span>
            </el-menu-item>
            <el-menu-item index="3" >
              <i class="el-icon-document"></i>
              <span slot="title">个人信息</span>
            </el-menu-item>
          </el-menu>
        </el-col>
        <el-col :span="20">
          <child1 v-if="isChildUpdate1"></child1>
          <child2 v-if="isChildUpdate2"></child2>
          <child3 v-if="isChildUpdate3"></child3>
        </el-col>
      </el-row>
    </div>
    <div class="hello bg-purple">
      <p>联系我们：15043466013</p>
    </div>
  </div>
</template>

<script>
import afterLogin_c1 from '@/components/student/afterLogin_c1';
import afterLogin_c2 from '@/components/student/afterLogin_c2';
import afterLogin_c3 from '@/components/student/afterLogin_c3';
export default {
  name: 'afterLogin',
  created(){
    //初始化工作
    if(this.$cookies.isKey("StudentID")){
      this.StudentID = this.$cookies.get("StudentID");
    }
  },
  components:{
    child1:afterLogin_c1,
    child2:afterLogin_c2,
    child3:afterLogin_c3
  },
  data () {
    return {
      tabPosition: 'left',
      circleUrl: "https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png",
      msg: 'Welcome to Your Vue.js App',
      sizeList: ["medium"],
      isChildUpdate1:true,
      isChildUpdate2:false,
      isChildUpdate3:false
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
        this.isChildUpdate1=true;
        this.isChildUpdate2=false;
        this.isChildUpdate3=false;
      }
      if(index=="2"){
        this.isChildUpdate1=false;
        this.isChildUpdate2=true;
        this.isChildUpdate3=false;
      }
      if(index=="3"){
        this.isChildUpdate1=false;
        this.isChildUpdate2=false;
        this.isChildUpdate3=true;
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
