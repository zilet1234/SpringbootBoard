package com.general.model.dao.login.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * @author 곽우영
 * @since 2019-03-30
 */

@Data
@Entity
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer roleSeq;

    @Column(nullable = false)
    private String name;

    @Override
    public String getAuthority() {
        return this.name;
    }

}
