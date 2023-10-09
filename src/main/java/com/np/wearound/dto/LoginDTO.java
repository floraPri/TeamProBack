package com.np.wearound.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_tbl")
public class LoginDTO {
	
	private String email;
	private String password;
	private int phone;
	private String name;
	private String key;
	private String authority;
	private String enabled;
	
	public LoginDTO() {
		super();
	}

	public LoginDTO(String email, String password, int phone, String name, String key, String authority,
			String enabled) {
		super();
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.name = name;
		this.key = key;
		this.authority = authority;
		this.enabled = enabled;
	}

	@Id
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	
	

}
