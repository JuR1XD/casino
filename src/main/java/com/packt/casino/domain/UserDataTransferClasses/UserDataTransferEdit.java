package com.packt.casino.domain.UserDataTransferClasses;

import com.packt.casino.validator.ValidEmail;

import javax.validation.constraints.*;


public class UserDataTransferEdit
{

	@NotEmpty(message = "{casino.signIn.notNull}")
	private String name;

	@NotEmpty(message = "{casino.signIn.notNull}")
	private String surname;
	@ValidEmail
	private String email;

	@Pattern(regexp = "^\\d{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$", message = "{casino.signIn.birthday.error}")
	private String birthday;
	
	@NotNull(message = "{casino.signIn.notNull}")
	//@NotEmpty(message = "{casino.signIn.notNull}")
	@Min(value = 0, message = "{casino.edit.min}")
	//@Pattern(regexp = "[0-100]", message = "You can only deposit 100 Credits at a time")
	private double credit;
	
	@NotNull(message = "{casino.signIn.notNull}")
	private boolean admin;

	@NotNull(message = "{casino.signIn.notNull}")
	private boolean isActivated;

	@NotNull(message = "{casino.signIn.notNull}")
	@NotEmpty(message = "{casino.signIn.notNull}")
	private String street;

	@NotEmpty(message = "{casino.signIn.notNull}")
	private String streetNr;

	@NotEmpty(message = "{casino.signIn.notNull}")
	private String postalCode;

	@NotEmpty(message = "{casino.signIn.notNull}")
	private String city;


	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getSurname()
	{
		return surname;
	}

	public void setSurname(String surname)
	{
		this.surname = surname;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
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

	public boolean isActivated()
	{
		return isActivated;
	}

	public void setActivated(boolean activated)
	{
		isActivated = activated;
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
}
