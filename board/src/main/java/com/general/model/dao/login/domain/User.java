package com.general.model.dao.login.domain;

import com.general.model.dao.login.enums.Role;
import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
@Entity(name = "Account")
public class User implements UserDetails {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Integer accountSeq;

	@Column (nullable = false)
	private String email;

	@Column (nullable = false)
	private String password;

	@Column
	private Role role;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "MemberSeq")
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
		List<GrantedAuthority> authorities = Lists.newArrayList();
		if ( role == null){
			role = Role.USER;
		}
		authorities.add(new SimpleGrantedAuthority(this.role.getValue()));
		return authorities;
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
