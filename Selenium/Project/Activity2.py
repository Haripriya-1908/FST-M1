
# Import webdriver from selenium
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

  # Get the heading of the page

    heading = driver.find_element(By.CLASS_NAME, "uagb-ifb-title")
    print("heading", heading.text)
    expected_heading = "Learn from Industry Experts"
    if heading.text == expected_heading:
        print("Heading matches exactly: ",heading.text)
    else:
        print("Heading doesnot match ",heading.text)
    driver.quit()