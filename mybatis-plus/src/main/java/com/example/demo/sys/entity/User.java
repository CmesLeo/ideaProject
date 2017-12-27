package com.example.demo.sys.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import org.springframework.data.annotation.Transient;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author AntMa
 * @since 2017-12-27
 */
@TableName("sys_user")
public class User extends Model<User> implements UserDetails {

    private static final long serialVersionUID = 1L;

	private Integer id;
	private String username;
	private String password;
	@Transient
	private Collection<? extends GrantedAuthority> authorities;

	public User(String username, String password, List<GrantedAuthority> grantedAuthorities) {
		super();
    	this.username = username;
    	this.password = password;
    	this.authorities=grantedAuthorities;

    }

    public User(){

	}


    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "User{" +
			", id=" + id +
			", username=" + username +
			", password=" + password +
			"}";
	}
}
