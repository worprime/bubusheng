<template>
  <div>
    <el-row :gutter="0" type="flex" justify="space-between" align="middle">
      <el-col :span="6">
        <H3>在线考试&培训系统</H3>
      </el-col>
      <el-col :span="6" :offset="5">
        <el-input type="text" placeholder="请输入内容" v-model="input" maxlength="10" clearable>
          <el-button slot="append" icon="el-icon-search"></el-button>
        </el-input>
      </el-col>
      <el-col :span="2" :offset="1">
        <el-link :underline="false">个人中心</el-link>
      </el-col>
      <el-col :span="1">
        <i class="el-icon-user"></i>

      </el-col>
    </el-row>
  </div>

</template>


<script>

export default {
name: "TeacherHeader",
  data() {
    return {
      input: ''
    }
  }
}
</script>

<style scoped>

</style>
