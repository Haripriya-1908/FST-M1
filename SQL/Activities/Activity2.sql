REM   Script: Activity2
REM   1st day SQL Activity

CREATE TABLE salesman ( 
    salesman_id int, 
    salesman_name varchar2(32), 
    salesman_city varchar2(32), 
    commission int 
);

DESCRIBE salesman


DESCRIBE salesman


CREATE TABLE salesman ( 
    salesman_id int NULL, 
    salesman_name varchar2(32) NOT NULL, 
    salesman_city varchar2(32), 
    commission int 
);

DESCRIBE salesman


DESCRIBE salesman


Drop Table salesman;

CREATE TABLE salesman ( 
    salesman_id int, 
    salesman_name varchar2(32) NOT NULL, 
    salesman_city varchar2(32), 
    commission int 
);

DESCRIBE salesman


INSERT ALL 
    INTO salesman VALUES (5001, 'James Hoog', 'New York', 15)  
    INTO salesman VALUES (5002, 'Nail Knite', 'Paris', 13) 
    INTO salesman VALUES (5003, 'Lauson Hen', 'San Jose', 14)  
    INTO salesman VALUES (5007, 'Paul Adam', 'Rome', 16) 
    INTO salesman VALUES (5005, 'Pit Alex', 'New York ', 17) 
    INTO salesman VALUES (5006, 'McLyon', 'Paris', 12) ;

INSERT ALL 
    INTO salesman VALUES (5001, 'James Hoog', 'New York', 15)  
    INTO salesman VALUES (5002, 'Nail Knite', 'Paris', 13) 
    INTO salesman VALUES (5003, 'Lauson Hen', 'San Jose', 14)  
    INTO salesman VALUES (5007, 'Paul Adam', 'Rome', 16) 
    INTO salesman VALUES (5005, 'Pit Alex', 'New York ', 17) 
    INTO salesman VALUES (5006, 'McLyon', 'Paris', 12)  
SELECT 1 from DUAL;

INSERT ALL 
    INTO salesman VALUES (5001, 'James Hoog', 'New York', 15)  
    INTO salesman VALUES (5002, 'Nail Knite', 'Paris', 13) 
    INTO salesman VALUES (5003, 'Lauson Hen', 'San Jose', 14)  
    INTO salesman VALUES (5007, 'Paul Adam', 'Rome', 11) 
    INTO salesman VALUES (5005, 'Pit Alex', 'New York ', 13) 
    INTO salesman VALUES (5006, 'McLyon', 'Paris', 12)  
SELECT 1 from DUAL;

SELECT * FROM salesman;

