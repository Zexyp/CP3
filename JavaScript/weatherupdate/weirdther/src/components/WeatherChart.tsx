import {ReactElement} from "react";
import "./WeatherChart.css"

export function WeatherChart() {
    return (
        <div className="chart-box">
            <div>
                <h2>Temperature: </h2>
                <h1>-0123456789°C</h1>
            </div>
            <div>
                - insert chart here -
            </div>
        </div>
    )
}