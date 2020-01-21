package com.packt.casino.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;



@Entity
@Table(name = "user")
@SecondaryTable(name = "address")
public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(table = "user")
	private Long userId;
	@NotEmpty(message = "{casino.registrate.notEmpty}")
	@NotNull
	@Column(table = "user")
	private String name;
	@NotEmpty(message = "{casino.registrate.notEmpty}")
	@NotNull
	@Column(table = "user")
	private String surname;
	@NotEmpty
	@NotNull
	@Pattern(regexp = "[\\w]+@[\\w]+.[\\w]+", message = "{{casino.registration.email.error}")
	@Column(table = "user")
	private String email;
	@NotEmpty(message = "{casino.registrate.notEmpty}")
	@NotNull
	@Pattern(regexp = "[0-9][0-9]-[0-1][0-9]-[0-9][0-9][0-9][0-9]", message = "{{casino.registrate.birthday.error}")
	@Column(table = "user")
	private String birthday;
	@NotEmpty
	@NotNull
	@Column(table = "user")
	private double credit;
	@NotEmpty
	@NotNull
	@Column(table = "user")
	private boolean admin;
	@NotEmpty
	@NotNull
	@Column(table = "user")
	private boolean isActivated;
	@NotNull
	@NotEmpty
	@Column(table = "address")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long addressId;
	@NotEmpty
	@NotNull
	@Column(table = "user")
	private String password;
	@NotEmpty(message = "{casino.registrate.notEmpty}")
	@NotNull
	@Column(table = "address")
	private String street;
	@NotEmpty(message = "{casino.registrate.notEmpty}")
	@NotNull
	@Column(table = "address")
	private String streetNr;
	@NotEmpty(message = "{casino.registrate.notEmpty}")
	@NotNull
	@Column(table = "address")
	private String postalCode;
	@NotEmpty(message = "{casino.registrate.notEmpty}")
	@NotNull
	@Column(table = "address")
	private String city;


	@Override
	public String toString() {
		return String.format(
				"User[idUser=%d, name='%s',\nsurname='%s', email='%s',\nbirthday='%s', street='%s',\nstreetNr='%s', postalCode='%s', \ncity='%s']",
				userId, name, surname, email, birthday, street, streetNr, postalCode, city);
	}

	public Long getUserId()
	{
		return userId;
	}

	public void setUserId(Long idUser)
	{
		this.userId = idUser;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getSurname()
	{
		return surname;
	}

	public void setSurname(String surname)
	{
		this.surname = surname;
	}

	public String getBirthday()
	{
		return birthday;
	}

	public void setBirthday(String birthday)
	{
		this.birthday = birthday;
	}

	public double getCredit()
	{
		return credit;
	}

	public void setCredit(double credit)
	{
		this.credit = credit;
	}

	public boolean isAdmin()
	{
		return admin;
	}

	public void setAdmin(boolean admin)
	{
		this.admin = admin;
	}

	public boolean isIsActivated()
	{
		return isActivated;
	}

	public void setIsActivated(boolean isactivated)
	{
		this.isActivated = isactivated;
	}


	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getStreet()
	{
		return street;
	}

	public void setStreet(String street)
	{
		this.street = street;
	}

	public String getStreetNr()
	{
		return streetNr;
	}

	public void setStreetNr(String streetNr)
	{
		this.streetNr = streetNr;
	}

	public String getPostalCode()
	{
		return postalCode;
	}

	public void setPostalCode(String postalCode)
	{
		this.postalCode = postalCode;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public Long getAddressId()
	{
		return addressId;
	}

	public void setAddressId(Long addressId)
	{
		this.addressId = addressId;
	}

}
