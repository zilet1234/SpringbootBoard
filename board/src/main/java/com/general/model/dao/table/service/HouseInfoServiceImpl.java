package com.general.model.dao.table.service;

import com.general.model.dao.table.domain.HouseInfo;
import com.general.model.dao.table.repository.HouseInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
public class HouseInfoServiceImpl implements HouseInfoService{

    @Autowired
    HouseInfoRepository houseInfoRepository;

    @Override
    public HouseInfo get(int houseInfoSeq) throws Exception {
        try {
            return houseInfoRepository.findOne(houseInfoSeq);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<HouseInfo> getAll()  throws Exception {
        try {
            return houseInfoRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public HouseInfo set(HouseInfo houseInfo) throws Exception {
        try {
            return houseInfoRepository.save(houseInfo);
        } catch (Exception e) {
            throw  new Exception(e.getMessage());
        }
    }

    @Override
    public boolean checkExist(HouseInfo houseInfo) throws Exception {
        try {
            HouseInfo isHouseInfo = houseInfoRepository.findByPlaceAndPriceAndAddress(houseInfo.getPlace().trim(), houseInfo.getPrice(), houseInfo.getAddress().trim());
            if ( isHouseInfo != null) {
                return true;
            }
        } catch ( Exception e){
            throw new Exception(e.getMessage());
        }
        return false;
    }

}
