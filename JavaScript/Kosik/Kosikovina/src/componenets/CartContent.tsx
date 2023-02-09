import CartItem from "./CartItem";
import {CounterInterface} from "../App";

interface CartContentPropsInterface {
    counters: CounterInterface[]
    onIncrement: (_: CounterInterface) => void
    onDecrement: (_: CounterInterface) => void
}

export default function CartContent(props: CartContentPropsInterface) {
    return (
        <div>
            CartContent
            {props.counters.map(counter =>
                <CartItem
                    counter={counter}
                    onIncrement={() => props.onIncrement(counter)}
                    onDecrement={() => props.onDecrement(counter)}
                />)
            }
        </div>
    )
}