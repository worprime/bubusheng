<template>
  <div style="height: 100%;width: 100%">
    <div style="width: 100%;background-color: #314659;min-height: 60px">
      <el-image :src="logo" style="padding-top: 10px;"/>
    </div>
    <el-menu
      class="SideMenu"
      background-color="#314659"
      text-color="#F8F8FF"
      active-text-color="#ffd04b"
      style="width: 100%;height: 100%"
      @select="changeContent"
      default-active="/Main/Audit"
    >
      <div>
        <el-menu-item v-for="(item, i) in list" class="item" v-bind:index="item.path" v-bind:key="i" >
          {{item.name}}
        </el-menu-item>
      </div>

    </el-menu>
  </div>
</template>

<script>
  import "../../js/eventBus.js"
  import eventBus from "../../js/eventBus.js";
  export default {
    name: "SideMenu",
    mounted() {
      eventBus.$on('add', this.getData);
    },
    data() {
      return {
        logo: 'http://39.98.127.39:3000/group15/bubusheng/raw/master/vue_bubusheng/src/assets/BackEndLogo.PNG',
        list: [
          {name: "全部审批", path:  '/Main/Audit'},
          {name: "待辦审批", path:  '/Main/DealAudit'},
          {name: "已辦审批", path: '/Main/FinishedAudit'}
        ]
      }
    },
    methods: {
      getData(data) {
        this.list = data;
      },
      changeContent(index) {
        eventBus.$emit('path', index);
      }
    }
  }
</script>

<style scoped>
  .SideMenu {
    height: 100%;
  }

  .item {
    font-size: 16px;
    font-family: YouYuan;
  }
</style>
