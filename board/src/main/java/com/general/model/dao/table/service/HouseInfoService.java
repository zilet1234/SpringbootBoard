package com.general.model.dao.table.service;

import com.general.model.dao.table.domain.HouseInfo;

import java.util.List;

public interface HouseInfoService {

    HouseInfo get(int houseInfoSeq);

    List<HouseInfo> getAll();

}
