<template>
  <div >
    <el-row :gutter="0" type="flex" justify="space-between" align="middle">
      <el-col :span="3">
        <span>已出成绩</span>
      </el-col>
    </el-row>
    <el-row :gutter="0" type="flex" justify="space-between" align="left">
      <el-divider width="70%"></el-divider>
    </el-row>
    <el-table
      :data="gradesData"
      height="350"
      border
      style="width: 100%">
      <el-table-column
        prop="courseName"
        label="课程名"
        width="180">
      </el-table-column>
      <el-table-column
        prop="teacher"
        label="教师"
        width="90">
      </el-table-column>
      <el-table-column
        prop="courseId"
        label="课程号">
      </el-table-column>
      <el-table-column
        prop="grades"
        label="成绩">
      </el-table-column>
    </el-table>
  </div>

</template>

<script>
export default {
  name:"afterLogin_c1" ,
  data() {
    return {
      gradesData: [
        {
          courseName: '计算机组成原理',
          teacher: '胡启平',
          courseId: '111',
          grades: '90'
        }, {
          courseName: '计算机组成原理',
          teacher: '胡启平',
          courseId: '111',
          grades: '90'
        }, {
          courseName: '计算机组成原理',
          teacher: '胡启平',
          courseId: '111',
          grades: '90'
        }, {
          courseName: '计算机组成原理',
          teacher: '胡启平',
          courseId: '111',
          grades: '90'
        }, {
          courseName: '计算机组成原理',
          teacher: '胡启平',
          courseId: '111',
          grades: '90'
        }, {
          courseName: '计算机组成原理',
          teacher: '胡启平',
          courseId: '111',
          grades: '90'
        }, {
          courseName: '计算机组成原理',
          teacher: '胡启平',
          courseId: '111',
          grades: '90'
        }
      ]
    }
  }
}
</script>

<style scoped>

</style>
