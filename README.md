# ONLYOFFICE Android App Prototype

## Описание
Данный проект представляет собой прототип приложения для платформы Android, использующего публичный API ONLYOFFICE. Приложение позволяет пользователям аутентифицироваться на портале ONLYOFFICE и управлять своими документами.

## Функционал

### Экран подключения к порталу
- Ввод адреса портала, логина и пароля.
- Авторизация на портале.
- Отображение процесса выполнения запроса и ошибок при неудачной авторизации.
- Валидация формы ввода данных.

### Экран списка файлов
- При успешной авторизации отображается список содержимого категории "Documents", "Rooms", "Trash.
- Реализована навигация по вложенным папкам.

### Экран профиля
- Отображение информации о пользователе: аватар, имя пользователя, email.

### Функция выхода
- Возвращает пользователя на экран логина.

## Использованные технологии
- Kotlin
- Jetpack Compose
- Jetpack Navigation
- Retroffit + Serialization
- Koin
- DataStore
- Coil


## Эндпоинты API

### Авторизация:
- `POST /api/2.0/authentication`  
  В теле: `username` и `password`

### Получение файлов:
- `GET /api/2.0/files/@my` (куки: `asc_auth_key=` )
- `GET /api/2.0/files/$id` (куки: `asc_auth_key=`)
- `GET /api/2.0/people/@self` (куки: `asc_auth_key=`)
- `GET /api/2.0/files/rooms` (куки: `asc_auth_key=`)
- `GET /api/2.0/files/@trash` (куки: `asc_auth_key=`)

### Выход:
- `POST /api/2.0/authentication/logout` (`asc_auth_key=`)

## Скриншоты
![Скриншот 1](https://github.com/user-attachments/assets/2a9a82dd-28de-4f97-9d0d-812867cf7d05)
![Скриншот 2](https://github.com/user-attachments/assets/f8186fd3-1fe3-4430-8032-e86b59ae8ec2)
![Скриншот 3](https://github.com/user-attachments/assets/f0a34b2e-b944-4847-9978-01054938ba12)
![Скриншот 4](https://github.com/user-attachments/assets/99df85df-1d1a-49ed-93b6-cd87a20afabc)
![Скриншот 5](https://github.com/user-attachments/assets/1dc0e558-dfdf-4568-b937-d02c4ea0d2df)
![Скриншот 6](https://github.com/user-attachments/assets/7f498a34-a992-482f-a65c-39fd528e4665)



## Установка

1. Клонируйте репозиторий:
    ```bash
    git clone https://github.com/dragoosha/DocspacePortal.git
    ```

2. Импортируйте проект в Android Studio.

3. Запустите приложение на эмуляторе или реальном устройстве.

