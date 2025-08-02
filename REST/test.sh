#!/bin/bash

echo "=== Тестирование сервиса авторизации ==="
echo

echo "1. Успешная авторизация admin:"
curl -s "http://localhost:8080/authorize?user=admin&password=password"
echo -e "\n"

echo "2. Успешная авторизация user:"
curl -s "http://localhost:8080/authorize?user=user&password=password"
echo -e "\n"

echo "3. Успешная авторизация guest:"
curl -s "http://localhost:8080/authorize?user=guest&password=password"
echo -e "\n"

echo "4. Ошибка InvalidCredentials (пустой логин):"
curl -s -i "http://localhost:8080/authorize?user=&password=test"
echo -e "\n"

echo "5. Ошибка InvalidCredentials (пустой пароль):"
curl -s -i "http://localhost:8080/authorize?user=test&password="
echo -e "\n"

echo "6. Ошибка UnauthorizedUser (неверные данные):"
curl -s -i "http://localhost:8080/authorize?user=unknown&password=wrong"
echo -e "\n"

echo "=== Тестирование завершено ===" 