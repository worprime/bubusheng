import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '../components/HelloWorld'
import beforeLogin from '../components/student/beforeLogin'
import loggingIn from '../components/student/loggingIn'
import register from '../components/student/register'
import afterLogin from '../components/student/afterLogin'
import afterLogin_c1 from '../components/student/afterLogin_c1'
import afterLogin_c2 from '../components/student/afterLogin_c2'
import afterLogin_c3 from '../components/student/afterLogin_c3'
import course from '../components/student/course'
import course_c1 from '../components/student/course_c1'
import course_c2 from '../components/student/course_c2'
import MyGrades from '../components/student/MyGrades'
import MyCourses from '../components/student/MyCourses'
import MyTest from '../components/student/MyTest'
import SelectCourse from '../components/student/SelectCourse'
import StudentMain from '../components/student/StudentMain'
import AdminMainPage from "../components/Admin/AdminMainPage"
import Login from '../components/Admin/Login'
import AuditDetailPage from "../components/Admin/AuditDetailPage";
import Audit from "../components/Admin/Audit";
import DealAudit from "../components/Admin/DealAudit";
import FinishedAudit from "../components/Admin/FinishedAudit";
import Student from "../components/Admin/Student";
import Teacher from "../components/Admin/Teacher";
import Course from "../components/Admin/Course";
import StudentDetailPage from "../components/Admin/StudentDetailPage";
import TeacherDetailPage from "../components/Admin/TeacherDetailPage";
import CourseDetailPage from "../components/Admin/CourseDetailPage";
import CourseNavMenu from "../components/teacher/CourseNavMenu";
import TeacherCourse from "../components/teacher/TeacherCourse";
import UploadTest from "../components/teacher/UploadTest";
import MarkPapers from "../components/teacher/MarkPapers";
import Announce from "../components/teacher/Announce";
import StudentScore from "../components/teacher/StudentScore";
import UploadCourse from "../components/teacher/UploadCourse";
import TeacherHeader from "../components/teacher/TeacherHeader";
import CourseMain from "../components/teacher/CourseMain";
import UploadVideo from "../components/teacher/UploadVideo";


Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/beforeLogin',
      name: 'beforeLogin',
      component: beforeLogin
    },
    {
      path: '/loggingIn',
      name: 'loggingIn',
      component: loggingIn
    },
    {
      path: '/register',
      name: 'register',
      component: register
    },
    {
      path:'/afterLogin',
      name:'/afterLogin',
      component:afterLogin
    },
    {
      path:'/afterLogin_c1',
      name:'/afterLogin_c1',
      component:afterLogin_c1
    },
    {
      path:'/afterLogin_c2',
      name:'/afterLogin_c2',
      component:afterLogin_c2
    },
    {
      path:'/afterLogin_c3',
      name:'/afterLogin_c3',
      component:afterLogin_c3
    },
    {
      path:'/course',
      name:'/course',
      component:course
    },
    {
      path:'/course_c1',
      name:'/course_c1',
      component:course_c1
    },
    {
      path:'/course_c2',
      name:'/course_c2',
      component:course_c2
    },
    {
      path: '/MyGrades',
      name: 'MyGrades',
      component: MyGrades
    },
    {
      path: '/SelectCourse',
      name: 'SelectCourse',
      component: SelectCourse
    },
    {
      path: "/MyCourses",
      name: "MyCourses",
      component: MyCourses
    },
    {
      path: "/MyTest",
      name: "MyTest",
      component: MyTest
    },
    {
      path: '/StudentMain',
      name: 'StudentMain',
      component: StudentMain,
    },
    {
      path: '/Login',
      name: 'AdminLogin',
      component: Login
    },
    {
      path: '/Main',
      name: 'AdminMain',
      component: AdminMainPage,
      children : [
        {
          path: 'Audit',
          component: Audit
        },
        {
          path: 'AuditDetail',
          component: AuditDetailPage
        },
        {
          path: 'DealAudit',
          component: DealAudit
        },
        {
          path: 'FinishedAudit',
          component: FinishedAudit
        },
        {
          path: 'Student',
          component: Student
        },
        {
          path: 'StudentDetail',
          component: StudentDetailPage
        },
        {
          path: 'Teacher',
          component: Teacher
        }
        ,
        {
          path: 'TeacherDetail',
          component: TeacherDetailPage
        },
        {
          path: 'Course',
          component: Course
        }
        ,
        {
          path: 'CourseDetail',
          component: CourseDetailPage
        }
      ]
    },
    {
      path: '/teacher/CourseNavMenu',
      name: 'CourseNavMenu',
      component: CourseNavMenu
    },
    {
      path: '/teacher/TeacherCourse',
      name:'TeacherCourse',
      component: TeacherCourse
    },
    {
      path: '/teacher/UploadTest',
      name:'UploadTest',
      component: UploadTest
    },{
      path: '/teacher/MarkPapers',
      name:'MarkPapers',
      component: MarkPapers
    },{
      path: '/teacher/Announce',
      name:'Announce',
      component: Announce
    },{
      path: '/teacher/StudentScore',
      name:'StudentScore',
      component: StudentScore
    },{
      path: '/teacher/UploadCourse',
      name:'UploadCourse',
      component: UploadCourse
    },
    {
      path: '/teacher/TeacherHeader',
      name:'TeacherHeader',
      component: TeacherHeader
    },
    {
      path: '/teacher/CourseMain',
      name:'CourseMain',
      component: CourseMain,
    },
    {
      path: '/teacher/UploadVideo',
      name:'UploadVideo',
      component: UploadVideo,
    },
  ]
})
