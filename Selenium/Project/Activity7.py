# Import necessary modules from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

# Set up the Firefox Driver with WebDriverManager
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Navigate to the URL
    driver.get("https://alchemy.hguy.co/lms")

    # Click on the "All Courses" link
    driver.find_element(By.LINK_TEXT, "All Courses").click()

    # Find all course elements by class name
    courses = driver.find_elements(By.CLASS_NAME, "attachment-course-thumb")

    # Print the number of courses found
    print("Number of courses:", len(courses))
