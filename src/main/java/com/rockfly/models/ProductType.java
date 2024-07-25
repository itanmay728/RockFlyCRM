package com.rockfly.models;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "product_type")
public class ProductType {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long productTypeId;
	
	private String productName;
	
	private String sizeType;
	
	@OneToMany(mappedBy = "productType")
	private List<ProductDetails> productDetails;
	
	@OneToMany(mappedBy = "productType")
	private List<ProductSpecifications> productSpecifications;
	
	@ManyToMany
	@JoinTable(name = "product_type_size", joinColumns = @JoinColumn(name = "product_type_id"), inverseJoinColumns = @JoinColumn(name = "size_id"))
	private List<Size> size;
	
	@CreationTimestamp
	private Date timeStamp;
}
