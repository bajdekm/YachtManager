create database yachtmanager;
use yachtmanager;
create table yacht(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    author VARCHAR(50) NOT NULL,
    isAvailable boolean NOT NULL
);