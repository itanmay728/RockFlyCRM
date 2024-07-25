package com.rockfly.models;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ProductSpecifications {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String specification;
	
	@OneToMany(mappedBy = "productSpecifications")
	@JsonIgnore
	private List<ProductDetails> productDetails;
	
	@ManyToOne
	@JoinColumn(name = "productType_id")
	@JsonIgnore
	private ProductType productType;
	
	@CreationTimestamp
	private Date timeStamp;
}
