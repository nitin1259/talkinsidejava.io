import React from 'react';
import { getCurrencyForm } from './Crypto.config';
const css = require('./CryptoCcyList.css');

export default class DropDown extends React.Component {
    constructor() {
        super();
    }

    render () {
        let currencies = this.props.currencyArr;
        let optionItems = currencies.map((curr) =>
                <option key={curr} value={curr}>{getCurrencyForm(curr)}</option>
            );

        return (
         <div>
             <select onChange={this.props.changeOption} className={css.customSelect}>
                {optionItems}
             </select>
         </div>
        )
    }
}