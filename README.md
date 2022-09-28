# abctechservice-api
## URL's publicadas:
### GET:
#### http://abctechserviceapi-env-1.eba-whst6z3z.us-east-1.elasticbeanstalk.com/version
#### http://abctechserviceapi-env-1.eba-whst6z3z.us-east-1.elasticbeanstalk.com/order/operator/123123
#### http://abctechserviceapi-env-1.eba-whst6z3z.us-east-1.elasticbeanstalk.com/assistance
### POST:
#### http://abctechserviceapi-env-1.eba-whst6z3z.us-east-1.elasticbeanstalk.com/order
```
{
    "operatorId": 111222,
    "assists": [1,2],
    "start": {
        "latitude": -23.555420,
        "longitude": -46.601068,
        "dateTime": "2022-09-20T19:00:00"
    },
    "end": {
        "latitude": -23.555420,
        "longitude": -46.601068,
        "dateTime": "2022-09-20T19:00:00"
    }
}
``` 

## ----###SUPORTE PARA RODAR LOCAL###----
## Command create and run Docker:
```docker run --name mysql-dev -p 3306:3306 -e MYSQL_ROOT_PASSWORD=Fiap1234 -d mysql:8.0-oracle```
## Para executar local, Environment variables on "application.yml":
```DB_HOSTNAME=localhost;DB_PORT=3306;DB_NAME=abctechsevicedb;DB_USERNAME=root;DB_PASSWORD=Fiap1234;```
<p>após configurado e conectado executar o seguinte comando SQL</p>
``` create database if not exists abctechsevicedb ```
