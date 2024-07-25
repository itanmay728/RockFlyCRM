CREATE TABLE product_type_size (
  product_type_id BIGINT NOT NULL,
  size_id BIGINT NOT NULL,
  FOREIGN KEY (product_type_id) REFERENCES product_type(product_type_id),
  FOREIGN KEY (size_id) REFERENCES size(size_id),
  PRIMARY KEY (product_type_id, size_id)
);