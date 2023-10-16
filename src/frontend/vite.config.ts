import vue from '@vitejs/plugin-vue'
import legacy from '@vitejs/plugin-legacy'
import vuetify, { transformAssetUrls } from 'vite-plugin-vuetify'
import ViteFonts from 'unplugin-fonts/vite'

import AutoImport from 'unplugin-auto-import/vite'
import Components from 'unplugin-vue-components/vite'

import { defineConfig } from 'vite'

export default defineConfig({
  plugins: [
    vue({
      template: { transformAssetUrls }
    }),
    vuetify({
      autoImport: true,
    }),
    ViteFonts({
      google: {
        families: [{
          name: 'Roboto',
          styles: 'wght@100;300;400;500;700;900',
        }],
      },
    }),
    legacy(),
    AutoImport({
      imports: [
        'vue',
        'vue-router',
        {
          '@/plugins/model':  ['useModel'],
        }
      ],
      dts: './src/auto-imports.d.ts',
    }),
    Components({
      dirs: ['src/components'],
      dts: './src/auto-components.d.ts',
    })
  ],
  define: { 'process.env': {} },
  resolve: {
    alias: {
      '@': '/src'
    },
    extensions: [ '.js', '.json', '.jsx', '.mjs', '.ts', '.tsx', '.vue', ]
  },
  server: {
    port: 3000
  },
  build: {
    outDir: '../main/resources/static'
  }
})
