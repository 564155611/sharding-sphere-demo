package com.fanx.shardingspheredemo;

import com.fanx.shardingspheredemo.entity.Order;
import com.fanx.shardingspheredemo.entity.OrderItem;
import com.fanx.shardingspheredemo.mapper.OrderItemMapper;
import com.fanx.shardingspheredemo.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
@MapperScan(basePackages = {"com.fanx.shardingspheredemo.mapper"})
@Slf4j
public class ShardingSphereDemoApplicationTests {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrderItemMapper orderItemMapper;

    @Test
    public void clear() {
        orderMapper.deleteByPrimaryKey(1);
        orderMapper.deleteByPrimaryKey(2);
        orderMapper.deleteByPrimaryKey(3);

        orderItemMapper.deleteByPrimaryKey(1);
        orderItemMapper.deleteByPrimaryKey(2);
        orderItemMapper.deleteByPrimaryKey(3);
    }

    @Test
    public void testOrderInsert() {
        Order order1 = new Order();
        order1.setOrderId(1);
        order1.setUserId(1);
        order1.setTotalAmount(new BigDecimal("100.0"));
        orderMapper.insert(order1);

        Order order2 = new Order();
        order2.setOrderId(2);
        order2.setUserId(2);
        order2.setTotalAmount(new BigDecimal("200.0"));
        orderMapper.insert(order2);

        Order order3 = new Order();
        order3.setOrderId(3);
        order3.setUserId(3);
        order3.setTotalAmount(new BigDecimal("300.0"));
        orderMapper.insert(order3);
    }

    @Test
    public void testOrderItemInsert() {
        OrderItem orderItem1 = new OrderItem();
        orderItem1.setId(1);
        orderItem1.setOrderId(1);
        orderItem1.setUserId(1);
        orderItem1.setProductId(1);
        orderItem1.setProductNum(1);
        orderItem1.setSoldPrice(new BigDecimal("100.0"));
        orderItemMapper.insert(orderItem1);

        OrderItem orderItem2 = new OrderItem();
        orderItem2.setId(2);
        orderItem2.setOrderId(2);
        orderItem2.setUserId(2);
        orderItem2.setProductId(2);
        orderItem2.setProductNum(1);
        orderItem2.setSoldPrice(new BigDecimal("200.0"));
        orderItemMapper.insert(orderItem2);

        OrderItem orderItem3 = new OrderItem();
        orderItem3.setId(3);
        orderItem3.setOrderId(3);
        orderItem3.setUserId(3);
        orderItem3.setProductId(3);
        orderItem3.setProductNum(1);
        orderItem3.setSoldPrice(new BigDecimal("300.0"));
        orderItemMapper.insert(orderItem3);

    }

    @Test
    public void testSelectJoin() {
        List<Map<String, Object>> mapList = orderItemMapper.selectOrderJoinItemsByOrderId(1);
        log.info("mapList.size()==>{}",mapList.size());
        mapList.forEach(map -> {
            log.info("=================================");
            map.forEach((k, v) -> {
                log.info("键{}={}值", k, v);
            });
        });
    }


}
