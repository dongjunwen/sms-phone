package com.bootdo.system.controller;

import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.system.domain.SmsDO;
import com.bootdo.system.service.SmsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping()
    @RequiresPermissions("hongzha:sms:sms")
    String Sms(){
        return "hongzha/sms/sms";
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

    @GetMapping("/add")
    @RequiresPermissions("hongzha:sms:add")
    String add(){
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
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("hongzha:sms:add")
    public R save(SmsDO sms){
        if(smsService.save(sms)>0){
            return R.ok();
        }
        return R.error();
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
