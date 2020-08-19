<template>
  <div id="admin" style="height: 100%">
    <el-container style="height: 100%">
      <el-aside style="margin-left: 0;height: 100%;overflow: hidden">
        <SideMenu></SideMenu>
      </el-aside>
      <el-container>
        <el-header style="margin: 0;padding: 0;height: auto">
          <NavMenu></NavMenu>
        </el-header>
        <el-main style="background-color: #fafafa">
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
  import NavMenu from './NavMenu'
  import SideMenu from './SideMenu'
  import Audit from "./Audit";
  import AuditDetailPage from "./AuditDetailPage";
  import ClassDetailPage from "./CourseDetailPage";
  import TeacherDetailPage from "./TeacherDetailPage";
  import Student from "./Student";
  import StudentDetailPage from "./StudentDetailPage"
  import "../../js/eventBus.js"
  import eventBus from "../../js/eventBus.js";

  export default {
    name: 'AdminMainPage',
    components: {
      Student,
      TeacherDetailPage,
      ClassDetailPage,
      AuditDetailPage,
      Audit,
      NavMenu,
      SideMenu,
      StudentDetailPage
    },
    mounted() {
      eventBus.$on('path', this.ChangeContent);
    },
    created() {
        this.$router.push("/Main/Audit");
    }
    ,
    beforeCreate() {
      document.querySelector('body').setAttribute('style', 'margin: 0;height: 100%;'),
        document.querySelector('html').setAttribute('style', 'height: 100%;')
    },
    beforeDestroy() {
      document.querySelector('body').removeAttribute('style'),
        document.querySelector('html').removeAttribute('style')
    },
    methods: {
      ChangeContent(data) {
        this.$router.push(data);
      }
    }
  }
</script>

<style scoped>

</style>
