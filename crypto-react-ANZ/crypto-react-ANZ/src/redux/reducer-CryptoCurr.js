export default function (state = null, action) {
    switch (action.type) {
        case 'CURRENCY_CHANGED':
            // return action.payload;
            return Object.assign({},  action.payload )
        default : 
            return {
                currency: '',
                cryptoDatalist: []
            }
    }
}