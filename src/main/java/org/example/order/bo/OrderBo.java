package org.example.order.bo;

import org.example.order.dao.Order;

public interface OrderBo {
    boolean placeOrder(Order order) throws BOException;

    boolean cancelOrder(int id) throws BOException;

    boolean deleteOrder(int id) throws BOException;
}
