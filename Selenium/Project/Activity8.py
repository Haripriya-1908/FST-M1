from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC



# URL of the website
url = "https://alchemy.hguy.co/lms/"

# Initialize Firefox WebDriver (make sure you have geckodriver in your PATH)
driver = webdriver.Firefox()

# Open the website
driver.get(url)
# Print the title of the page
print("Page title is : ",driver.title)

# Wait for the Contact tab to be clickable
contact_tab = WebDriverWait(driver, 10).until(
    EC.element_to_be_clickable((By.LINK_TEXT, "Contact"))
)

# Click on the Contact tab
contact_tab.click()

# Wait for the Full Name and Email fields to be present
full_name_field = WebDriverWait(driver, 10).until(
        EC.presence_of_element_located((By.ID, "wpforms-8-field_0"))
    )
email_field = WebDriverWait(driver, 10).until(
        EC.presence_of_element_located((By.ID, "wpforms-8-field_1"))
    )
subject_field = WebDriverWait(driver, 10).until(
        EC.presence_of_element_located((By.ID, "wpforms-8-field_3"))
    )
comment_field = WebDriverWait(driver, 10).until(
        EC.presence_of_element_located((By.ID, "wpforms-8-field_2"))
    )

    
    # Enter details in the Full Name and Email fields
full_name_field.send_keys("Ratika Jain")
email_field.send_keys("Ratika@ibm.com")
subject_field.send_keys("English")
comment_field.send_keys("Hello Python")

send_message = WebDriverWait(driver, 10).until(
        EC.presence_of_element_located((By.ID, "wpforms-submit-8"))
    )
send_message.click()
message = driver.find_element(By.ID, "wpforms-confirmation-8")
print("Submission message: ", message.text)

# Close the browser window
driver.quit()
