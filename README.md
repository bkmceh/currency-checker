# currency-checker

## 💾 Information

### ❓ What does the program do?
Get the request on `http://localhost:8080/api/currency`
Check the value of currency and return the gif of 1 of the two types (rich or broke).

By default checking USD currency. 

If you need check another currency, write it code and send the GET request on
`http://localhost:8080/api/currency/{code}`

Example: `http://localhost:8080/api/currency/usd`

For finding gif is used `https://developers.giphy.com/docs/api`

For checking value of currency is used `https://docs.openexchangerates.org`

### ❓ What is meaning check currency?
Service send the GET request on Open Exchanger API 
and check the rate of currency по отношению to rubles.
After that service check the difference between today and yesterday's values.
### ❓ What the gif is returning?

Service send the GET request on Giphy API and can return 2 types of gifs:


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