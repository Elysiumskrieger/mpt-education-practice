<template>
  <v-container class="fill-height page-back">
    <v-center>

      <v-card min-width="300" title="Калькулятор" subtitle="Введите любое математическое выражение" prepend-icon="mdi-calculator">
        <v-alert v-if="model.result || model.result === 0" type="success" title="Результат" :text="model.result.toString()"></v-alert>
        <v-alert v-if="model.error" type="error" title="Ошибка" :text="model.error"></v-alert>

        <form action="/task1/calculator" method="post">
          <v-text-field
            :model-value="model.ex ?? ''"
            label="Введите выражение"
            hide-details="auto"
            name="ex"
          ></v-text-field>

          <v-btn :block="true" size="large" type="submit">Решить</v-btn>
        </form>

      </v-card>

    </v-center>
  </v-container>
</template>

<script setup lang="ts">

type CalculatorModel = {
  ex?: string
  result?: number
  error?: string
}

const model = useModel<CalculatorModel>()

</script>
