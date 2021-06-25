-- create a new database
CREATE DATABASE form_database;
--in the command line where posgres in open
--type '\l' to see list of you databases
-- use \c "database name" to go into the database

-- when inside the dtabase copy the table schema 
--into the command line and press enter

--then type \dt to see list of relations
CREATE TABLE form(
    user_id SERIAL PRIMARY KEY,
    user_Fname VARCHAR(50),
    user_Lname VARCHAR(50),
    user_Uname VARCHAR(50),
    user_Uemail VARCHAR(100)
);