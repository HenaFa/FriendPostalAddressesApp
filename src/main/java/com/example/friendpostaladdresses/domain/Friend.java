package com.example.friendpostaladdresses.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Friend {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstname;
	private String lastname;
	private String address;

	public Friend() {

	}

	public Friend(Long id, String firstname, String lastname, String address) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Friend [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", address=" + address + "]";
	}

}
