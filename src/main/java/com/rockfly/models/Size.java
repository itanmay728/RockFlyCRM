package com.rockfly.models;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "size")
public class Size {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long sizeId;
	
	private String sizes;
	
	@CreationTimestamp
	private Date timeStamp;
	
	@OneToMany(mappedBy = "sizes")
	@JsonIgnore
	private List<ProductDetails> productDetails;
	
	@ManyToMany(mappedBy = "size")
	@JsonIgnore
	private List<ProductType>  productType;
	
}
