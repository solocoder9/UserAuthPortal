# 🛡️ UserAuthPortal

UserAuthPortal is a Java web application that allows users to register and log in using their email ID and password. The system ensures both client-side and server-side validation of user credentials. It leverages JSP, Servlets, JDBC, and MySQL for a robust authentication mechanism.

## Table of Contents

- [🌟 Features](#features)
- [💻 Technologies Used](#technologies-used)
- [🛠️ Setup Instructions](#setup-instructions)
- [🚀 Usage](#usage)
- [🤝 Contributing](#contributing)
- [📝 License](#license)

## 🌟 Features 

1. **User Authentication:**
   - **Registration:** Allows new users to create an account with a unique email ID and password.
   - **Login:** Enables registered users to log in using their credentials.
   - **Validation:** Implements both client-side (JavaScript) and server-side (Java) validation for registration and login.

2. **Client-Side Validation:**
   - Ensures that user input is correctly formatted before being sent to the server.

3. **Server-Side Validation:**
   - Validates user input on the server to ensure security and data integrity.

4. **Database Integration:**
   - Uses JDBC to connect to a MySQL database (`user_auth_db`) for storing user credentials.

## 💻 Technologies Used  

- Java
- JSP (JavaServer Pages)
- Servlets
- JDBC (Java Database Connectivity)
- MySQL
- Eclipse IDE

## 🛠️ Setup Instructions  

To run UserAuthPortal on your local machine, follow these steps:

1. **Prerequisites:**
   - JDK (Java Development Kit) installed
   - MySQL installed with a database named `user_auth_db`
   - Eclipse IDE (or any Java IDE) installed

2. **Clone the Repository:**
   ```bash
   git clone https://github.com/yourusername/UserAuthPortal.git
