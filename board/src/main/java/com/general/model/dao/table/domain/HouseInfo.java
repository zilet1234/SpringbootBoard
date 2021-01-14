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
    private String address;                 // 주소

    @Column(nullable = false)
    private String place;                   // 면적

    @Column(nullable = false)
    private Integer price;                  // 매매가격

    @Column(nullable = false)
    private int room;                       // 방/욕실

    @Column(nullable = false)
    private int floor;                      // 층수

    @Column(nullable = false)
    private LocalDateTime writeDT;

    @Column(nullable = false)
    private LocalDateTime regDT;

    @Column(nullable = false)
    private boolean delYN;

}
