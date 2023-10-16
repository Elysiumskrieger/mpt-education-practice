<template>
  <v-app-bar
    color="primary"
    prominent
  >
    <v-app-bar-nav-icon variant="text" @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
    <v-toolbar-title>Учебная практика</v-toolbar-title>
    <v-spacer></v-spacer>
  </v-app-bar>

  <v-navigation-drawer
    v-model="drawer"
    location="left"
    width="350"
    :temporary="true"
  >

    <v-list v-model:opened="open">
      <a href="/">
        <v-list-item
          :class="{'active': router.currentRoute.value.name === 'Home'}"
          prepend-icon="mdi-home"
          title="Главная"
          @click=""
        ></v-list-item>
      </a>
      <v-list-group value="Задание 1">
        <template v-slot:activator="{ props }">
          <v-list-item
            v-bind="props"
            prepend-icon="mdi-file-code-outline"
            title="Задание 1"
          ></v-list-item>
        </template>

        <a href="/task1/calculator">
          <v-list-item
            :class="{'active': router.currentRoute.value.name === 'Task1Calculator'}"
            prepend-icon="mdi-calculator"
            title="Калькулятор"
            value="Калькулятор"
          ></v-list-item>
        </a>

        <a href="/task1/cash-converter">
          <v-list-item
            :class="{'active': router.currentRoute.value.name === 'Task1Converter'}"
            prepend-icon="mdi-swap-horizontal"
            title="Конвертер валют"
            value="Конвертер валют"
          ></v-list-item>
        </a>
      </v-list-group>
    </v-list>

  </v-navigation-drawer>
</template>

<script setup lang="ts">
const drawer = ref(false)
const open = ref(['Задание 1'])

const router = useRouter()
</script>

<style scoped>
a {
  text-decoration: none;
  color: white;
}

.active {
  color: #5CBBF6;
}
</style>
