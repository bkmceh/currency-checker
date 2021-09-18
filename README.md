# currency-checker

## 💾 Information

### ❓ What does the program do?

Receives the request on `http://localhost:8080/api/currency`. Checks the value of currency and return the gif of 1 of
the two types (rich or broke).

By default, service checks USD currency.

If you need check another currency, write it code and send the GET request on
`http://localhost:8080/api/currency/{code}`.

Example: `http://localhost:8080/api/currency/usd`.

[Giphy](https://developers.giphy.com/docs/api) used for searching gifs.

[Open Exchange](https://docs.openexchangerates.org) used for retrieving changing rate of currency.

### ❓ What does it mean checking currency?

Service sends the GET request on Open Exchanger API and checks the rate of currency in relation to ruble. <br>
After that service checks the difference between today and yesterday's values.

### ❓ Which type of gif is returned?

Service sends the GET request on Giphy API and can return 2 types of gifs:

- Rich gif. This is gifs which user search when type "Rich"
- Broke gif. This is gifs which user search when type "Broke"

If the value of currency today in more than yesterday, you will get Rich gif. <br>
Otherwise Broke gif (cause if even the today's value is the same as yesterday, you will not earn any money and only
waste time, and time is money haha)

## 📝 How to run
    # all command should be run in project's root directory

    docker build -t currency_checker:latest .
    docker run -p 8080:80 -e GIPHY_API_KEY=<your_giphy_api_key> -e OPEN_EXCHANGE_API_KEY=<your_giphy_api_key> currency_checker:latest




In Free Plan of Open Exchanger API you can check only value of USD

```
Changing the API `base` currency is available for Developer, Enterprise and Unlimited plan clients.
```