package com.bootdo.system.controller;

import com.bootdo.common.utils.*;
import com.bootdo.system.domain.OrderDO;
import com.bootdo.system.domain.SmsDO;
import com.bootdo.system.service.OrderService;
import com.bootdo.system.service.SmsService;
import com.bootdo.system.vo.CardVo;
import io.swagger.models.auth.In;
import org.apache.commons.lang3.RandomUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

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

    @GetMapping()
    @RequiresPermissions("hongzha:card:card")
    String Card(){
        return "hongzha/card/card";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("hongzha:card:card")
    public PageUtils list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        List<OrderDO> smsList = orderService.list(query);
        int total = orderService.count(query);
        PageUtils pageUtils = new PageUtils(smsList, total);
        return pageUtils;
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
        int cardNum=cardVo.getCardNum();
        int invalidDays=cardVo.getInvalidDays();
        for(int i=0;i<=cardNum-1;i++){
            OrderDO orderDO=new OrderDO();
            orderDO.setOrderName(invalidDays+"天卡");
            orderDO.setCreateTime(new Date());
            orderDO.setInvalidDays(invalidDays);
            orderDO.setInvalidStatus("0");
            String randomStr= IDUtils.genIdStr("");
            orderDO.setOrderNo(MD5Utils.encrypt(randomStr));
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
}
