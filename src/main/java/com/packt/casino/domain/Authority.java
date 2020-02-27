package com.packt.casino.domain;

import javax.persistence.*;


@Entity
@Table(name = "Authority")
public class Authority
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "authorityId")
	private Long id;
	@Column(name = "name")
	private String name;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}