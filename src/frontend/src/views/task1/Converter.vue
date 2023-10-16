<template>
  <v-container class="fill-height page-back">
    <v-center>

      <v-card min-width="300" title="Конвертер валют" subtitle="Выберите валюты и введите значение" prepend-icon="mdi-swap-horizontal">

        <v-alert v-if="model.result" type="success" title="Результат" :text="model.result.toString()"></v-alert>
        <v-alert v-if="model.error" type="error" title="Ошибка" :text="model.error"></v-alert>

        <v-form action="/task1/cash-converter" method="post">
          <v-combobox
            label="Исходная валюта"
            name="convertFrom"
            :rules="[notEmpty]"
            :items="model.currencies ?? []"
            :model-value="model.convertFrom ?? ''"
          ></v-combobox>
          <v-combobox
            label="Желаемая валюта"
            :rules="[notEmpty]"
            name="convertTo"
            :items="model.currencies ?? []"
            :model-value="model.convertTo ?? ''"
          ></v-combobox>
          <v-text-field
            label="Введите значение"
            :rules="[isNumber, maxLength(8)]"
            name="value"
            hide-details="auto"
            :model-value="model.value ?? ''"
          ></v-text-field>

          <v-btn :block="true" size="large" type="submit">Конвертировать</v-btn>
        </v-form>

      </v-card>

    </v-center>
  </v-container>
</template>

<script setup lang="ts">

import { isNumber, maxLength, notEmpty } from '@/validators'

type ConverterModel = {
  currencies?: string[]
  convertFrom?: string
  convertTo?: string
  value?: string
  result?: number
  error?: string
}
const model = useModel<ConverterModel>()

</script>
