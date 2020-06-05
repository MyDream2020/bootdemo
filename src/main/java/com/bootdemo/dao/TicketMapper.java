package com.bootdemo.dao;

import com.bootdemo.domain.Ticket;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: ASUS
 * @Date: 2020/4/6 22:23
 * @Version: 1.0
 */
@Repository
public interface TicketMapper {

    Ticket selectTicket(int ticketId);

    Integer selectTypeId(int ticketId);

    Byte selectIsSell(int ticketId);

    int insertTicket(Ticket ticket);

    Ticket selectNotSellTicketIdByTicketTypeId(@Param("ticketTypeId") int ticketTypeId);

    int insertTicketByList(@Param("ticketList") List<Ticket> ticketList);

    int updateTicketForIsSellByList(@Param("ticketList") List<Ticket> ticketList, @Param("isSell") byte isSell);


    int updateTicketChangeIsShell(@Param("ticketId")int ticketId, @Param("isSell") byte isSell);

}
