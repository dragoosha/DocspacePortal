# ONLYOFFICE Android App Prototype

## Languages
- [English](README.md)
- [Русский](README_ru.md)

## Description
This project is a prototype of an Android application that utilizes the public ONLYOFFICE API. The application allows users to authenticate on the ONLYOFFICE portal and manage their documents.

## Features

### Portal Login Screen
- Enter portal address, login, and password.
- Authenticate on the portal.
- Display request progress and handle authentication errors.
- Validate input form data.

### File List Screen
- Upon successful authentication, displays content from the "Documents", "Rooms", and "Trash" categories.
- Implements navigation through nested folders.

### Profile Screen
- Displays user information: avatar, username, and email.

### Logout Function
- Returns the user to the login screen.

## Technologies Used
- Kotlin
- Jetpack Compose
- Jetpack Navigation
- Retrofit + Serialization
- Koin
- DataStore
- Coil

## API Endpoints

### Authentication:
- `POST /api/2.0/authentication`  
  Body: `username` and `password`

### Fetching Files:
- `GET /api/2.0/files/@my` (cookie: `asc_auth_key=`)
- `GET /api/2.0/files/$id` (cookie: `asc_auth_key=`)
- `GET /api/2.0/people/@self` (cookie: `asc_auth_key=`)
- `GET /api/2.0/files/rooms` (cookie: `asc_auth_key=`)
- `GET /api/2.0/files/@trash` (cookie: `asc_auth_key=`)

### Logout:
- `POST /api/2.0/authentication/logout` (cookie: `asc_auth_key=`)

## Screenshots
![Screenshot 1](https://github.com/user-attachments/assets/2a9a82dd-28de-4f97-9d0d-812867cf7d05)
![Screenshot 2](https://github.com/user-attachments/assets/f8186fd3-1fe3-4430-8032-e86b59ae8ec2)
![Screenshot 3](https://github.com/user-attachments/assets/f0a34b2e-b944-4847-9978-01054938ba12)
![Screenshot 4](https://github.com/user-attachments/assets/99df85df-1d1a-49ed-93b6-cd87a20afabc)
![Screenshot 5](https://github.com/user-attachments/assets/1dc0e558-dfdf-4568-b937-d02c4ea0d2df)
![Screenshot 6](https://github.com/user-attachments/assets/7f498a34-a992-482f-a65c-39fd528e4665)

## Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/dragoosha/DocspacePortal.git
    ```

2. Import the project into Android Studio.

3. Run the application on an emulator or a real device.
