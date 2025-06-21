# 🛍️ Ecommerce Automation Framework

A complete Selenium TestNG framework for automating the end-to-end flow of an e-commerce website.

---

## 🧰 Tech Stack

- ✅ **Java** – Core language
- ✅ **Selenium WebDriver** – UI automation
- ✅ **TestNG** – Test orchestration + DataProviders
- ✅ **MySQL** – Data-driven testing (SQL integration)
- ✅ **Maven** – Build & dependency management
- ✅ **Page Object Model** – Clean, maintainable structure
- ✅ **Abstract Components** – Reusable helper methods
- ✅ **Custom Screenshot Utility** – Captures after key actions
- ✅ **Git & GitHub** – Version control

---

## ✅ Test Flows Implemented

1. 👤 **User Registration**
2. 📦 **Single Product Purchase** – Login, select product, payment, checkout
3. 🛒 **Multiple Product Purchase** – Login, select products, payment, checkout

---

## 📸 Reports & Screenshots

- 🔹 **Screenshots** are captured after important steps
- 🔹 **TestNG HTML Reports** generated post-execution
- 📍 `.gitignore` ensures reports/snapshots are kept local

---

## ⚙️ How to Run the Framework

1. Clone the repository:
2. Set up MySQL
3. Update DB credentials in: /src/test/java/utils/DBConfig.java
4. Run test suite via TestNG XML

🧠 Folder Structure

EcommerceTestAutomation/
├── src/
│   ├── main/java/
│   │   ├── pageObjects/
│   │   └── abstractComponents/
│   └── test/java/
│       ├── base/
│       ├── testClasses/
│       └── utils/
├── screenshots/ (ignored from Git)
├── pom.xml
├── testng.xml
├── .gitignore
└── README.md


📬 Author

Gaurang Gajjar
📧 gauranggajjar26@gmail.com
🔗 [LinkedIn Profile](https://www.linkedin.com/in/gaurang-gajjar-504336242/)

### 🚀 What’s Next?

- 🚧 **Jenkins** – CI/CD setup 
- 🚧 **Custom screenshot folders per test case**
