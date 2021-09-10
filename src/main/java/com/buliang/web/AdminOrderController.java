package com.buliang.web;

import com.buliang.bo.NewsBo;
import com.buliang.bo.OrderBo;
import com.buliang.pojo.News;
import com.buliang.pojo.Order;
import com.buliang.service.AdminOrderService;
import com.buliang.util.Pages;
import com.buliang.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin/order")
public class AdminOrderController {

    @Autowired
    AdminOrderService adminOrderService;

    @RequestMapping("/index")
    public String queryUserOrder(@RequestParam(defaultValue = "1") Integer pageIndex, Integer userId, Model model){

        OrderBo orderBo = new OrderBo();
        orderBo.setUserId(userId);
        orderBo.setPage(true);
        orderBo.setPageIndex(pageIndex);
        orderBo.setPageSize(5);
        orderBo.setStartIndex(orderBo.getStartIndex());



        Pages<Order> orderPages = adminOrderService.queryOrderPagesByUid(orderBo);
        if (userId != null) {
            orderPages.setUrl("admin/order/index?time=" + System.currentTimeMillis() + "&userId=" + userId);
        } else {
            orderPages.setUrl("admin/order/index?time=" + System.currentTimeMillis());
        }
        model.addAttribute("pager",orderPages);
        return "/backend/order/orderList";
    }

}
