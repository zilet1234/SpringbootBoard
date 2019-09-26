package com.general.model.dao.login.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

/**
 * @author 곽우영
 * @since 2019-03-25
 */
@Data
@Entity
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer memberSeq;

	@Column
	private String uid;		// add

	@Column
	private String upw;		// add

	@Column
	private String name;

	@Column
	private Integer age;

	@Column
	private Integer sex;

	@Column
	private String address;

	@Column
	private Date regDt;

	@Column
	private boolean delYn;
}
