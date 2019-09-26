package com.general.model.dao.table.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class HouseInfo {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer houseInfoSeq;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private int room;

    @Column(nullable = false)
    private int bathroom;

    @Column(nullable = false)
    private int floor;

    @Column(nullable = false)
    private LocalDateTime writeDT;

    @Column(nullable = false)
    private LocalDateTime regDT;

    @Column(nullable = false)
    private boolean delYN;

}
