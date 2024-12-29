# Calculator App 

## Description  
This is an Android calculator application built using Jetpack Compose. The app supports arithmetic operations, trigonometric functions, and uses the exp4j library for expression evaluation.  

## Functionalities  
- Basic arithmetic operations (+, -, *, /).

  
![+](https://github.com/user-attachments/assets/0a290e14-67bf-43ce-874e-5abca7712873)     ![-](https://github.com/user-attachments/assets/20f3bf7b-0e7e-4b17-aa2b-ebe00cc00982)      ![умнож](https://github.com/user-attachments/assets/ab9dbdbd-1948-4d80-bfd0-ca30196f5727)      ![дел](https://github.com/user-attachments/assets/b32ebd14-d5cc-4681-8b6f-ceef1b2cc172)




- Trigonometric functions (sin, cos, tan, cot).

![син](https://github.com/user-attachments/assets/aea22ab0-7862-477a-b713-e7ac8200bcc9)     ![кос](https://github.com/user-attachments/assets/bf6417ca-1aa8-47e0-b631-d511239b78ce)     ![тан](https://github.com/user-attachments/assets/8e4f9608-f3d6-4348-ae4c-eab9510e7bc7)      ![кот](https://github.com/user-attachments/assets/85d24c31-364b-4072-9b9d-513859712479)



 
 
- Real-time result updates.  

## Usage  
1. Run the application on an emulator or device.  
2. Enter numbers and operators using the on-screen buttons.  
3. Press "=" to get the result.  
4. Use the "C" button to clear the input.  

## Testing  
Unit tests are implemented using JUnit to ensure the correct execution of various operations and to validate the app's behavior in edge cases.  

 Test Descriptions  
- **Division by Zero**: Verifies that the app returns an error message when attempting to divide by zero.  
- **Empty Input**: Checks if the app returns an error message when the input expression is empty.  
- **Trigonometric Functions**: Tests the correctness of calculations for `sin`, `cos`, `tan`, and `cot` functions.  
- **Consecutive Operators**: Ensures that expressions with invalid operator sequences (e.g., `5++5`) are handled as errors.  
- **Complex Expressions**: Verifies the correctness of expressions with multiple operations, such as `3+2*3`.  
- **Trigonometric Edge Cases**: Ensures functions like `sin 180` and `cot 0` return the expected results or infinity for asymptotes.  
- **Negative Numbers**: Checks whether the app correctly processes expressions with negative numbers, such as `-1-1`.  

## Project Benefits  
This project is beneficial for:  
- Learning the basics of Android app development using Jetpack Compose.  
- Understanding the use of libraries for mathematical calculations, such as exp4j.  
- Practicing writing clean and structured code.

# Calculator App 

## Описание

Это приложение калькулятора на Android, написанное с использованием Jetpack Compose. 
Приложение поддерживает арифметические операции, тригонометрические функции и работает на библиотеке exp4j.

## Функционал

1) Основные арифметические операции (+, -, *, /).

![+](https://github.com/user-attachments/assets/0a290e14-67bf-43ce-874e-5abca7712873)     ![-](https://github.com/user-attachments/assets/20f3bf7b-0e7e-4b17-aa2b-ebe00cc00982)      ![умнож](https://github.com/user-attachments/assets/ab9dbdbd-1948-4d80-bfd0-ca30196f5727)      ![дел](https://github.com/user-attachments/assets/b32ebd14-d5cc-4681-8b6f-ceef1b2cc172)


2) Тригонометрические функции (sin, cos, tan, cot).

![син](https://github.com/user-attachments/assets/aea22ab0-7862-477a-b713-e7ac8200bcc9)     ![кос](https://github.com/user-attachments/assets/bf6417ca-1aa8-47e0-b631-d511239b78ce)     ![тан](https://github.com/user-attachments/assets/8e4f9608-f3d6-4348-ae4c-eab9510e7bc7)      ![кот](https://github.com/user-attachments/assets/85d24c31-364b-4072-9b9d-513859712479)


3) Обновление результата в режиме реального времени.


## Использование

1) Запустите приложение на эмуляторе или устройстве.

2) Вводите цифры и операторы с помощью кнопок на экране.

3) Нажимайте "=" для получения результата.

4) Используйте кнопку "C" для очистки ввода.


## Тестирование

Для тестирования приложения используются модульные тесты с использованием JUnit. Эти тесты проверяют корректность выполнения различных операций и поведения приложения в граничных случаях.

Описание тестов

1) Проверка деления на 0:
Проверяет, возвращает ли приложение сообщение об ошибке при попытке деления на 0.

2) Пустой ввод:
Проверяет, возвращает ли приложение сообщение об ошибке, если выражение пустое.

3) Тригонометрические функции:
Проверяет корректность вычислений для функций sin, cos, tan, и cot.

4) Последовательные операторы:
Убеждается, что выражения с некорректной последовательностью операторов (например, 5++5) обрабатываются как ошибка.

5) Сложные выражения:
Проверяет корректность выполнения выражений с несколькими операциями, такими как 3+2*3.

6) Граничные случаи тригонометрии:
Убеждается, что функции, такие как sin 180 и cot 0, возвращают ожидаемые значения или бесконечность для асимптот.

7) Отрицательные числа:
Проверяет, корректно ли приложение обрабатывает выражения с отрицательными числами, например, -1-1.


## Польза от проекта

Этот проект полезен для:

1) Изучения основ разработки приложений на Android с использованием Jetpack Compose.

2) Понимания работы с библиотеками для математических вычислений, такими как exp4j.

3) Практики написания чистого и структурированного кода.
