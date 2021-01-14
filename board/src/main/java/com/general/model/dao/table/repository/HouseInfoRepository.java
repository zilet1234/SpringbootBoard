package com.general.model.dao.table.repository;

import com.general.model.dao.table.domain.HouseInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseInfoRepository extends JpaRepository<HouseInfo, Integer> {

    HouseInfo findByPlaceAndPriceAndAddress(String place, Integer price, String address);

}
