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

    wait = WebDriverWait(driver, 10)

    My_Account = driver.find_element(By.XPATH, "//a[contains(text(),'My Account')]")
    My_Account.click()
    Page_tittle = driver.title
    print("Title of the page : ", Page_tittle)
    driver.find_element(By.XPATH, "//*[contains(text(),'Login')]").click()
    driver.find_element(By.ID, "user_login").send_keys("root")
    driver.find_element(By.ID, "user_pass").send_keys("pa$$w0rd")
    driver.find_element(By.ID, "wp-submit").click()
    Display_Username =  driver.find_element(By.CLASS_NAME, "display-name").text
    print("User has been logged in")
    assert Display_Username == "root"
