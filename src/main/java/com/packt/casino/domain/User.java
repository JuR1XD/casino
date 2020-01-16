package com.packt.casino.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userid;

	private String name;

	private String surname;

	private String email;

	private String birthday;

	private String street;

	private String streetnr;

	private String postalcode;

	private String city;

	private double credit;

	private boolean admin;

	private boolean isactivated;

	@Override
	public String toString() {
		return String.format(
				"User[idUser=%d, name='%s', surname='%s', email='%s', birthday='%s', street='%s', streetNr='%s', postalCode='%s', city='%s', credit='%s', admin='%s', isActivated='%s']",
				userid, name, surname, email, birthday, street, streetnr, postalcode, city, credit, admin, isactivated);
	}

	public Long getUserid()
	{
		return userid;
	}

	public void setUserid(Long idUser)
	{
		this.userid = idUser;
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

	public String getStreet()
	{
		return street;
	}

	public void setStreet(String street)
	{
		this.street = street;
	}

	public String getStreetnr()
	{
		return streetnr;
	}

	public void setStreetnr(String streetNr)
	{
		this.streetnr = streetNr;
	}

	public String getPostalcode()
	{
		return postalcode;
	}

	public void setPostalcode(String postalCode)
	{
		this.postalcode = postalCode;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
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

	public boolean isIsactivated()
	{
		return isactivated;
	}

	public void setIsactivated(boolean isactivated)
	{
		this.isactivated = isactivated;
	}
}
