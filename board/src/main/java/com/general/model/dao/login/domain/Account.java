package com.general.model.dao.login.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

/**
 * @author 곽우영
 * @since 2019-03-30
 */

@Getter
@Setter
@ToString
@Entity
public class Account implements UserDetails {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Integer accountSeq;

	@Column (nullable = false)
	private String email;

	@Column (nullable = false)
	private String password;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "roleSeq")
	private List<Role> roleList;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "memberSeq")
	private Member member;

	@Transient
	private boolean accountNonExpired = true;

	@Transient
	private boolean accountNonLocked = true;

	@Transient
	private boolean credentialsNonExpired = true;

	@Transient
	private boolean enabled = true;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.roleList;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return this.accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return this.credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return this.enabled;
	}
}
