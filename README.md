# 🚀 Demo Test Automation Project

[![Build with Maven](https://img.shields.io/badge/Maven-Build-blue)](https://maven.apache.org/) 
[![TestNG](https://img.shields.io/badge/TestNG-Framework-green)](https://testng.org/) 
[![Allure](https://img.shields.io/badge/Allure-Reports-orange)](https://docs.qameta.io/allure/)

## 📌 Overview
This is a **demo automation framework** for testing web applications using **Java, TestNG, and Allure**.  
It follows the **Page Object Model (POM)** design pattern and includes utilities for:
- Browser management  
- Assertions  
- Logging (Log4j2)  
- Reporting  

---

## 🛠️ Technologies Used
- **Java (17 or higher)**
- **TestNG**
- **Maven**
- **Selenium WebDriver**
- **Allure Reports**
- **Log4j2**

---

## 📂 Project Structure

```
Demo_Test_AutomationProject/
│├── src/
│   ├── main/java/
│   │   ├── base/                # Base classes (BaseTest, DriverFactory)
│   │   ├── pages/               # Page Object classes
│   │   ├── utils/               # Utility classes (ConfigReader, Logger, WaitUtils)
│   │   └── listeners/           # TestNG Listeners
│   ├── test/java/
│   │   └── tests/               # Test classes
│   └── main/resources/
│       ├── web.properties       # Configuration file
│       └── log4j2.xml          # Log4j2 configuration
│
├── test-outputs/                # Test outputs (logs, screenshots, reports)
│   ├── Logs/app.log
│   ├── screenshots/
│   └── allure-results/
│
├── pom.xml                      # Maven configuration
└── README.md                    # Project documentation
```

---

## ✅ Prerequisites
- Install **Java 17+**  
- Install **Maven 3.6+**  
- Chrome/Firefox browser drivers (ensure they are in your `PATH`)  

---

## ⚡ Setup Instructions
1. **Clone the repository**

   ```bash
   git clone <repo-url>
   cd Demo_Test_AutomationProject

2. **Dependencies**
   Maven automatically downloads required dependencies from `pom.xml`.
3. **Configuration**

    * Update `src/main/resources/web.properties` (browser, URL, etc.).
    * Adjust other property files if needed.

---

## ▶️ Running Tests

Run all tests:

```bash
mvn clean test
```

Run tests on a specific browser:

```bash
mvn clean test -Dbrowser=chrome
```

Run tests in headless mode:

```bash
mvn clean test -Dbrowser=chrome -Dheadless=true
```

---

## 📊 Test Reports

### Allure Report

Generate and serve the Allure report:

```bash
mvn allure:serve
```

### Logs & Screenshots

* **Logs:** `test-outputs/Logs/app.log`
* **Screenshots:** `test-outputs/screenshots/`

---

## 🔧 Customization

* **Test Data:** `src/test/resources/test-data.json`
* **Configuration:** `web.properties`
* **Reports:** `allure-report/`

---

## 🐞 Troubleshooting

* Ensure browser drivers are in your PATH.
* Check `app.log` for detailed error messages.
* Verify configs inside `web.properties`.

---

## 📬 Contact

👤 **Rana Gamal**

🔗 [GitHub](https://github.com/engRana404) | [LinkedIn](https://www.linkedin.com/in/rana-gamal-daif)


