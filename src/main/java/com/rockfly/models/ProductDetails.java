package com.rockfly.models;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ProductDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "productTypeId")
	private ProductType productType;
	
	private String styleNumber;
	
	private String itemHsnSac;
	
	private String color;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "productSpecifications_id")
	private ProductSpecifications productSpecifications;	
	
	//Size
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "size_id")
	private Size sizes;	
	
	//Quantity
	private String quantity;
	
	//price
	private Long mrp;
	
	private Long salePrice;
	
	private Long wholesalePrice;
	
	private Long purchasePrice;
	
	
	
//	@ManyToMany(cascade = CascadeType.DETACH)
//	private List<RackNumber> rackNumber; 
	
	@CreationTimestamp
	private Date timeStamp;
}
