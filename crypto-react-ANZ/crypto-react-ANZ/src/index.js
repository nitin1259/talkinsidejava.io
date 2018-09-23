import React from 'react';
import ReactDOM from 'react-dom';
import { createStore } from 'redux'
import CryptoCcyList from './components/CryptoCcyList';
import cryptoCurrReducer from './redux/reducers';
import { Provider } from 'react-redux'

const store = createStore(cryptoCurrReducer);

function initialise() {
    const app = document.createElement('div');
    document.body.appendChild(app);
    ReactDOM.render(
        <Provider store={store}><CryptoCcyList /></Provider>,
        app);
}

initialise();