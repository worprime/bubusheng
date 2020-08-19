<template>
  <div class="CourseNavMenu">
  <el-row class="tac">
    <el-col :span="12">
      <el-menu
        default-active="2"
        class="el-menu-vertical-demo"
        @open="handleOpen"
        @close="handleClose">
        <el-menu-item index="1">
          <span slot="title"><router-link to="/teacher/TeacherCourse">课程信息</router-link>></span>
        </el-menu-item>
        <el-menu-item index="2">
          <span slot="title"><router-link to="/teacher/UploadTest">发布考试</router-link></span>
        </el-menu-item>
        <el-menu-item index="3">
          <span slot="title"><router-link to="/teacher/MarkPapers">批改试卷</router-link></span>
        </el-menu-item>
        <el-menu-item index="4">
          <span slot="title"><router-link to="/teacher/Announce">发布公告</router-link></span>
        </el-menu-item>
        <el-menu-item index="5">
          <span slot="title"><router-link to="/teacher/StudentScore">查看学生成绩</router-link></span>
        </el-menu-item>
        <el-menu-item index="6">
          <span slot="title"><router-link to="/teacher/UploadCourse">上传课件</router-link></span>
        </el-menu-item>
        <el-menu-item index="7">
          <span slot="title"><router-link to="/teacher/UploadVideo">上传视频</router-link></span>
        </el-menu-item>
        <el-menu-item index="8">
          <span slot="title"><a href="../../static/html/teachermian.html?teacherid=2020001">返回</a></span>
        </el-menu-item>
      </el-menu>
    </el-col>
  </el-row>
  </div>
</template>

<script>
 import TeacherCourse from "./TeacherCourse";
 import UploadTest from "./UploadTest";
 import MarkPapers from "./MarkPapers";
 import Announce from "./Announce";
 import StudentScore from "./StudentScore";
 import UploadCourse from "./UploadCourse";
 import UploadVideo from "./UploadVideo";
export default {
  components: {TeacherCourse, UploadTest,MarkPapers,Announce,StudentScore,UploadCourse,UploadVideo},
  methods: {
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    }
  }
}
</script>

<style scoped>
  .CourseNavMenu{
    height: 100%;
    margin-top: auto;
  }
</style>
