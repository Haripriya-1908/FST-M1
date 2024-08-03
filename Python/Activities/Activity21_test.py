import pytest

@pytest.mark.activity
# Additon test
def test_addition():
	
    # Initialize two numbers
	num1 = 10
	num2 = 15
    
	# Add them
	sum = num1 + num2
 
	# Assertion
	assert sum == 25
@pytest.mark.activity 
# Subtraction test
def test_subtraction():
  
	# Initialize two numbers
	num1 = 50
	num2 = 35
    
	# Subtract them
	diff = num1 - num2
 
	# Assertion
	assert diff == 15
@pytest.mark.activity
# Multiplication test
def test_multiplication():
  
	# Initialize two numbers
	num1 = 5
	num2 = 20
    
	# Multiply them
	prod = num1 * num2
 
	# Assertion
	assert prod == 100
@pytest.mark.activity
# Division test
def test_division():
  
	# Initialize two numbers
	num1 = 100
	num2 = 5
    
	# Divide them
	quot = num1 / num2
 
	# Assertion
	assert quot == 20