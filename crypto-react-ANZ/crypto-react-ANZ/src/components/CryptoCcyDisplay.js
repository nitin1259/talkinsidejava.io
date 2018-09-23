import React from 'react';
import numeral from 'numeral';
import { connect } from 'react-redux'
const css = require('./CryptoCcyList.css');

class CryptoCcyDisplay extends React.Component {
    constructor(props) {
        super(props)
        this.formatCurrency = this.formatCurrency.bind(this)
    }
    formatCurrency(curr, price) {
        return `${curr} ${numeral(price).format('0,0.00')}`
    }

    createListItems(){
        const cryptoData = this.props.cryptoCurrency.cryptoDatalist
        const currency_price = 'price_' +this.props.cryptoCurrency.currency.toLowerCase();
        return cryptoData.map((ele, i )=>{
            const percentColor= ele.percent_change_24h > 0 ? 'darkseagreen' : 'red'
            return <div className={css.cryptoRow} key={i}>
                <div className={css.cryptoName}>{ele.name}</div>
                <div className={css.cryptoPrice}>{this.formatCurrency(this.props.cryptoCurrency.currency, ele[currency_price])}</div>
                <div style={{ backgroundColor: `${percentColor}` }} className={css.cryptoChange}>{`${ele.percent_change_24h}%`}</div>
            </div>
        })
    }
    render() {

        return (
            <div>
                {this.createListItems()}
            </div>
        );
    }
}

const mapStateToProps = (state) => {
    return {
        cryptoCurrency: state.cryptoCurrencytData
    }
}

export default connect(mapStateToProps)(CryptoCcyDisplay);