package com.general.model.dao.table.service;

import com.general.model.dao.table.domain.HouseInfo;

import java.util.List;

public interface HouseInfoService {

    HouseInfo get(int houseInfoSeq) throws Exception;

    List<HouseInfo> getAll() throws Exception;

    HouseInfo set(HouseInfo houseInfo) throws Exception;

    boolean checkExist(HouseInfo houseInfo) throws Exception;

}
