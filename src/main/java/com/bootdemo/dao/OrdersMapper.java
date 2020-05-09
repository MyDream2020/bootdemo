package com.bootdemo.dao;

import com.bootdemo.domain.Orders;
import com.bootdemo.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: ASUS
 * @Date: 2020/4/6 22:23
 * @Version: 1.0
 */
@Repository
public interface OrdersMapper {

    Orders selectOrders(@Param("orderId") int orderId,@Param("cardId") String cardId);


    Integer selectTicketId(int orderId);

    User selectUser(int orderId);

    Integer selectSectionId(int orderId);

    int insertOrders(Orders orders);

    int insertOrdersByList(@Param("ordersList") List<Orders> ordersList);

    int updateOrdersForTicketAndSellByList(@Param("ordersList")List<Orders> ordersList);

}
