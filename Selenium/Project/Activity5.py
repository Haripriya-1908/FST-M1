# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.support.wait import WebDriverWait

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
     # Navigate to the URL
    driver.get("https://alchemy.hguy.co/lms/")

    My_Account = driver.find_element(By.XPATH, "//a[contains(text(),'My Account')]")
    My_Account.click()
    Page_tittle = driver.title
    print("Title of the page : ", Page_tittle)
    assert Page_tittle == "My Account – Alchemy LMS"