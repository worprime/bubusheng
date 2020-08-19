<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>
import BeforeLogin from "./components/student/beforeLogin";
import loggingIn from "./components/student/loggingIn";
import register from "./components/student/register";
import afterLogin from "./components/student/afterLogin";
import afterLogin_c1 from "./components/student/afterLogin_c1";
import afterLogin_c2 from "./components/student/afterLogin_c2";
import afterLogin_c3 from "./components/student/afterLogin_c3";
import course from "./components/student/course";
import course_c1 from "./components/student/course_c1";
import course_c2 from "./components/student/course_c2";
export default {
  name: 'App',
  components: {
    BeforeLogin,
    loggingIn,
    register,
    afterLogin,
    afterLogin_c1,
    afterLogin_c2,
    afterLogin_c3,
    course,
    course_c1,
    course_c2
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
