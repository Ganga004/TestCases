package org.example;

import org.example.order.bo.BOException;
import org.example.order.bo.OrderBOImpl;
import org.example.order.dao.Order;
import org.example.order.dao.OrderDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.SQLException;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class OrderBOImplTest {

    @Mock
    OrderDao orderDao;
    private OrderBOImpl orderBOImpl;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        orderBOImpl = new OrderBOImpl();
        orderBOImpl.setOrderDao(orderDao);
    }

    @Test
    public void placeOrderTest() throws SQLException, BOException {
        Order order = new Order();
        Mockito.when(orderDao.create(order)).thenReturn(0);
        boolean result = orderBOImpl.placeOrder(order);
        Assertions.assertFalse(result);
        verify(orderDao,times(1)).create(order);
    }

    @Test
    public void placeOrderShouldNotCreateOrderTest() throws SQLException, BOException {
        Order order = new Order();
        Mockito.when(orderDao.create(order)).thenReturn(0);
        boolean result = orderBOImpl.placeOrder(order);
        Assertions.assertFalse(result);
        verify(orderDao).create(order);
        }


    @Test(expected = BOException.class)
    public void placeOrderShouldThrowException() throws SQLException, BOException {
        Order order = new Order();
        Mockito.when(orderDao.create(order)).thenThrow(SQLException.class);
        boolean result = orderBOImpl.placeOrder(order);
    }

    @Test
    public void cancelOrderIsNotHappenedTest() throws SQLException, BOException {
        Order order = new Order();
        when(orderDao.read(anyInt())).thenReturn(order);
        when(orderDao.update(order)).thenReturn(0);
        orderBOImpl.cancelOrder(anyInt());
    }

    @Test
    public void cancelOrderIsHappenedTest() throws SQLException, BOException {
        Order order = new Order();
        when(orderDao.read(anyInt())).thenReturn(order);
        when(orderDao.update(order)).thenReturn(1);
        orderBOImpl.cancelOrder(anyInt());
        verify(orderDao).read(anyInt());
        verify(orderDao).update(order);
    }

    @Test(expected = BOException.class)
    public void cancelOrderThrowsExceptionTest() throws SQLException, BOException {
        Order order = new Order();
        when(orderDao.read(anyInt())).thenThrow(SQLException.class);
        when(orderDao.update(order)).thenThrow(SQLException.class);
        orderBOImpl.cancelOrder(anyInt());
    }

    @Test
    public void deleteOrderIsHappenedTest() throws SQLException, BOException {
        when(orderDao.delete(anyInt())).thenReturn(1);
        orderBOImpl.deleteOrder(anyInt());
    }

    @Test
    public void deleteOrderIsNotHappenedTest() throws SQLException, BOException {
        when(orderDao.delete(anyInt())).thenReturn(0);
        orderBOImpl.deleteOrder(anyInt());
    }

    @Test(expected = BOException.class)
    public void deleteOrderIsThrowingException() throws SQLException, BOException {
        when(orderDao.delete(anyInt())).thenThrow(SQLException.class);
        orderBOImpl.deleteOrder(anyInt());
    }
}
