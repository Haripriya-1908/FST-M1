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
    driver.get("https://alchemy.hguy.co/lms/")
    # Print the confirmation message
    Title = driver.find_element(By.XPATH, "//*[contains(text(),'Actionable Training')]").text
    print("Title of first box: ", Title)
    assert Title == "Actionable Training"

    