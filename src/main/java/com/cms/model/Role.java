package com.cms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import com.cms.Roles;

@Getter @Setter
@Entity
@Table(name = "role")
public class Role extends BaseEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(name="role")
	private Roles role;

}
