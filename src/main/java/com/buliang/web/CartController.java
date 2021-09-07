package com.buliang.web;

import com.buliang.exc.AddToCartExc;
import com.buliang.service.CartService;
import com.buliang.service.ProductService;
import com.buliang.vo.ResultCode;
import com.buliang.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
            return res?ResultVo.mySuccess(ResultCode.ADD_CART_SUCCESS):ResultVo.fail(ResultCode.Fail);
        }
        catch (AddToCartExc e){
            return ResultVo.fail(ResultCode.ADD_CART_FAIL);
        }
    }

    @RequestMapping("/modifyCart")
    @ResponseBody
    public ResultVo modifyCart(Integer entityId,Integer quantity){
        try{
            return cartService.modifyCart(entityId,quantity)?ResultVo.mySuccess(ResultCode.ADD_CART_SUCCESS):ResultVo.fail(ResultCode.Fail);
        }
        catch (AddToCartExc e){
            return ResultVo.fail(ResultCode.ADD_CART_FAIL);
        }
    }



    @RequestMapping("/refreshCart")
    public String refresh(){
        return "/common/backend/searchBar";
    }

    @RequestMapping("/toSettlement")
    public String settlement(){
        return "/pre/settlement/toSettlement";
    }

    //@RequestMapping("settlement1")
    //public String settlement2(){
    //    return "/pre/settlement/settlement1" ;
    //}

    @RequestMapping("/settlement/{id}")
    public String settlement1(@PathVariable("id") Integer id){
        return "/pre/settlement/settlement" + id;
    }
}
