<template>
  <div class="NavMenu">
    <el-row style="background-color: #ffffff;">
      <el-col span="23" style="height: 66px">
        <el-menu
          default-openeds="1"
          mode="horizontal"
          @select="handleSelect"
          background-color="#ffffff"
          text-color="#000000"
          active-text-color="#008000"
          default-active="1"
        >
          <el-menu-item index="1" class="item">审批</el-menu-item>
          <el-menu-item index="2" class="item">用戶管理</el-menu-item>
          <el-menu-item index="3" class="item">課程管理</el-menu-item>
        </el-menu>
      </el-col>
      <el-col span="1">
        <div style="padding-top: 10px">
          <el-avatar icon="el-icon-user-solid"></el-avatar>
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
  import "../../js/eventBus.js"
  import eventBus from "../../js/eventBus.js";
  export default {
    name: 'NavMenu',
    data() {
      return {}
    },
    methods: {
      handleSelect(key, keyPath) {
        switch (key) {
          case '1':
            this.changeDataWithAudit();
            break;
          case '2':
            this.changeDataWithUser();
            break;
          case '3':
            this.changeDataWithClass();
            break;
        }
      },
      changeDataWithAudit() {
        eventBus.$emit('add', [
          {name: "全部审批", path:  '/Main/Audit'},
          {name: "待辦审批", path: '/Main/DealAudit'},
          {name: "已辦审批", path:  '/Main/FinishedAudit'}
        ]);
      },
      changeDataWithUser() {
        eventBus.$emit('add', [
          {name: "教師管理", path:  '/Main/Teacher'},
          {name: "學生管理", path: '/Main/Student'}
        ]);
      },
      changeDataWithClass() {
        eventBus.$emit('add', [
          {name: "課程管理", path:  '/Main/Course'}
        ]);
      }
    }
  }
</script>

<style scoped>
  .item {
    min-height: 66px;
    line-height: 66px;
    font-size: 20px;
    font-family: YouYuan;
  }
</style>
