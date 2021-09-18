# currency-checker

## 💾 Information

### ❓ What does the program do?
Receives the request on `http://localhost:8080/api/currency`<br>
Checks the value of currency and return the gif of 1 of the two types (rich or broke).

By default checking USD currency. 

If you need check another currency, write it code and send the GET request on
`http://localhost:8080/api/currency/{code}`

Example: `http://localhost:8080/api/currency/usd`

For finding gif is used `https://developers.giphy.com/docs/api`

For checking value of currency is used `https://docs.openexchangerates.org`

### ❓ What is meaning checking currency?
Service sends the GET request on Open Exchanger API 
and checks the rate of currency in relation to ruble. <br>
After that service checks the difference between today and yesterday's values.
### ❓ What the gif is returning?

Service sends the GET request on Giphy API and can return 2 types of gifs:
- Rich gif. This is gifs which user search when type "Rich"
- Broke gif. This is gifs which user search when type "Broke"

If the value of currency today in more than yesterday, you will get Rich gif. <br>
Otherwise Broke gif (cause if even the today's value is the same as yesterday, you will not earn any money and only waste time, and time is money haha)


## 📝 How to run

- To get the gif, clone the repository to yourself
- Add `.env` file at the root of project. 
  
    Add yours `EXCHANGE_API_KEY` value and `GIF_API_KEY` value in the `.env` file
- Enable EnvFile for your project
- Run `CurrencyCheckerApplication`

In Free Plan of Open Exchanger API you can check only value of USD
```
Changing the API `base` currency is available for Developer, Enterprise and Unlimited plan clients.
```
