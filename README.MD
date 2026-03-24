# 🚀 Employee Management System (Java + JDBC + Oracle SQL)

## 📌 Project Overview
The **Employee Management System** is a console-based application developed using **Java (JDBC)** and **Oracle SQL**.  
It allows users to perform core database operations such as adding, viewing, updating, and deleting employee records.

The project also implements **real-world business logic** like salary update tracking using PL/SQL procedures.

---

## 🎯 Key Features

✔ Add new employees  
✔ View all employee records  
✔ Update employee salary (with history tracking)  
✔ Delete employees (with foreign key handling)  
✔ Menu-driven console interface  
✔ Secure database interaction using PreparedStatement  
✔ Stored procedure integration using CallableStatement

---

## 🧠 Advanced Functionality

### 🔹 Salary History Tracking
- Implemented a PL/SQL procedure to:
    - Fetch old salary
    - Update new salary
    - Store changes in `salary_history` table
- Ensures proper auditing of salary updates

---

## 🛠️ Technologies Used

- Java (JDBC)
- Oracle SQL
- PL/SQL (Stored Procedures)
- IntelliJ IDEA / Eclipse

---

## 📂 Project Structure

```
Employee-Management-System/
│
├── src/
│ ├── AddEmployee.java
│ ├── ViewEmployee.java
│ ├── UpdateEmployee.java
│ ├── DeleteEmployee.java
│ └── EmployeeManagementSystem.java
│
├── database/
│ ├── database.sql
│ └── sample_data.sql
│
├── lib/
│ └── ojdbc17.jar
│
├── README.md
└── .gitignore
````
---

## 🗄️ Database Setup

1. Open Oracle SQL Developer or SQL*Plus
2. Run the script:

```sql
@database/database.sql
```
3. (Optional) Insert sample data:

```sql
@database/sample_data.sql
```

---

## ▶️ How to Run the Project


1. Clone the repository:
```

git clone https://github.com/your-username/employee-management-system.git
```

2. Open in your IDE (IntelliJ / Eclipse)

3. Add Oracle JDBC Driver (ojdbc17.jar) to classpath

4. Update database credentials in code:

```
DriverManager.getConnection(
"jdbc:oracle:thin:@localhost:1521:xe",
"username",
"password"
);
```
5. Run:

````
EmployeeManagementSystem.java
````

📸EmployeeManagementSystem.java

````
===== EMPLOYEE MANAGEMENT SYSTEM =====
1. Add Employee
2. View Employees
3. Update Salary
4. Delete Employee
5. Exit
````
---

## 🎯 Learning Outcomes

* Understanding of JDBC architecture

* Performing CRUD operations using Java

* Integration of PL/SQL with Java

* Handling foreign key constraints

* Writing modular and maintainable code

---

Developed a menu-driven Employee Management System using Java and JDBC with Oracle Database. Implemented CRUD operations and PL/SQL procedures for salary update with history tracking. Ensured data integrity by handling foreign key constraints and structured code using modular design principles.

---
## 🚀 Future Enhancements
* GUI using Java Swing / JavaFX

* Authentication system (Login feature)

* Department-wise reporting

* REST API integration

--- 
👩‍💻 Author

Urvi Patil

Engineering Graduate
Interested in Data Analytics, SQL, and Finance

---
⭐ If you like this project

Give it a ⭐ on GitHub!