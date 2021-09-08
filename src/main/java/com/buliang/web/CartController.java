package com.buliang.web;

import com.buliang.exc.AddToCartExc;
import com.buliang.pojo.Order;
import com.buliang.pojo.User;
import com.buliang.pojo.UserAddress;
import com.buliang.service.AdminOrderService;
import com.buliang.service.CartService;
import com.buliang.service.ProductService;
import com.buliang.service.UserAddressService;
import com.buliang.util.Cart;
import com.buliang.util.SessionUtil;
import com.buliang.vo.CurrentOrderVo;
import com.buliang.vo.ResultCode;
import com.buliang.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/Cart")
public class CartController {

    @Autowired
    ProductService productService;

    @Autowired
    CartService cartService;

    @Autowired
    UserAddressService userAddressService;

    @Autowired
    AdminOrderService adminOrderService;

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

    @RequestMapping("/modCart")
    @ResponseBody
    public ResultVo modCart(Integer entityId){
        cartService.modCart(entityId);
        return ResultVo.mySuccess(ResultCode.ADD_CART_SUCCESS);
    }



    @RequestMapping("/refreshCart")
    public String refresh(){
        return "/common/backend/searchBar";
    }

    @RequestMapping("/toSettlement")
    public String settlement(){
        return "/pre/settlement/toSettlement";
    }

    @RequestMapping("settlement1")
    public String settlement2(){
        return "/pre/settlement/settlement1" ;
    }

    //@RequestMapping("/settlement/{id}")
    //public String settlement1(@PathVariable("id") Integer id){
    //    return "/pre/settlement/settlement" + id;
    //}

    @RequestMapping("/settlement2")
    public String settlement2(Model model){
        //User user = SessionUtil.getCurrentUser();
        List<UserAddress> userAddressList = null;
        try {
            userAddressList = userAddressService.queryByUserId();
        } catch (AddToCartExc addToCartExc) {
            //addToCartExc.printStackTrace();
            return "redirect:/User/page/login";
        }
        model.addAttribute("userAddressList",userAddressList);
        return "/pre/settlement/settlement2";
    }

    @RequestMapping("/settlement3")
    public String settlement3(
            Integer addressId,
            String newAddress,
            String newRemark,
            Model model){

        User user = SessionUtil.getCurrentUser();
        Cart cart = SessionUtil.getCurrentCart();

        adminOrderService.createUserAddress(addressId,newAddress,newRemark);
        Order order = adminOrderService.createOrder(user,newAddress,cart.getSum());
        adminOrderService.createOrderDetail(cart,order.getId());

        CurrentOrderVo currentOrderVo = new CurrentOrderVo();
        currentOrderVo.setCost(cart.getSum());
        currentOrderVo.setUserAddress(newAddress);
        currentOrderVo.setSerialNumber(order.getSerialNumber());

        //返回信息,
        model.addAttribute("currentOrder",currentOrderVo);
        return "/pre/settlement/settlement3";
    }

}
