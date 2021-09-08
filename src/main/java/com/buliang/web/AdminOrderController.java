package com.buliang.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/order")
public class AdminOrderController {
    @RequestMapping("/queryAllOrder")
    public String queryAllOrder(){
        return null;
    }

    //@RequestMapping()


}
