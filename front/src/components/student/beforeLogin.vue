<template>
  <div>
    <div class="header">
      <el-row :gutter="0" type="flex" justify="space-between" align="middle">
        <el-col :span="6">
          <H3>在线考试&培训系统</H3>
        </el-col>
        <el-col :span="6" :offset="5">
          <el-input type="text" placeholder="输入你感兴趣的课程" v-model="input" maxlength="10" clearable>
            <el-button slot="append" icon="el-icon-search"></el-button>
          </el-input>
        </el-col>
        <el-col :span="8"><div>
          <router-link to="/register">注册</router-link>
          |
          <router-link to="/loggingIn">登录</router-link>
        </div></el-col>
      </el-row>
      <el-row :gutter="0" type="flex" justify="space-between" align="left" margin-top="20px">
        <el-divider width="70%"></el-divider>
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
        <el-col :span="5" v-for="(o, index) in 4" :key="o" :offset="index > 0 ? 1 : 0" class="featured">
          <el-card :body-style="{ padding: '0px' }" class="card">
            <img src="http://pic5.photophoto.cn/20071214/0033033955287991_b.jpg" class="image">
            <div style="padding: 14px;">
              <el-row>
                 <span style="font-size: 15px; color: #292B2C; float:left;">
                   {{ className }}
                 </span>
              </el-row>
              <el-row>
                 <span style="font-size: 10px; color: #ACB1B4; float:left; padding-left: 20px; margin-top: 5px">
                   {{ teacherName }}
                 </span>
              </el-row>
              <el-row>
                 <span style="font-size: 10px; color: #434445; float:right; padding-left: 20px; ">
                   {{ openTime }}
                 </span>
              </el-row>
            </div>
          </el-card>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="5" v-for="(o, index) in 4" :key="o" :offset="index > 0 ? 1 : 0" class="featured">
          <el-card :body-style="{ padding: '0px' }" class="card">
            <img src="http://pic5.photophoto.cn/20071214/0033033955287991_b.jpg" class="image">
            <div style="padding: 14px;">
              <el-row>
                 <span style="font-size: 15px; color: #292B2C; float:left;">
                   {{ className }}
                 </span>
              </el-row>
              <el-row>
                 <span style="font-size: 10px; color: #ACB1B4; float:left; padding-left: 20px; margin-top: 5px">
                   {{ teacherName }}
                 </span>
              </el-row>
              <el-row>
                 <span style="font-size: 10px; color: #434445; float:right; padding-left: 20px; ">
                   {{ openTime }}
                 </span>
              </el-row>
            </div>
          </el-card>
        </el-col>
      </el-row>
    </div>
    <div class="hello bg-purple">
      <p>联系我们：15043466013</p>
    </div>
  </div>
</template>

<script>

export default {
  name:"beforeLogin",
  data() {
    return {
      className: "JAVA应用程序",
      teacherName: "王老师",
      openTime: "开课时间：2020/05/07"

    }
  },
  methods:{
    login(){
      this.$router.push('/logIn')
    }
  }
}

</script>

<style scoped>

.aside{
  margin-top:60px;
  margin-bottom: 60px;
  margin-left: 20px;
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
  color: #999;
  padding-top: 20px;
  float: left;
}

.classname {
  float: left;

}

.bg-purple {
  background: #d3dce6;
}

</style>
