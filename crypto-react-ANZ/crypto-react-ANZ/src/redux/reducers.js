import { combineReducers } from 'redux'
import cryptoCurr from './reducer-CryptoCurr'

export const cryptoCurrReducer = combineReducers({
    cryptoCurrencytData: cryptoCurr,
})

export default cryptoCurrReducer;