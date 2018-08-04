package com.bootdo.system.controller;

import com.bootdo.common.utils.*;
import com.bootdo.system.domain.OrderDO;
import com.bootdo.system.domain.ProductDO;
import com.bootdo.system.enums.InvalidDayType;
import com.bootdo.system.enums.InvalidStatus;
import com.bootdo.system.enums.RoleCodeEnum;
import com.bootdo.system.service.OrderService;
import com.bootdo.system.service.ProductService;
import com.bootdo.system.service.UserService;
import com.bootdo.system.vo.CardVo;
import com.bootdo.system.vo.OrderResultVo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @Author:luiz
 * @Date: 2018/7/30 19:06
 * @Descripton:
 * @Modify :
 **/
@Controller
@RequestMapping("/hongzha/card")
public class HongzhaCardController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;

    @GetMapping()
    @RequiresPermissions("hongzha:card:card")
    String Card(Model model){
        List<ProductDO> productDOS=productService.list(null);
        model.addAttribute("productDOS",productDOS);
        return "hongzha/card/card";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("hongzha:card:card")
    public PageUtils list(@RequestParam Map<String, Object> params){
        //查询列表数据
        putUser(params);
        Query query = new Query(params);
        List<OrderDO> smsList = orderService.list(query);
        List<OrderResultVo> orderResultVos=new ArrayList<>();
        for(OrderDO orderDO:smsList){
            OrderResultVo orderResultVo=new OrderResultVo();
            BeanUtils.copyProperties(orderDO,orderResultVo);
            orderResultVo.setInvalidStatusName(InvalidStatus.parse(orderDO.getInvalidStatus()).getName());
            orderResultVo.setInvalidTypeName(InvalidDayType.parse(orderDO.getInvalidType()).getName());
            orderResultVos.add(orderResultVo);
        }
        int total = orderService.count(query);
        PageUtils pageUtils = new PageUtils(orderResultVos, total);
        return pageUtils;
    }

    /**
     * 管理员可以查看所有
     * @param params
     */
    private void putUser(Map<String, Object> params) {
        params.put("ownerUserId",ShiroUtils.getUserId());
        long userId=ShiroUtils.getUserId();
        List<String> rolSet=userService.listRoles(userId);
        for(String roleCode:rolSet){
            if(RoleCodeEnum.ADMIN.getCode().equals(roleCode)) {
                params.remove("ownerUserId");
            }
        }
    }


    @GetMapping("/add/{orderNo}")
    @RequiresPermissions("hongzha:card:add")
    String add(@PathVariable("orderNo")String orderNo,Model model){
        model.addAttribute("orderNo", orderNo);
        return "hongzha/card/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("hongzha:card:edit")
    String edit(@PathVariable("id") Integer id,Model model){
        OrderDO orderDO = orderService.get(id);
        model.addAttribute("card", orderDO);
        return "hongzha/card/edit";
    }

    /**
     * 生成卡密
     */
    @ResponseBody
    @PostMapping("/genOrder")
    @RequiresPermissions("hongzha:card:genOrder")
    public R save(CardVo cardVo){
        String productNo=cardVo.getProductNo();
        String invalidDayType=productNo.split("_")[0];
        int invalidDays=Integer.valueOf(productNo.split("_")[1]);
        int cardNum=cardVo.getCardNum();
        ProductDO productDO=productService.findByNo(productNo);
        for(int i=0;i<=cardNum-1;i++){
            OrderDO orderDO=new OrderDO();
            orderDO.setOrderName(productDO.getProductName());
            orderDO.setInvalidType(invalidDayType);
            orderDO.setCreateTime(new Date());
            orderDO.setInvalidDays(invalidDays);
            orderDO.setInvalidStatus(InvalidStatus.VALID.getCode());
            String randomStr= IDUtils.genIdStr("");
            orderDO.setOrderNo(MD5Utils.encrypt(randomStr));
            orderDO.setOwnerUserId(ShiroUtils.getUserId());
            orderService.save(orderDO);
        }
        return R.ok();
    }
    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("hongzha:card:edit")
    public R update( OrderDO orderDO){
        orderService.update(orderDO);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping( "/remove")
    @ResponseBody
    @RequiresPermissions("hongzha:card:remove")
    public R remove( Integer id){
        if(orderService.remove(id)>0){
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping( "/batchRemove")
    @ResponseBody
    @RequiresPermissions("hongzha:card:batchRemove")
    public R remove(@RequestParam("ids[]") Integer[] ids){
        orderService.batchRemove(ids);
        return R.ok();
    }


    /**
     * 禁用
     */
    @PostMapping( "/batchDisable")
    @ResponseBody
    @RequiresPermissions("hongzha:card:batchDisable")
    public R batchDisable(@RequestParam("ids[]") Integer[] ids){
        orderService.batchDisable(ids);
        return R.ok();
    }
    /**
     * 启用
     */
    @PostMapping( "/batchEnable")
    @ResponseBody
    @RequiresPermissions("hongzha:card:batchEnable")
    public R batchEnable(@RequestParam("ids[]") Integer[] ids){
        orderService.batchEnable(ids);
        return R.ok();
    }




}
