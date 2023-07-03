# Приветствую!

## Проект demodisgroup предназначен для показа базовых знаний о Linux и REST

## Как деплоил на Linux:

### Обновил пакеты всей системы:
```
sudo apt update
```
### Установил пакет openjdk-17-jdk:

```
sudo apt install openjdk-17-jdk
```

### Результат:
```
ubuntu@ip-172-31-87-36:~$ java -version
openjdk version "17.0.7" 2023-04-18
OpenJDK Runtime Environment (build 17.0.7+7-Ubuntu-0ubuntu122.04.2)
OpenJDK 64-Bit Server VM (build 17.0.7+7-Ubuntu-0ubuntu122.04.2, mixed mode, sharing)
ubuntu@ip-172-31-87-36:~$
```

### Установил Git, результат:
```
ubuntu@ip-172-31-87-36:~$ git --version
git version 2.34.1
```

### Установил PostgreSQL, создал пользователя и БД

### Склонировал репозиторий


### Проект разделен на 2 части:
* REST API
* MVC

С MVC частью проекта полностью предназначена для визуализации данных, вы можете ознакомиться пройдя по ссылке: 

/mvc/person/ или /mvc/department/

C REST API частью проекта можно ознакомиться отправив запрос на пути из моих тестов:

## Сущность Department
### GET Req
http://localhost:8080/rest/department/
### Resp
```json
[
    {
        "id": 1,
        "name": "IT2",
        "persons": [
            1,
            2
        ]
    },
    {
        "id": 2,
        "name": "SALES",
        "persons": [
            4,
            5
        ]
    },
    {
        "id": 4,
        "name": "OWNER",
        "persons": [
            10
        ]
    }
]
```

### Get Req
http://localhost:8080/rest/department/1
### Resp
```json
{
    "id": 1,
    "name": "IT2",
    "persons": [
        1,
        2
    ]
}
```

### POST Req
http://localhost:8080/rest/department/
```json
{
  "name": "HR"
}
```
### Resp
```json
{
  "id": 6,
  "name": "HR",
  "persons": null
}
```

### PUT Req
http://localhost:8080/rest/department/
```json
{
    "id": 1,
    "name": "IT"
}
```

### Req
```json
{
    "id": 1,
    "name": "IT",
    "persons": [
        1,
        2
    ]
}
```

### DELETE Req
http://localhost:8080/rest/department/6
### Resp
```json
"OK"
```
## Сущность Person
### GET Req
http://localhost:8080/rest/person/
### Resp
```json
[
    {
        "id": 1,
        "firstname": "Aleksey",
        "lastname": "Zyryanov",
        "department": 1
    },
    {
        "id": 2,
        "firstname": "Semen",
        "lastname": "Lopin",
        "department": 1
    },
    {
        "id": 4,
        "firstname": "Artem",
        "lastname": "Ivanov",
        "department": 2
    },
    {
        "id": 5,
        "firstname": "Ivan",
        "lastname": "Petrov",
        "department": 2
    },
    {
        "id": 10,
        "firstname": "PAVEL",
        "lastname": "DENISOV",
        "department": 4
    },
    {
        "id": 11,
        "firstname": "ARTUR",
        "lastname": "PAVLENKOV",
        "department": 1
    }
]
```
### Get req
http://localhost:8080/rest/person/1
### Resp
```json
{
    "id": 1,
    "firstname": "Aleksey",
    "lastname": "Zyryanov",
    "department": 1
}
```

### POST Req
http://localhost:8080/rest/person/
```json
{
    "firstname": "ARTUR",
    "lastname": "PAVLENKOV",
    "departmentId": 1
}
```
### Resp
```json
{
    "id": 11,
    "firstname": "ARTUR",
    "lastname": "PAVLENKOV",
    "department": 1
}
```

### PUT Req
http://localhost:8080/rest/person/
```json
{
    "id": 11,
    "firstname": "ARTEM",
    "lastname": "DENISOV",
    "departmentId": 2
}
```
### Resp
```json
{
    "id": 11,
    "firstname": "ARTEM",
    "lastname": "DENISOV",
    "department": 2
}
```
### DELETE Req
http://localhost:8080/rest/person/11
### Resp
```json
"OK"
```
