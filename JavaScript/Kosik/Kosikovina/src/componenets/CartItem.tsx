import {CounterInterface} from "../App";

interface CartItemPropsInterface {
    counter: CounterInterface
    onIncrement: () => void
    onDecrement: () => void
}

export default function CartItem(props: CartItemPropsInterface) {
    return (
        <div>
            carterin intem {props.counter.value}
            <button onClick={props.onIncrement}>+</button>
            <button onClick={props.onDecrement} disabled={props.counter.value <= 0}>-</button>
        </div>
    );
}