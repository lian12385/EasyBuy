package com.buliang.web;

import com.buliang.exc.AddToCartExc;
import com.buliang.service.CartService;
import com.buliang.service.ProductService;
import com.buliang.vo.ResultCode;
import com.buliang.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/Cart")
public class CartController {

    @Autowired
    ProductService productService;

    @Autowired
    CartService cartService;

    @RequestMapping("/add")
    @ResponseBody
    public ResultVo addToCart(Integer entityId, Integer quantity){
        try {
            boolean res =cartService.addToCart(entityId, quantity);
            return res?ResultVo.success():ResultVo.fail(ResultCode.Fail);
        }
        catch (AddToCartExc e){
            return ResultVo.fail(ResultCode.ADD_CART_FAIL);
        }

    }


    //public Re
}
