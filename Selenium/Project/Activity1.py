# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Navigate to the URL
    driver.get("https://alchemy.hguy.co/lms")
    
    # Get the title of the page
    title = driver.title
    print("Page title is:", title)

    # Assert the title is correct
    expected_title = "Alchemy LMS – An LMS Application"
    assert title == expected_title, f"Expected title to be '{expected_title}' but got '{title}'"


    