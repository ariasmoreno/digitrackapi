package com.digitrack.demo.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Email;

@Entity
public class Person {
	
   @Id	
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   
   @NotNull(message = "Name cannot be null")  
   private String name;
   
   @NotNull(message = "Last Name cannot be null")  
   private String lastName;
   
  @NotNull(message = "Cpf cannot be null")
  @Size(min = 11, max = 11, message = "Cpf can only be 11 characters")
  private String cpf;

  @NotNull(message = "Birth Date cannot be null")   
  private String birthDate;

  @NotNull(message = "Email cannot be null") 
  @Pattern(regexp = "^([\\w\\.\\-]+)@([\\w\\-]+)((\\.(\\w){2,10})+)$",message = "The email is not valid")
  private String email;

  @NotNull(message = "Sex cannot be null") 
  private String sex;
  
  @Column(nullable = true)
  private String phone;
  
  @Column(nullable = true)
  private String description;
  
  @NotNull(message = "Registration Date cannot be null")
  private String  registrationDate;
  
  @Column(nullable = true)
  private String  updateDate;

  
public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getCpf() {
	return cpf;
}

public void setCpf(String cpf) {
	this.cpf = cpf;
}

public String getBirthDate() {
	return birthDate;
}

public void setBirthDate(String birthDate) {
	this.birthDate = birthDate;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getSex() {
	return sex;
}

public void setSex(String sex) {
	this.sex = sex;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public String getRegistrationDate() {
	return registrationDate;
}

public void setRegistrationDate(String registrationDate) {
	this.registrationDate = registrationDate;
}

public String getUpdateDate() {
	return updateDate;
}

public void setUpdateDate(String updateDate) {
	this.updateDate = updateDate;
}  
}

