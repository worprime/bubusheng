<template>
  <div>
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
</template>

<script>
export default {
  name: "beforeLogin",
  data() {
    return {
      className: "JAVA应用程序",
      teacherName: "王老师",
      openTime: "开课时间：2020/05/07"
    }
  }
}
</script>

<style scoped>

</style>
