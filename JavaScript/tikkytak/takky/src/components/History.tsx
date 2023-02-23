import {ReactElement} from "react";
import "./History.css"

interface HistoryPropsInteface {
    elements: string[]
    onClick: (index: number) => void
}

export function History(props: HistoryPropsInteface): ReactElement {
    return (
        <div>
            <h2>History</h2>
            <ul className="history">
                {
                    props.elements.map((e, i) => {
                        return (
                            <li onClick={() => props.onClick(i)}>{e}</li>
                        )
                    })
                }
            </ul>
        </div>
    )
}