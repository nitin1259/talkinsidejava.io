export const currencySelector = (objValue) =>{
    // console.log( objValue);
    return {
        type : 'CURRENCY_CHANGED',
        payload : objValue
    }
}