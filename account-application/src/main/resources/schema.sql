-- Create ACCOUNT table
DROP TABLE IF EXISTS ACCOUNT;
CREATE TABLE ACCOUNT
(
    account_id NUMERIC NOT NULL,
    balance    DECIMAL NOT NULL,
    PRIMARY KEY (account_id)
);

-- Create OPERATION table
DROP TABLE IF EXISTS OPERATION;
CREATE TABLE OPERATION
(
    id             NUMERIC NOT NULL PRIMARY KEY,
    operation_type VARCHAR2(30),
    date           Date,
    amount         DECIMAL NOT NULL,
    balance        DECIMAL NOT NULL,
    account_id     NUMERIC REFERENCES ACCOUNT (account_id)
);

