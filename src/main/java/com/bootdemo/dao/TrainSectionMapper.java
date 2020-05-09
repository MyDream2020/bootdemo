package com.bootdemo.dao;

import com.bootdemo.domain.TrainSection;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: ASUS
 * @Date: 2020/4/5 15:44
 * @Version: 1.0
 */

@Repository
public interface TrainSectionMapper {

    int insertTrainSection(TrainSection section);

    int insertTrainSectionByList(@Param("sectionList") List<TrainSection> sectionList);


    /**
     * @param startSection 出发站点
     * @param endSection 抵达站点
     * @param startTime 格式"XXXX-XX-XX" 个位数务必补充零
     * @return
     */
    List<TrainSection> selectTrainSectionByTimeAndPlace(@Param("startSection") String startSection,
                                                        @Param("endSection") String endSection, @Param("startTime") String startTime);
    TrainSection selectTrainSection(int sectionId);

}
