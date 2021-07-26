package cn.edu.guet;

import cn.edu.guet.bean.Water;
import cn.edu.guet.bean.WaterOrder;
import cn.edu.guet.mapper.MessageMapper;
import cn.edu.guet.mapper.WaterMapper;
import cn.edu.guet.mapper.WaterOrderMapper;
import cn.edu.guet.service.IWaterOrderService;
import cn.edu.guet.service.IWaterService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.List;

@SpringBootTest
public class DormitorySystemApplicationTests {

    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    private WaterMapper waterMapper;

    @Autowired
    private IWaterService waterSeverce;

    @Autowired
    private IWaterOrderService waterOrderService;

    @Autowired
    private WaterOrderMapper waterOrderMapper;

    @Test
    public void testSendMessage(){
        System.out.println(new Timestamp(System.currentTimeMillis()));
    }

    @Test
    public void testGetWaterState(){
        System.out.println(waterSeverce.getAllWaterState(1, 3));
    }

    @Test
    public void testGetLimitWaterState(){
        WaterOrder waterOrder = new WaterOrder();
        waterOrder.setUsername("蓝振洪");
        waterOrder.setBuildingId("26");
        waterOrder.setRoomId("305");
        waterOrder.setNumber(2);
        waterOrder.setAmount(15);
        waterOrder.setOrderTime(new Timestamp(System.currentTimeMillis()));
        waterOrderService.insertWaterOrder(waterOrder);
    }

    @Test
    public void testGetWaterOrder(){
//        List<WaterOrder> waterOrders = null;
//        for(WaterOrder waterOrder : waterOrders){
//            System.out.println(waterOrder.toString());
//        }
//        System.out.println("--------------------------------------------");
//        waterOrders = waterOrderService.getWaterOrderByBuilding("26");
//        for(WaterOrder waterOrder : waterOrders){
//            System.out.println(waterOrder.toString());
//        }
//        System.out.println("--------------------------------------------");
//        waterOrders = waterOrderService.getWaterOrderByRoom("29", "309");
//        for(WaterOrder waterOrder : waterOrders){
//            System.out.println(waterOrder.toString());
//        }
//        System.out.println("--------------------------------------------");
//        waterOrders = waterOrderService.getWaterOrderByUser("test2");
//        for(WaterOrder waterOrder : waterOrders){
//            System.out.println(waterOrder.toString());
//        }
       /* System.out.println("tttttttt"+ PageHelper.startPage(3, 7));
        List<WaterOrder> waterOrders = waterOrderService.getAllWaterOrder(3,7);
        for(WaterOrder waterOrder :waterOrders){
            System.out.println(waterOrder.toString());
        }*/
        PageHelper.startPage(1,5);
        List<WaterOrder> waterOrders = waterOrderMapper.getTest();
        PageInfo pageInfo = new PageInfo(waterOrders);
        System.out.println(pageInfo.toString());

    }

}
