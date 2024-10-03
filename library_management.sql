DROP DATABASE IF EXISTS library_management;
CREATE DATABASE IF NOT EXISTS library_management;
USE library_management;

-- Drop tables if they exist
DROP TABLE IF EXISTS Users;
DROP TABLE IF EXISTS Authors;
DROP TABLE IF EXISTS Publishers;
DROP TABLE IF EXISTS Categories;
DROP TABLE IF EXISTS Documents;
DROP TABLE IF EXISTS BorrowingRecords;
DROP TABLE IF EXISTS Reservations;
DROP TABLE IF EXISTS Reviews;
DROP TABLE IF EXISTS Admins;
DROP TABLE IF EXISTS AdminActions;
DROP TABLE IF EXISTS Fines;

-- Table for managing users
CREATE TABLE Users (
                       user_id INT AUTO_INCREMENT,
                       full_name VARCHAR(255) NOT NULL,
                       user_name VARCHAR(50) NOT NULL UNIQUE,
                       email VARCHAR(255) NOT NULL UNIQUE,
                       password_hash VARCHAR(255) NOT NULL,
                       phone VARCHAR(15) NOT NULL UNIQUE,
                       address TEXT NOT NULL,
                       user_role ENUM('reader', 'admin') DEFAULT 'reader',
                       account_status ENUM('active', 'suspended') DEFAULT 'active',
                       join_date DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
                       last_login DATETIME,
                       login_attempts INT DEFAULT 0,
                       account_locked BOOLEAN DEFAULT FALSE,
                       PRIMARY KEY(user_id)
);

-- Table for managing authors
CREATE TABLE Authors (
                         author_id INT NOT NULL AUTO_INCREMENT,
                         name VARCHAR(255) NOT NULL,
                         biography TEXT,
                         PRIMARY KEY(author_id)
);

-- Table for managing publishers
CREATE TABLE Publishers (
                            publisher_id INT NOT NULL AUTO_INCREMENT,
                            name VARCHAR(255) NOT NULL UNIQUE,
                            address TEXT NOT NULL,
                            contact_info VARCHAR(255),
                            PRIMARY KEY(publisher_id)
);

-- Table for categorizing documents
CREATE TABLE Categories (
                            category_id INT NOT NULL AUTO_INCREMENT,
                            name VARCHAR(255) NOT NULL,
                            description TEXT,
                            PRIMARY KEY(category_id)
);

-- Table for managing documents
CREATE TABLE Documents (
                           document_id VARCHAR(8) NOT NULL,
                           title VARCHAR(255) NOT NULL,
                           author_id INT NOT NULL,
                           publisher_id INT NOT NULL,
                           isbn VARCHAR(13) UNIQUE NOT NULL,
                           category_id INT NOT NULL,
                           publication_year INT CHECK (publication_year BETWEEN 1500 AND 2024),
                           quantity INT NOT NULL,
                           description TEXT,
                           location VARCHAR(255) NOT NULL,
                           PRIMARY KEY(document_id),
                           FOREIGN KEY (author_id) REFERENCES Authors(author_id),
                           FOREIGN KEY (publisher_id) REFERENCES Publishers(publisher_id),
                           FOREIGN KEY (category_id) REFERENCES Categories(category_id)
);

-- Table for recording borrowing transactions
CREATE TABLE BorrowingRecords (
                                  record_id INT NOT NULL AUTO_INCREMENT,
                                  user_id INT NOT NULL,
                                  document_id VARCHAR(8) NOT NULL,
                                  borrow_date DATETIME DEFAULT CURRENT_TIMESTAMP,
                                  return_date DATETIME, -- Can be NULL if the document has not been returned
                                  status ENUM('borrowed', 'returned', 'late', 'lost') DEFAULT 'borrowed',
                                  PRIMARY KEY(record_id),
                                  FOREIGN KEY (user_id) REFERENCES Users(user_id),
                                  FOREIGN KEY (document_id) REFERENCES Documents(document_id)
);

-- Table for reserving documents
CREATE TABLE Reservations (
                              reservation_id INT NOT NULL AUTO_INCREMENT,
                              user_id INT NOT NULL,
                              document_id VARCHAR(8) NOT NULL,
                              reservation_date DATETIME DEFAULT CURRENT_TIMESTAMP,
                              status ENUM('active', 'fulfilled', 'cancelled') DEFAULT 'active',
                              PRIMARY KEY(reservation_id),
                              FOREIGN KEY (user_id) REFERENCES Users(user_id),
                              FOREIGN KEY (document_id) REFERENCES Documents(document_id)
);

-- Table for reviewing documents
CREATE TABLE Reviews (
                         review_id INT NOT NULL AUTO_INCREMENT,
                         user_id INT NOT NULL,
                         document_id VARCHAR(8) NOT NULL,
                         rating INT CHECK (rating BETWEEN 1 AND 5),
                         comment TEXT,
                         review_date DATETIME DEFAULT CURRENT_TIMESTAMP,
                         PRIMARY KEY(review_id),
                         FOREIGN KEY (user_id) REFERENCES Users(user_id),
                         FOREIGN KEY (document_id) REFERENCES Documents(document_id)
);

-- Table for managing administrators
CREATE TABLE Admins (
                        admin_id INT NOT NULL AUTO_INCREMENT,
                        user_id INT NOT NULL,
                        assigned_date DATETIME DEFAULT CURRENT_TIMESTAMP,
                        PRIMARY KEY(admin_id),
                        FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

-- Table for recording admin actions
CREATE TABLE AdminActions (
                              action_id INT NOT NULL AUTO_INCREMENT,
                              admin_id INT NOT NULL,
                              action_type ENUM('add_user', 'remove_user', 'update_user', 'add_document', 'remove_document', 'update_document', 'other') NOT NULL,
                              action_description TEXT,
                              action_date DATETIME DEFAULT CURRENT_TIMESTAMP,
                              target_id INT,
                              PRIMARY KEY(action_id),
                              FOREIGN KEY (admin_id) REFERENCES Admins(admin_id)
);

-- Table for managing overdue fines
CREATE TABLE Fines (
                       fine_id INT AUTO_INCREMENT PRIMARY KEY,
                       user_id INT,
                       record_id INT,    -- Links to borrowing records
                       fine_amount DECIMAL(5, 2) NOT NULL,
                       due_date DATE NOT NULL,
                       status ENUM('UNPAID', 'PAID') DEFAULT 'UNPAID',
                       FOREIGN KEY (user_id) REFERENCES Users(user_id),
                       FOREIGN KEY (record_id) REFERENCES BorrowingRecords(record_id)
);
