# WebookWeb Selenium Automation

This project is a Selenium-based automation script for the Webook web application. It automates the process of account creation, email validation, searching, and filtering categories on the Webook platform.

## Features

- **Automated Account Creation**: Automatically fills out the registration form with unique email addresses.
- **Email Validation**: Ensures that the email is unique and retries if necessary.
- **Search Functionality**: Performs a search for specific items.
- **Filtering**: Filters search results based on selected criteria.

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- IntelliJ IDEA or another Java IDE
- ChromeDriver (compatible with your version of Chrome)

## Setup Instructions

1. **Clone the Repository**:

   ```bash
   git clone https://github.com/Ghaida222/webookWeb.git
   cd webookWeb

2. Install Dependencies in the pom.xml (Maven project)

3. Set Up ChromeDriver:
make sure the ChromeDriver in the driver folders is compitable with your google chrome
Update the path in the code to your own device path:
java file :
System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rahaf\\IdeaProjects\\webookweb\\Drivers\\chromedriver.exe");

## Usage

Run the Application:
Open the project in IntelliJ IDEA.
Run the WebookWeb class to start the automation.

## what it dose
-Navigates to the Webook website.
-Accepts cookies.
-Creates a new account with a unique email.
-Searches for a specific term (e.g., "Game").
-Applies filters to the search results.

## Code overview
The main class, WebookWeb, contains the following methods:

-navigate(): Navigates to the Webook homepage and accepts cookies.
-createAccount(): Handles account creation logic.
-retryEmail(): Re-attempts to create an account with a new email if necessary.
-search(): Searches for items on the Webook platform.
-filter(): Applies filters to search results.

## Video Demonstration

Here is a video demonstration of the WebookWeb automation script in action:

[Watch the Automation Demo] webookWebsite/webook_automation_demo.mp4

## Author
Ghaida Bin Muharib
   
