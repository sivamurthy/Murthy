package com.psm.intellect.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "IntellectUser")
public class User implements java.io.Serializable {
	
	private static final long serialVersionUID = 4910225916550731446L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Valid
    @Size(min = 2,max = 50)
	@Column(name = "firstName", length = 50)
	private String firstName;

	@Valid
    @Size(min = 2,max = 50)
	@Column(name = "lastName", length = 50)
	private String lastName;

	@NotNull
    @Email
    @Column(name = "email", length = 255 )
    private String email;
	
	@NotNull 
	@Column(name="pinCode")
    private Integer pinCode;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name="DATE")
    private Date birthDate;
	
	 @Column(name="Isalive",nullable = false, columnDefinition = "bit default 0")
	    private boolean isAlive;

	public User() {
	}

	public User(Long id) {
		this.id = id;
	}

	public User(Long id, String firstName, String lastName,String email, Integer pinCode, Date birthDate) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.pinCode = pinCode;
		this.birthDate = birthDate;
	}

	public User(String firstName, String lastName, String email, Integer pinCode, Date birthDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.pinCode = pinCode;
		this.birthDate = birthDate;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstname(String firstname) {
		this.firstName = firstName;
	}

	public String getLastname() {
		return this.lastName;
	}

	public void setLastname(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Integer getPinCode() {
		return pinCode;
	}

	public void setPincode(Integer pinCode) {
		this.pinCode = pinCode;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Id: ").append(this.id).append(", firstName: ").append(this.firstName).append(", lastName: ")
				.append(this.lastName).append(", Email: ").append(this.email).append(", Bi: ").append(this.pinCode).append(this.birthDate);
		return sb.toString();
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (id == null || obj == null || getClass() != obj.getClass())
			return false;
		User toCompare = (User) obj;
		return id.equals(toCompare.id);
	
	}
	@Override
	public int hashCode() {
		return id == null ? 0 : id.hashCode();
	}

}





