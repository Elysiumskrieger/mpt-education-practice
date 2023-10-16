import { decode } from 'js-base64'
export function useModel<T extends Record<string, any>>(): T {
  const jsonScript = document.querySelector('head script[type="application/json"]')
  if (!jsonScript) return {} as T
  const scriptContent = jsonScript.textContent
  if (!scriptContent) return {} as T
  try {
    return JSON.parse(decode(scriptContent))
  }
  catch (e: any) {
    return {} as T
  }
}
