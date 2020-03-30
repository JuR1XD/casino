package com.packt.casino.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name = "user_authority")
public class RoleUser implements Serializable
{
	@Id
	@Column(name = "user_id")
	private Long userId;

	@Column(name = "authority_id")
	private Long authorityId;


	public Long getUserId()
	{
		return userId;
	}

	public void setUserId(Long userId)
	{
		this.userId = userId;
	}

	public Long getAuthorityId()
	{
		return authorityId;
	}

	public void setAuthorityId(Long authorityId)
	{
		this.authorityId = authorityId;
	}
}
