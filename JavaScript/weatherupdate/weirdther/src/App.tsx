import { useState } from 'react'
import reactLogo from './assets/react.svg'
import './App.css'

import {WeatherSearch} from "./components/WeatherSearch";
import {WeatherWeek} from "./components/WeatherWeek";
import {WeatherChart} from "./components/WeatherChart";

function App() {
  const [count, setCount] = useState(0)

  return (
    <div className="App">
        <WeatherSearch/>
        <WeatherWeek/>
        <WeatherChart/>
    </div>
  )
}

export default App
