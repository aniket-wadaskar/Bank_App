package com.bankapp.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name="BankDetails")
public class BankDetails {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    Long  branchCode;
	@Column
	String City;
	@Column
	String Address;
	@OneToOne
	@JoinColumn(name = "Account_Id")
    List<Account> account;
    

}
