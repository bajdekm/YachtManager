create table  reservation(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	yacht_id INT NOT NULL,
    client_id INT NOT NULL,
    is_cancelled boolean NOT NULL
);