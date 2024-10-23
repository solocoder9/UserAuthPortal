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
   - **Validation:** Implements both client-side (HTML) and server-side (Java) validation for registration and login.

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
- Apache Tomcat
- Eclipse IDE

## 🛠️ Setup Instructions  

To run UserAuthPortal on your local machine, follow these steps:

1. **Prerequisites:**
   - JDK (Java Development Kit) installed
   - MySQL installed with a database named `user_auth_db`
   - Eclipse IDE (or any Java IDE) installed

2. **Clone the Repository:**
   ```bash
   git clone https://github.com/solocoder9/UserAuthPortal.git
   ```

3. **Import the Project into Eclipse:**
   - Open Eclipse IDE.
   - Select `File` > `Import` > `Existing Projects into Workspace`.
   - Browse to the cloned repository directory and select the project.

4. **Configure MySQL Database:**
   - Ensure MySQL server is running.
   - Create a database named `user_auth_db`:
     ```sql
     CREATE DATABASE user_auth_db;
     ```

5. **Modify Database Connection Details:**
   - Open the appropriate JDBC configuration file (typically in the source code).
   - Update the connection details (URL, username, password) to match your MySQL server configuration.

6. **Deploy the Application:**
   - Deploy the project on a Java web server (like Apache Tomcat).
   - Start the server and access the application through your web browser at `http://localhost:8080/UserAuthPortal`.

## 🚀 Usage  

1. **Starting the Application:**
   - Access the application in your web browser.

2. **Registration:**
   - Click on the “Register” link.
   - Fill out the registration form with a unique email ID and password.
   - Submit the form to create a new account.

3. **Login:**
   - Click on the “Login” link.
   - Enter your registered email ID and password.
   - Click “Login” to access your account.

4. **Validation Messages:**
   - The application will display validation messages for both client-side and server-side errors.
   - Ensure that your input adheres to the specified format for successful registration and login.

## 🤝 Contributing  

Contributions to the UserAuthPortal project are welcome! To contribute:

1. Fork the repository.
2. Create your feature branch (`git checkout -b feature/YourFeature`).
3. Commit your changes (`git commit -am 'Add some feature'`).
4. Push to the branch (`git push origin feature/YourFeature`).
5. Create a new Pull Request.

## 📝 License  

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

