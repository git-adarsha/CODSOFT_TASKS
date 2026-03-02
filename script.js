function convertCurrency() {

  const currencySymbols = {
    USD: "$",
    INR: "₹",
    EUR: "€"
  };

  const amount = document.getElementById("amount").value;
  const from = document.getElementById("fromCurrency").value;
  const to = document.getElementById("toCurrency").value;

  if (amount === "" || amount <= 0) {
    document.getElementById("result").innerText =
      "Please enter a valid amount";
    return;
  }

  
  if (from === to) {
    document.getElementById("result").innerText =
      currencySymbols[from] + amount + " = " +
      currencySymbols[to] + amount;
    return;
  }

  const url =
    "https://api.frankfurter.app/latest?amount=" +
    amount + "&from=" + from + "&to=" + to;

  fetch(url)
    .then(function (response) {
      return response.json();
    })
    .then(function (data) {

      const convertedAmount = data.rates[to];

      document.getElementById("result").innerText =
        currencySymbols[from] + amount +
        " = " +
        currencySymbols[to] + convertedAmount.toFixed(2);
    })
    .catch(function () {
      document.getElementById("result").innerText =
        "Error fetching exchange rate";
    });
}