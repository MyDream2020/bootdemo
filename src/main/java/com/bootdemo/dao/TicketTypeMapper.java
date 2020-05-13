package com.bootdemo.dao;

import com.bootdemo.domain.TicketType;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: ASUS
 * @Date: 2020/4/6 21:50
 * @Version: 1.0
 */

@Repository
public interface TicketTypeMapper {

    TicketType selectTicketType(int typeId);

    int insertTicketType(TicketType TicketType);

    Integer selectSectionId(int typeId);

    BigDecimal selectPrice(int typeId);

    int selectSeatNumber(int typeId);

    List<Integer> selectTypeIdListBySectionId(@Param("sectionId") int sectionId);

    int insertTrainTicketTypeByList(@Param("ticketTypeList") List<TicketType> ticketTypeList);

    int updateTypeForDecrByList (@Param("typeIdList") List<Integer> typeIdList);

    String selectSeatGrade(int typeId);
}
