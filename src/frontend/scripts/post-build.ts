import fs from 'fs'
import path from 'path'

const resPath = path.join(__dirname, '../../main/resources')
const staticPath = path.join(resPath, 'static')
const templatesPath = path.join(resPath, 'templates')

const buildIndex= fs.readFileSync(path.join(staticPath, 'index.html'), { encoding: 'utf-8' })

fs.writeFileSync(path.join(templatesPath, 'index.html'), buildIndex, { encoding: 'utf-8' })
