<template>
  <div>
    <el-header>
      <TeacherHeader/>
    </el-header>
    <el-container>
      <el-aside>
        <course-nav-menu/>
      </el-aside>
      <el-main>
        <router-view>
          <TeacherCourse/>
        </router-view>
      </el-main>
    </el-container>

  </div>
</template>

<script>
import CourseNavMenu from "./CourseNavMenu";
import TeacherHeader from "./TeacherHeader";
import TeacherCourse from "./TeacherCourse";
export default {
name: "CourseMain",
  components: {TeacherCourse, TeacherHeader, CourseNavMenu}
}
</script>

<style scoped>

</style>
