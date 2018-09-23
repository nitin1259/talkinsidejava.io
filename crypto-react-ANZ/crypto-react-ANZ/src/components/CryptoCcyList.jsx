import React from 'react';
import { getCryptoData } from '../api/api';
import CryptoCcyDisplay from './CryptoCcyDisplay';
import { connect } from 'react-redux'
import DropDown from './DropDown';
import { currencyOption } from './Crypto.config';
import { currencySelector } from '../redux/action-crypto'

const css = require('./CryptoCcyList.css');

class CryptoCcyList extends React.Component {
    constructor() {
        super()
        this.fetchCryptoData = this.fetchCryptoData.bind(this)
    }

    componentDidMount() {
        this.fetchCryptoData('SGD');
    }

    fetchCryptoData(displayCcy) {
        getCryptoData(displayCcy).then(cryptoData => {
            this.formatOutput(cryptoData, displayCcy)
        })
    }

    formatOutput(cryptoData, displayCcy) {
        const objValue = {
            currency: displayCcy,
            cryptoDatalist: cryptoData
        }

        this.props.currencySelector(objValue)
    }

    handleOptionChange(event) {
        // console.log(event.target.value);
        this.fetchCryptoData(event.target.value);
    }

    render() {
        return (
            <div>
                <div style={{ display: 'flex', marginBottom: '5px' }}>
                    <span className={css.curSelectStr}>Select Currency : </span>
                    <DropDown currencyArr={currencyOption} changeOption={this.handleOptionChange.bind(this)} />
                </div>
                <span className={css.headingFormat}><h2> Displaying top 5 cryptocurrency in the market</h2> </span>
                {/* {this.state.cryptoDataList} */}
                <CryptoCcyDisplay />
            </div>
        );

    }
}



const mapStateToProps = (state) => {
    return {
        cryptoCurrency: state.cryptoCurrencytData
    }
}

const mapDispatchToProps = (dispatch) => {
    return { 
        currencySelector: (items) => dispatch(currencySelector(items)) 
    }
    // return bindActionCreators({currencySelector : currencySelector}, dispatch)
}


export default connect(mapStateToProps, mapDispatchToProps)(CryptoCcyList);
