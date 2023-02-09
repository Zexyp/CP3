import CartToolbar from "./CartToolbar"

interface CartHeaderPropsInterface {
    onReset: () => void
}

export default function CartHeader(props: CartHeaderPropsInterface) {
    return (
        <div>
            CartHeader
            <CartToolbar
                onReset={props.onReset}
            />
        </div>
    )
}