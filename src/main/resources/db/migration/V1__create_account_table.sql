CREATE TABLE Account (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    phone VARCHAR(20),
    aadhaar VARCHAR(20),
    address VARCHAR(255),
    state VARCHAR(100),
    city VARCHAR(100),
    pincode VARCHAR(20)
);