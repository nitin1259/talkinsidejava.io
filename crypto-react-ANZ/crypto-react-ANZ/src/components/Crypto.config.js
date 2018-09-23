export const currencyOption = ["SGD", "AUD", "EUR", "GBP", "USD", "VND"]

const currecnyMap = new Map();
currecnyMap.set("SGD", "Singapore Doller")
currecnyMap.set("AUD", "Australian Doller")
currecnyMap.set("EUR", "Euro")
currecnyMap.set("GBP", "Great Britain Pound")
currecnyMap.set("USD", 'US Doller')
currecnyMap.set("VND", "Vietnamese Dong")

export const getCurrencyForm = (curr) =>{
    return currecnyMap.get(curr);
}