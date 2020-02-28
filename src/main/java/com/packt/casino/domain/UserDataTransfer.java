package com.packt.casino.domain;

import com.packt.casino.validator.PasswordMatches;
import com.packt.casino.validator.ValidEmail;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@PasswordMatches
public class UserDataTransfer
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
	private double credit;
	
	@NotNull(message = "{casino.signIn.notNull}")
	private boolean admin;
	
	@NotNull(message = "{casino.signIn.notNull}")
	private boolean isActivated;

	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "{casino.signIn.password.validPassword}")
	@NotEmpty(message = "{casino.signIn.notNull}")
	private String password;
	@NotEmpty(message = "{casino.signIn.notNull}")
	private String matchingPassword;

	@NotEmpty
	private String oldPassword;
	
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

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getMatchingPassword()
	{
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword)
	{
		this.matchingPassword = matchingPassword;
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
