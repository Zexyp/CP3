interface CartToolbarPropsInterface {
    onReset: () => void
}

export default function CartToolbar(props: CartToolbarPropsInterface) {
    return (
        <div>
            <button onClick={props.onReset}>reset</button>
        </div>
    );
}