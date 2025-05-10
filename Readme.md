
# Система управления пользователями и их подписками

Подписки и пользователи хранятся в postgresql. Демо данные внесены в БД посредством liquibase.

Применены: Java 17, Spring Boot, PostgreSQL, Liquibase, Docker-compose.

# Запуск приложения
## Требования
Установленный maven, docker, docker compose

## Запуск
1) Скачайте проект из ветки master
2) в командной строке (cmd/bash) перейдите в каталог проекта

windows: `cd C:\Users\user\Downloads\<КаталогПроекта>`

linux: `cd ~/Downloads/<КаталогПроекта>`

3) Соберите докер образ:

windows:
```bash
./mvnw.cmd -B clean package dockerfile:build
```

linux:
```bash
./mvnw -B clean package dockerfile:build
```

4) Запуск проекта:
```bash
docker compose up
```

## [Техническое задание](tech_spec_java_spring_final_v2.pdf)

## OpenAPI
[swagger-ui](http://127.0.0.1:8080/swagger-ui/index.html)
