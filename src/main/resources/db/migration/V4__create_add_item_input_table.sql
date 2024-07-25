CREATE TABLE add_item_input (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  product_type VARCHAR(255) NOT NULL,
  style_number VARCHAR(255) NOT NULL,
  item_hsn_sac VARCHAR(255) NOT NULL,
  color VARCHAR(255),
  product_specification TEXT,
  size VARCHAR(255),
  quantity VARCHAR(255),
  mrp BIGINT,
  sale_price BIGINT,
  wholesale_price BIGINT,
  purchase_price BIGINT
);
