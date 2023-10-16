<template>
  <div class="center"><slot></slot></div>
</template>

<style scoped>
.center {
  display: flex;
  min-height: 100%;
  width: 100%;
  flex-direction: column;
  flex-wrap: wrap;
  align-content: center;
  justify-content: center;
}
</style>
