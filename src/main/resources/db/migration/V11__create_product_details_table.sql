CREATE TABLE product_details (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    product_type_id BIGINT,
    style_number VARCHAR(255),
    item_hsn_sac VARCHAR(255),
    color VARCHAR(255),
    product_specifications_id BIGINT,
    size_id BIGINT,
    quantity VARCHAR(255),
    mrp BIGINT,
    sale_price BIGINT,
    wholesale_price BIGINT,
    purchase_price BIGINT,
    time_stamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (product_type_id) REFERENCES product_type(product_type_id),
    FOREIGN KEY (product_specifications_id) REFERENCES product_specifications(id),
    FOREIGN KEY (size_id) REFERENCES size(size_id)
);