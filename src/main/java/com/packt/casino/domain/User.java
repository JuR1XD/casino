package com.packt.casino.domain;

import com.packt.casino.validator.PasswordMatches;
import com.packt.casino.validator.ValidEmail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
@SecondaryTable(name = "address")
public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(table = "user", name = "userId")
	private Long userId;
	@NotEmpty(message = "{casino.signIn.notNull}")
	@NotNull(message = "{casino.signIn.notNull}")
	@Column(table = "user")
	private String name;
	@NotNull(message = "{casino.signIn.notNull}")
	@Column(table = "user")
	private String surname;
	@NotNull(message = "{casino.signIn.notNull}")
	@ValidEmail
	@Column(table = "user", name = "email")
	private String email;
	@NotNull(message = "{casino.signIn.notNull}")
	@Column(table = "user")
	private String birthday;
	@NotNull(message = "{casino.signIn.notNull}")
	@Column(table = "user")
	private double credit;
	@NotNull(message = "{casino.signIn.notNull}")
	@Column(table = "user")
	private boolean isActivated;
	@Column(table = "address")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long addressId;
	@NotNull(message = "{casino.signIn.notNull}")
	@Column(table = "user", name = "password")
	private String password;
	@NotNull(message = "{casino.signIn.notNull}")
	@Column(table = "address")
	private String street;
	@NotNull(message = "{casino.signIn.notNull}")
	@Column(table = "address")
	private String streetNr;
	@NotNull(message = "{casino.signIn.notNull}")
	@Column(table = "address")
	private String postalCode;
	@NotNull(message = "{casino.signIn.notNull}")
	@Column(table = "address")
	private String city;



	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "user_authority", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "authority_id"))
	private Set<Authority> authorities;

	@Override
	public String toString() {
		return String.format(
				"Name='%s'\nsurname='%s'\nemail='%s'\nbirthday='%s'\nstreet='%s'\nstreetNr='%s'\npostalCode='%s'\ncity='%s'",
				name, surname, email, birthday, street, streetNr, postalCode, city);
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

	public boolean isActivated()
	{
		return isActivated;
	}

	public void setActivated(boolean activated)
	{
		isActivated = activated;
	}

	public Set<Authority> getAuthorities()
	{
		return authorities;
	}

	public void setAuthorities(Set<Authority> authorities)
	{
		this.authorities = authorities;
	}
}
