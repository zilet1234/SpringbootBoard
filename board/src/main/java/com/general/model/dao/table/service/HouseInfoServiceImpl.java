package com.general.model.dao.table.service;

import com.general.model.dao.table.domain.HouseInfo;
import com.general.model.dao.table.repository.HouseInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class HouseInfoServiceImpl implements HouseInfoService{

    @Autowired
    HouseInfoRepository houseInfoRepository;

    @Override
    public HouseInfo get(int houseInfoSeq) {
        return houseInfoRepository.findOne(houseInfoSeq);
    }

    @Override
    public List<HouseInfo> getAll() {
        return houseInfoRepository.findAll();
    }

}
