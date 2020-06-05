package com.bootdemo.dao;

import com.bootdemo.domain.TrainType;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    String selectName(int trainId);

    List<TrainType> selectAllForInfo(@Param("start") int start, @Param("end") int end);

    List<Integer> selectTicketIsShellByTrainId(@Param("trainId") int trainId);


}
