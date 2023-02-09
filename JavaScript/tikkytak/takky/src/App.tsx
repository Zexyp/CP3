import { useState } from 'react'
import reactLogo from './assets/react.svg'
import './App.css'
import {History} from "./components/History";
import {Board} from "./components/Board";
import {act, Simulate} from "react-dom/test-utils";
import play = Simulate.play;

const funnyCombinations = [
    [0, 1, 2],
    [3, 4, 5],
    [6, 7, 8],

    [0, 3, 6],
    [1, 4, 7],
    [2, 5, 8],

    [0, 4, 8],
    [2, 4, 6],
]

function App() {
    let [array, setArray] = useState(Array(9).fill(NaN))
    let [active, setActive] = useState(["x", "o"][Math.floor(Math.random() * 2)])

    function handleClick(index: number) {
        if (typeof array[index] === "string")
            return

        if (active == "x" || active == "o")
            array[index] = active
        else
            return

        if (active == "x")
            active = "o"
        else if (active == "o")
            active = "x"

        setArray([...array])
        setActive(active)

        try {
            funnyCombinations.forEach((sol) => {
                if (array[sol[0]] == array[sol[1]] && array[sol[1]] == array[sol[2]]) {
                    throw array[sol[0]]
                }
            })
        }
        catch (player) {
            // @ts-ignore
            if (typeof player === "string") {
                setActive(player + " won")
            }
        }
    }

    return (
        <div className="App">
            <h1>Nick Gurr's App</h1>
            <Board
                array={array}
                onClick={handleClick}
                activePlayer={active}
            />
            <History/>
        </div>
    )
}

export default App
