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
    tittle = driver.title
    print("Title of the page : ", tittle)
    driver.find_element(By.XPATH, "//*[contains(text(),'Login')]").click()
    driver.find_element(By.ID, "user_login").send_keys("root")
    driver.find_element(By.ID, "user_pass").send_keys("pa$$w0rd")
    driver.find_element(By.ID, "wp-submit").click()
    #Select the menu item that says “All Courses” and click it.
    driver.find_element(By.XPATH, "//*[contains(text(),'All Courses')]").click()
    Page_tittle = driver.title
    print("Title of the All Courses Page is : ", Page_tittle)
    #Select any course and open it.
    driver.find_element(By.XPATH, "//article[@id='post-69']/div[2]/p[2]/a[1]").click()
    #Select Developing Strategy from course
    driver.find_element(By.XPATH, "//div[contains(text(),' Developing Strategy ')]").click()
    Course_title = driver.title
    print("Title of the All Courses Page is : ", Course_title)
    #Select Lesson from Developing Strategy course
    driver.find_element(By.XPATH, "//span[contains(text(),'This is the First Topic')]").click()
    Lesson_title = driver.title
    print("Title of the Lesson is : ", Lesson_title)
    
