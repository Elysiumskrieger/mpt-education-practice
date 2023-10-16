export const notEmpty = (value: string) => value !== '' ? true
  : 'Поле не должно быть пустым'
export const maxLength = (length: number) => (value: string) => value.length <= length ? true
  : `Максимальное кол-во символов ${length}`
export const minLength = (length: number) => (value: string) => value.length <= length ? true
  : `Минимальное кол-во символов ${length}`
export const isNumber = (value: string) => /^-?\d+$/.test(value) ? true
  : 'Необходимо ввести число'
