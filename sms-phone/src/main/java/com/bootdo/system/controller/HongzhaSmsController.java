package com.bootdo.system.controller;

import com.bootdo.common.utils.*;
import com.bootdo.system.domain.*;
import com.bootdo.system.enums.ExecStatus;
import com.bootdo.system.enums.InvalidDayType;
import com.bootdo.system.enums.InvalidStatus;
import com.bootdo.system.service.*;
import com.bootdo.system.vo.PhoneNumVo;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
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
@RequestMapping("/hongzha/sms")
public class HongzhaSmsController {

    @Autowired
    private SmsService smsService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserAccountService userAccountService;
    @Autowired
    private AccountLogService accountLogService;
    @Autowired
    private ProductService productService;

    @GetMapping()
    @RequiresPermissions("hongzha:sms:sms")
    String Sms(){
        return "hongzha/sms/sms";
    }


    /**
     * 启用卡密
     */
    @ResponseBody
    @RequestMapping("/valid")
    @RequiresPermissions("hongzha:sms:valid")
    public R valid( @RequestParam(value = "orderNo")String orderNo){

        OrderDO oldOrder=orderService.selectByOrderNo(orderNo);
        if(oldOrder==null || !oldOrder.getInvalidStatus().equals(InvalidStatus.VALID.getCode())
            ||  oldOrder.getUseTime()!=null
                ){
            return R.error("卡密无效");
        }
        //1.判断代理商余额是否充足
        UserAccountDO userAccountDO=userAccountService.selectByUserId(oldOrder.getOwnerUserId());
        if(userAccountDO==null || BigDecimal.ZERO.compareTo(userAccountDO.getAcctAmt())>=0){
            return R.error("余额不足，请联系销售人员充值。");
        }
        //2.扣减余额
       ProductDO productDO= productService.findPrice(oldOrder.getInvalidType(),oldOrder.getInvalidDays());
        BigDecimal productPrice=BigDecimal.TEN;//默认十元
        if(productDO!=null && productDO.getPrice()!=null){
            productPrice=productDO.getPrice();
        }

        if(productPrice.compareTo(userAccountDO.getAcctAmt())==1){
            BigDecimal subAmt=productPrice.subtract(userAccountDO.getAcctAmt());
            return R.error("余额不足以支持本次消费,还差"+subAmt+"元,请联系销售人员充值。");
        }

        BigDecimal operAmtBefore=userAccountDO.getAcctAmt();
        BigDecimal  operAmtAfter=operAmtBefore.subtract(productPrice);
        userAccountDO.setAcctAmt(operAmtAfter);
        userAccountDO.setModiTime(new Date());
        userAccountService.update(userAccountDO);

        //1.记录消费流水
        AccountLogDO accountLogDO=new AccountLogDO();
        accountLogDO.setUserId(oldOrder.getOwnerUserId());
        accountLogDO.setAcctId(userAccountDO.getId());
        accountLogDO.setOperAmt(productPrice);
        accountLogDO.setAmtDirect("-");
        accountLogDO.setAcctAmtB(operAmtBefore);//消费前金额
        accountLogDO.setAcctAmtA(operAmtAfter);//消费后金额
        accountLogDO.setOperMsg("消费金额"+productPrice);
        accountLogDO.setOperType("EXPEND");
        accountLogDO.setOperStatus(2);
        accountLogDO.setCreateTime(new Date());
        accountLogService.save(accountLogDO);

        //3.开始激活
        OrderDO orderDO=new OrderDO();
        orderDO.setOrderNo(orderNo);
        orderDO.setId(oldOrder.getId());
        orderDO.setUseTime(new Date());
        if(InvalidDayType.MIN.getCode().equals(oldOrder.getInvalidType())){
            orderDO.setUnvalidTime(DateUtils.addMinutes(new Date(),oldOrder.getInvalidDays()));
        }else  if(InvalidDayType.HOU.getCode().equals(oldOrder.getInvalidType())){
            orderDO.setUnvalidTime(DateUtils.addHours(new Date(),oldOrder.getInvalidDays()));
        }else  if(InvalidDayType.DAY.getCode().equals(oldOrder.getInvalidType())){
            orderDO.setUnvalidTime(DateUtils.addDays(new Date(),oldOrder.getInvalidDays()));
        }else  if(InvalidDayType.MON.getCode().equals(oldOrder.getInvalidType())){
            orderDO.setUnvalidTime(DateUtils.addMonths(new Date(),oldOrder.getInvalidDays()));
        }else  if(InvalidDayType.YEA.getCode().equals(oldOrder.getInvalidType())){
            orderDO.setUnvalidTime(DateUtils.addYears(new Date(),oldOrder.getInvalidDays()));
        }
        orderDO.setUseUserId(ShiroUtils.getUserId());
        orderService.update(orderDO);
        return R.ok();
    }


    @ResponseBody
    @GetMapping("/userCardList")
    @RequiresPermissions("hongzha:sms:userCardList")
    public PageUtils userList(@RequestParam Map<String, Object> params){
        //查询列表数据
        params.put("useUserId",ShiroUtils.getUserId());
        params.put("isValid","1");
        Query query = new Query(params);
        List<OrderDO> smsList = orderService.list(query);
        int total = orderService.count(query);
        PageUtils pageUtils = new PageUtils(smsList, total);
        return pageUtils;
    }


    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/addPhone")
    @RequiresPermissions("hongzha:sms:addPhone")
    public R addPhone(PhoneNumVo phoneNumVo){
        SmsDO smsDO=new SmsDO();
        smsDO.setOrderNo(phoneNumVo.getOrderNo());
        smsDO.setUserId(ShiroUtils.getUserId());
        try{
            int countNum=smsService.countByOrderNo(smsDO);
            if(countNum>=6){
                return R.error("最多只能添加六个手机号");
            }
            if(StringUtils.isNotEmpty(phoneNumVo.getPhoneNum1())){
                smsDO.setPhoneNum(phoneNumVo.getPhoneNum1());
                smsService.addPhone(smsDO);
            }
            if(StringUtils.isNotEmpty(phoneNumVo.getPhoneNum2())){
                smsDO.setPhoneNum(phoneNumVo.getPhoneNum2());
                smsService.addPhone(smsDO);
            }
            if(StringUtils.isNotEmpty(phoneNumVo.getPhoneNum3())){
                smsDO.setPhoneNum(phoneNumVo.getPhoneNum3());
                smsService.addPhone(smsDO);
            }
            if(StringUtils.isNotEmpty(phoneNumVo.getPhoneNum4())){
                smsDO.setPhoneNum(phoneNumVo.getPhoneNum4());
                smsService.addPhone(smsDO);
            }
            if(StringUtils.isNotEmpty(phoneNumVo.getPhoneNum5())){
                smsDO.setPhoneNum(phoneNumVo.getPhoneNum5());
                smsService.addPhone(smsDO);
            }
            if(StringUtils.isNotEmpty(phoneNumVo.getPhoneNum6())){
                smsDO.setPhoneNum(phoneNumVo.getPhoneNum6());
                smsService.addPhone(smsDO);
            }
        }catch (Exception e){
            return R.error();
        }

        return R.ok();
    }



    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("hongzha:sms:sms")
    public PageUtils list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        List<SmsDO> smsList = smsService.list(query);
        int total = smsService.count(query);
        PageUtils pageUtils = new PageUtils(smsList, total);
        return pageUtils;
    }

    @GetMapping("/add/{orderNo}")
    @RequiresPermissions("hongzha:sms:add")
    String add(@PathVariable("orderNo")String orderNo,Model model){
        model.addAttribute("orderNo", orderNo);
        List<SmsDO> smsDOList= smsService.selectByOrderNo(orderNo);
        PhoneNumVo phoneNumVo=new PhoneNumVo();
        for(int i=0;i<=smsDOList.size()-1;i++){
            SmsDO smsDO=smsDOList.get(i);
            if(i==0){
                phoneNumVo.setPhoneNum1(smsDO.getPhoneNum());
            }else if(i==1){
                phoneNumVo.setPhoneNum2(smsDO.getPhoneNum());
            }else if(i==2){
                phoneNumVo.setPhoneNum3(smsDO.getPhoneNum());
            }else if(i==3){
                phoneNumVo.setPhoneNum4(smsDO.getPhoneNum());
            }else if(i==4){
                phoneNumVo.setPhoneNum5(smsDO.getPhoneNum());
            }else if(i==5){
                phoneNumVo.setPhoneNum6(smsDO.getPhoneNum());
            }else{
                break;
            }
        }
        model.addAttribute("phoneNumVo", phoneNumVo);
        return "hongzha/sms/add";
    }


    @GetMapping("/edit/{id}")
    @RequiresPermissions("hongzha:sms:edit")
    String edit(@PathVariable("id") Long id,Model model){
        SmsDO sms = smsService.get(id);
        model.addAttribute("sms", sms);
        return "hongzha/sms/edit";
    }


    /**
     * 修改状态
     */
    @ResponseBody
    @RequestMapping("/modiStatus/{smsId}")
    @RequiresPermissions("hongzha:sms:modiStatus")
    public R modiStatus(@PathVariable("smsId") long smsId){
        SmsDO sms=new SmsDO();
        sms.setId(smsId);
        SmsDO smsDO=smsService.get(smsId);
        if(ExecStatus.PROCESS.getCode()==smsDO.getExecStatus()){
            sms.setExecStatus(ExecStatus.STOP.getCode());
        }else{
            sms.setExecStatus(ExecStatus.PROCESS.getCode());
        }
        smsService.update(sms);
        return R.ok();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("hongzha:sms:edit")
    public R update( SmsDO sms){
        smsService.update(sms);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping( "/remove")
    @ResponseBody
    @RequiresPermissions("hongzha:sms:remove")
    public R remove( Long id){
        if(smsService.remove(id)>0){
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping( "/batchRemove")
    @ResponseBody
    @RequiresPermissions("hongzha:sms:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids){
        smsService.batchRemove(ids);
        return R.ok();
    }
}
