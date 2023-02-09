// forget about semicolons, we are writing python

import { useState } from 'react'
import './App.css'

import CartHeader from "./componenets/CartHeader";
import CartContent from "./componenets/CartContent";

export interface CounterInterface {
    id: number
    value: number
}

const initCounters: CounterInterface[] = [
    { id: 1, value: 0 },
    { id: 2, value: 0 },
    { id: 3, value: 0 },
]

function App() {
    const [counters, setCounters] = useState<CounterInterface[]>(initCounters)

    function handleIncrement(counter: CounterInterface) {
        counter.value++
        setCounters([...counters])
    }

    function handleDecrement(counter: CounterInterface) {
        counter.value--
        setCounters([...counters])
    }

    function handleReset() {
        counters.forEach(c => c.value = 0)
        setCounters([...counters])
    }

    return (
        <div>
            <CartHeader
                onReset={handleReset}
            />
            <CartContent
                counters={counters}
                onIncrement={handleIncrement}
                onDecrement={handleDecrement}
            />
        </div>
    )
}

export default App
