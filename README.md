# Web Automation BDD for Zaidan Educare

This project is a Behavior-Driven Development (BDD) test automation suite for the Zaidan Educare "Pengelolaan Dana Pendidikan Sekolah Zaidan Educare" web application. It uses Java, Selenium WebDriver, Cucumber, and JUni to automate and verify login, logout and page verification scenarios.

## Team Member
- Aryo Rakatama (221524003)
- Muhamad Mathar Rizqi (221524014)
- Muhammad Rama Nurimani(221524021)


## Features
- Automated browser-based testing using Selenium
- BDD-style test scenarios written in Gherkin (Cucumber)
- Page Object Model for maintainable and reusable UI interactions
- Allure reporting integration for test results

## Project Structure
```
web-automation-bdd/
├── pom.xml
├── README.md
├── edgedriver_win64/           # Edge WebDriver and notes
├── src/
│   ├── test/
│   │   ├── java/
│   │   │   └── com/webautomation/
│   │   │       ├── automation/
│   │   │       │   ├── action/         # Page action classes
│   │   │       │   ├── pagelocator/    # Page locator classes
│   │   │       │   └── utils/          # Selenium web driver settings
│   │   │       ├── cucumberRunner/     # Test runner
│   │   │       └── stepdefinitions/    # Step definitions for Cucumber
│   │   └── resources/
│   │       ├── allure.properties       # Allure config
│   │       └── features/               # Gherkin feature files
└── target/                             # Build and test output
```

## Getting Started

### Prerequisites
- Java 17 or higher
- Maven
- Microsoft Edge browser
- Edge WebDriver (included in `edgedriver_win64/`)

### Installation and Running
1. Clone this repository:
   ```sh
   git clone https://github.com/muhammadrama19/web-automation-bdd.git
   cd web-automation-bdd
   ```
2. Running test:
   ```sh
   mvn test
   ```

### Viewing Allure Reports
After running tests:
```sh
mvn allure:serve
```

## Writing Tests
- Feature files are located in `src/test/resources/features/` and use Gherkin syntax.
- Step definitions are in `src/test/java/com/webautomation/stepdefinitions/`.
- Page actions and locators are in `src/test/java/com/webautomation/automation/action/` and `pagelocator/`.


