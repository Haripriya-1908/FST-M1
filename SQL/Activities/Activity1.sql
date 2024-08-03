REM   Script: Activity1
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


