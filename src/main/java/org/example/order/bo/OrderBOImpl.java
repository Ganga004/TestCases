package org.example.order.bo;

import org.example.order.dao.Order;
import org.example.order.dao.OrderDao;

import java.sql.SQLException;

public class OrderBOImpl implements OrderBo {
    private OrderDao orderDao;

    public OrderDao getOrderDao() {
        return orderDao;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }


    @Override
    public boolean placeOrder(Order order) throws BOException {
        try {
            int result = orderDao.create(order);
            if(result==0) {
               return false;
            }
        } catch (SQLException e) {
            throw new BOException(e);
        }
        return true;
    }

    @Override
    public boolean cancelOrder(int id) throws BOException {
        try {
            Order order = orderDao.read(id);
            order.setStatus("cancelled");
            int result = orderDao.update(order);
            if(result==0) {
                return false;
            }
        } catch (SQLException e) {
            throw new BOException(e);
        }
        return true;
    }

    @Override
    public boolean deleteOrder(int id) throws BOException {
        try {
            int result = orderDao.delete(id);
            if (result==0) {
                return false;
            }
        } catch (SQLException e) {
            throw new BOException(e);
        }
        return true;
    }
}
