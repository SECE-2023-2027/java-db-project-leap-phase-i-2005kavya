Create database Banking_Project;
use Banking_Project;
CREATE TABLE Bank (
    Code INT PRIMARY KEY,
    B_name VARCHAR(50),
    City VARCHAR(50),
    Address VARCHAR(100)
);
CREATE TABLE Branch (
    Branch_Code INT PRIMARY KEY,
    Branch_name VARCHAR(50),
    Address VARCHAR(100),
    Bank_Code INT,
    FOREIGN KEY (Bank_Code) REFERENCES Bank(Code)
);
CREATE TABLE Customer (
    Cust_Id INT PRIMARY KEY,
    F_Name VARCHAR(50),
    L_Name VARCHAR(50),
    Name VARCHAR(101),  
    Mobile_no VARCHAR(15),
    Address VARCHAR(100)
);
CREATE TABLE Account (
    Account_No INT PRIMARY KEY,
    Balance DECIMAL(15, 2),
    Cust_Id INT,
    Branch_Code INT,
    FOREIGN KEY (Cust_Id) REFERENCES Customer(Cust_Id),
    FOREIGN KEY (Branch_Code) REFERENCES Branch(Branch_Code)
);
CREATE TABLE Employee (
    Emp_Id INT PRIMARY KEY,
    Emp_name VARCHAR(50),
    Mobile_no VARCHAR(15),
    Address VARCHAR(100),
    Branch_Code INT,
    FOREIGN KEY (Branch_Code) REFERENCES Branch(Branch_Code)
);
CREATE TABLE Loan (
    Loan_No INT PRIMARY KEY,
    Amount DECIMAL(15, 2),
    Cust_Id INT,
    Emp_Id INT,
    Branch_Code INT,
    FOREIGN KEY (Cust_Id) REFERENCES Customer(Cust_Id),
    FOREIGN KEY (Emp_Id) REFERENCES Employee(Emp_Id),
    FOREIGN KEY (Branch_Code) REFERENCES Branch(Branch_Code)
);
CREATE TABLE Payment (
    Payment_No INT PRIMARY KEY,
    Payment_date DATE,
    Payment_amount DECIMAL(15, 2),
    Loan_No INT,
    FOREIGN KEY (Loan_No) REFERENCES Loan(Loan_No)
);
CREATE TABLE Account_Types (
    Account_No INT,
    Account_Type VARCHAR(10),
    PRIMARY KEY (Account_No, Account_Type),
    FOREIGN KEY (Account_No) REFERENCES Account(Account_No)
);
INSERT INTO Bank VALUES 
(1, 'National Bank', 'New York', '123 Main St'),
(2, 'City Bank', 'Los Angeles', '456 Market St'),
(3, 'Sunrise Bank', 'Chicago', '789 Lake St'),
(4, 'Trust Bank', 'Houston', '101 River St'),
(5, 'Pioneer Bank', 'Miami', '202 Palm St'),
(6, 'Heritage Bank', 'Boston', '303 Ocean Dr'),
(7, 'Summit Bank', 'San Francisco', '404 Pine St'),
(8, 'Global Bank', 'Seattle', '505 Broadway'),
(9, 'Capital Bank', 'Denver', '606 Main Ave'),
(10, 'Harmony Bank', 'Atlanta', '707 King St');
INSERT INTO Branch VALUES 
(101, 'Downtown', '789 Park Ave', 1),
(102, 'Uptown', '321 Elm St', 2),
(103, 'West Side', '111 West St', 3),
(104, 'East Side', '222 East St', 4),
(105, 'Central', '333 Center St', 5),
(106, 'North Branch', '444 North St', 6),
(107, 'South Branch', '555 South St', 7),
(108, 'Main Branch', '666 Main Rd', 8),
(109, 'Lakeside', '777 Lake St', 9),
(110, 'Hilltop', '888 Hill St', 10);
INSERT INTO Customer VALUES 
(1001, 'John', 'Doe', 'John Doe', '1234567890', '555 Pine St'),
(1002, 'Jane', 'Smith', 'Jane Smith', '0987654321', '777 Maple St'),
(1003, 'Michael', 'Johnson', 'Michael Johnson', '5678901234', '999 Oak St'),
(1004, 'Emily', 'Davis', 'Emily Davis', '3456789012', '123 Willow St'),
(1005, 'David', 'Clark', 'David Clark', '2345678901', '456 Cedar St'),
(1006, 'Sophia', 'Lopez', 'Sophia Lopez', '9876543210', '789 Birch St'),
(1007, 'Daniel', 'Lee', 'Daniel Lee', '6789012345', '321 Spruce St'),
(1008, 'Olivia', 'Martinez', 'Olivia Martinez', '4567890123', '222 Maple Ave'),
(1009, 'James', 'Wilson', 'James Wilson', '8901234567', '555 Elm St'),
(1010, 'Mia', 'Harris', 'Mia Harris', '3214567890', '888 Pine Ln');
INSERT INTO Account VALUES 
(5001, 1500.50, 1001, 101),
(5002, 2300.75, 1002, 102),
(5003, 500.00, 1003, 103),
(5004, 3400.25, 1004, 104),
(5005, 1200.00, 1005, 105),
(5006, 3000.00, 1006, 106),
(5007, 800.50, 1007, 107),
(5008, 4200.75, 1008, 108),
(5009, 900.00, 1009, 109),
(5010, 2500.30, 1010, 110);
INSERT INTO Employee VALUES 
(201, 'Michael Johnson', '1122334455', '999 Oak St', 101),
(202, 'Emma Brown', '6677889900', '888 Birch St', 102),
(203, 'Liam White', '2233445566', '123 Park Ave', 103),
(204, 'Noah Green', '3344556677', '456 Lake St', 104),
(205, 'Ava Adams', '4455667788', '789 Broadway', 105),
(206, 'William Scott', '5566778899', '101 Main St', 106),
(207, 'Sophia Hill', '6677889901', '222 Central Ave', 107),
(208, 'Lucas Walker', '7788990011', '333 Beach Rd', 108),
(209, 'Mason King', '8899001122', '444 Ridge Rd', 109),
(210, 'Ella Young', '9900112233', '555 Willow Dr', 110);
INSERT INTO Loan VALUES 
(3001, 5000.00, 1001, 201, 101),
(3002, 10000.00, 1002, 202, 102),
(3003, 7500.50, 1003, 203, 103),
(3004, 6000.00, 1004, 204, 104),
(3005, 12000.75, 1005, 205, 105),
(3006, 3000.00, 1006, 206, 106),
(3007, 8500.25, 1007, 207, 107),
(3008, 4100.00, 1008, 208, 108),
(3009, 9500.00, 1009, 209, 109),
(3010, 2500.30, 1010, 210, 110);
INSERT INTO Payment VALUES 
(4001, '2024-11-01', 500.00, 3001),
(4002, '2024-11-02', 1000.00, 3002),
(4003, '2024-11-03', 750.00, 3003),
(4004, '2024-11-04', 600.00, 3004),
(4005, '2024-11-05', 1200.00, 3005),
(4006, '2024-11-06', 300.00, 3006),
(4007, '2024-11-07', 850.25, 3007),
(4008, '2024-11-08', 410.00, 3008),
(4009, '2024-11-09', 950.00, 3009),
(4010, '2024-11-10', 250.30, 3010);
INSERT INTO Account_Types VALUES 
(5001, 'Saving'),
(5002, 'Current'),
(5003, 'Saving'),
(5004, 'Current'),
(5005, 'Saving'),
(5006, 'Current'),
(5007, 'Saving'),
(5008, 'Current'),
(5009, 'Saving'),
(5010, 'Current');