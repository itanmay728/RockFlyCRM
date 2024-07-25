package com.rockfly.models;

import java.time.LocalDate;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customers {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String shopName;
	
	private String partyName;
	
	private String contactPerson;
	
	private String email;
	
	private String city;
	
	private String state;
	
	private String phone;
	
	private  String address;
	
	private String pincode;
	
	private String documentNumber;
	
	private Long openingBalance;
	
	private LocalDate asOfDate;
	
	private Long creditLimit;
	
	@CreationTimestamp
	private Date timeStamp;
	
	private Integer status = 0;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="documentType")
	private DocumentType documentType;
	
	
}
