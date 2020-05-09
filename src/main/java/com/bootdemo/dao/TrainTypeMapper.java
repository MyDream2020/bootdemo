package com.bootdemo.dao;

import com.bootdemo.domain.TrainType;
import org.springframework.stereotype.Repository;

/**
 * @Author: ASUS
 * @Date: 2020/4/5 14:07
 * @Version: 1.0
 */
@Repository
public interface TrainTypeMapper {

    int insertTrainType(TrainType trainType);

    TrainType selectTrainType(int trainId);

    String selectTrainWay(int trainId);


}
