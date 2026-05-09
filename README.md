🏢 Employee Management System (EMS)
A full-featured Employee Management System built with Java EE, JAX-WS Web Services, JSP, and HTML. It supports complete developer/employee lifecycle management including registration, authentication, profile updates, and email verification.
---

✨ Features
👤 Developer Registration — Register new employees/developers into the system
🔐 Secure Login — Employee and Manager authentication
📧 Email Verification — Verify employee email addresses
🔑 Password Management — Change and reset passwords
📋 View All Developers — Display the complete list of registered developers
✏️ Update Developer — Edit and update employee/developer information
❌ Delete Developer — Remove developer records from the system
🌐 JAX-WS Web Services — Backend exposed as SOAP-based web services
---
📁 Project Structure
```
Employee-Management-System/
│
├── src/
│   └── main/
│       └── java/
│           └── com.em/
│               ├── AddDeveloper.java          # Add new developer logic
│               ├── ChangedPassword.java       # Password change handler
│               ├── DeleteDeveloper.java       # Delete developer logic
│               ├── DisplayAllDevelopers.java  # Fetch all developers
│               ├── EmailVerification.java     # Email verification service
│               ├── LoginEmployee.java         # Employee login handler
│               ├── RegisterManager.java       # Manager registration
│               ├── UpdateDeveloper.java       # Update developer info
│               └── ViewAllDeveloper.java      # View developer list
│
├── webapp/
│   ├── WEB-INF/
│   ├── addDeveloper.html         # Add developer form
│   ├── deleteDeveloper.html      # Delete developer page
│   ├── developer.html            # Developer dashboard
│   ├── displayDeveloper.jsp      # Display developer records (JSP)
│   ├── login.html                # Login page
│   ├── manager.html              # Manager dashboard
│   ├── register.html             # Registration page
│   ├── takeEmail.html            # Email input form
│   ├── takeNewPassword.html      # New password form
│   └── updateDeveloper.jsp       # Update developer form (JSP)
│
├── pom.xml                       # Maven build configuration
└── README.md
```
---
🛠 Tech Stack
Layer	Technology
Language	Java (JDK 8+)
Web Services	JAX-WS (SOAP)
Frontend	HTML5, JSP
Build Tool	Apache Maven
Server	Apache Tomcat
Deployment	WAR (Web Archive)
---
🚀 Getting Started
Prerequisites
Java JDK 8 or higher
Apache Maven 3.x
Apache Tomcat 9.x 
An IDE (Eclipse IDE)

💻 Usage
Manager Flow
Open `register.html` to register as a Manager
Log in via `login.html`
Access the Manager Dashboard to manage developers

Developer Flow
Manager adds a developer via `addDeveloper.html`
Developer logs in and can view/update their profile
Email verification is triggered on registration

Key Operations
Operation	URL / Page
Login	`/login.html`
Register Manager	`/register.html`
Add Developer	`/addDeveloper.html`
View All Developers	`/displayDeveloper.jsp`
Update Developer	`/updateDeveloper.jsp`
Delete Developer	`/deleteDeveloper.html`
Change Password	`/takeNewPassword.html`
Email Verification	`/takeEmail.html`
---
🌐 Web Services
This project exposes its backend functionality via JAX-WS SOAP Web Services.

The following services are available:
`AddDeveloper` — Adds a new developer record
`DeleteDeveloper` — Removes a developer by ID
`UpdateDeveloper` — Updates developer information
`DisplayAllDevelopers` — Returns list of all developers
`LoginEmployee` — Authenticates an employee
`EmailVerification` — Verifies email address
`ChangedPassword` — Handles password change
---

👨‍💻 Author
Abdullah Ansari
GitHub: @abdullahDev13  
Email: aa48411000@gmail.com
---
> ⭐ If you found this project helpful, please give it a star!
