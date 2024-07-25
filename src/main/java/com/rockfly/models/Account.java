package com.rockfly.models;

import java.util.HashSet;
import java.util.Set;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String email;

	private String password;

	private String name;

	private String phone;

	private String aadhaar;

	private String address;

	private String state;

	private String city;

	private String pincode;

//	private String role;

//	@ManyToMany
//	@JoinTable(name = "account_authority",
//			// based on id in Account table
//			joinColumns = { @JoinColumn(name = "account_id", referencedColumnName = "id") },
//			// based on authority table
//			inverseJoinColumns = { @JoinColumn(name = "authority_id", referencedColumnName = "id") })
//
//	private Set<Authority> authorities = new HashSet<>();

	@ManyToMany
	@JoinTable(name = "Account_roles", joinColumns = @JoinColumn(name = "account_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Roles> roles = new HashSet<>();

	public void addRole(Roles roles) {
		this.roles.add(roles);
	}
}
