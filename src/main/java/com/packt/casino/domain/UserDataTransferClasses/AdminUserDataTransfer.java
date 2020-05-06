package com.packt.casino.domain.UserDataTransferClasses;

import com.packt.casino.validator.ValidEmail;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


public class AdminUserDataTransfer
{
	@NotNull(message = "{casino.signIn.notNull}")
	private String name;

	@NotNull(message = "{casino.signIn.notNull}")
	private String surname;

	@NotNull(message = "{casino.signIn.notNull}")
	@ValidEmail
	private String email;

	@Pattern(regexp = "^\\d{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$", message = "{casino.signIn.birthday.error}")
	private String birthday;

	@NotNull(message = "{casino.signIn.notNull}")
	private double credit;

	@NotNull(message = "{casino.signIn.notNull}")
	private boolean admin;

	@NotNull(message = "{casino.signIn.notNull}")
	private boolean isActivated;

	private String password;

	@NotNull(message = "{casino.signIn.notNull}")
	@NotNull(message = "{casino.signIn.notNull}")
	private String street;

	@NotNull(message = "{casino.signIn.notNull}")
	private String streetNr;

	@NotNull(message = "{casino.signIn.notNull}")
	private String postalCode;

	@NotNull(message = "{casino.signIn.notNull}")
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
}
