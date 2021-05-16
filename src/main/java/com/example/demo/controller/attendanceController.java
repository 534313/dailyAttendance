package com.example.demo.controller;

import com.example.demo.Result;
import com.example.demo.entity.attendance;
import com.example.demo.service.attendanceService;
import com.example.demo.service.planService;
import com.mysql.cj.protocol.x.ReusableInputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/attendance")
public class attendanceController {
    @Autowired
    attendanceService attendanceService;
    @Autowired
    planService planService;

    /**
     * 获取打开天数
     * @return
     */
    @RequestMapping(value = "/getNum",produces = "application/json;charset=UTF-8")
    public Result getNum(){
        HashMap<String,Object> data=new HashMap<>();
        data.put("num",attendanceService.getNum());
        return new Result(data,"yes",200);
    }

    /**
     * 开始今日打卡
     * @param a 初始打卡记录（完成率为0，日期为今天）
     * @return
     */
    @RequestMapping(value = "/beginAttendance",method = RequestMethod.POST,produces = "application/json;charset=UTF-8" )
    public Result beginAttendance(@RequestBody attendance a){
        attendanceService.insertAttendance(a);
        planService.changePlan();    //将今日计划表清空，后复制明日计划表
        HashMap<String,Object> data=new HashMap<>();
        return new Result(data,"yes",200);
    }

    /**
     * 判断今天是否开始打卡
     * @return
     */
    @RequestMapping(value = "/judgeAttendance",method = RequestMethod.GET,produces = "application/json;charset=UTF-8" )
    public Result judgeAttendance(){
        HashMap<String,Object> data=new HashMap<>();
        data.put("judge",attendanceService.judgeAttendance());
        return new Result(data,"yes",200);
    }

    /**
     * 获取全部打卡记录
     * @return
     */
    @RequestMapping(value = "/getAllAttendances",method = RequestMethod.GET,produces = "application/json;charset=UTF-8" )
    public Result getAllAttendances(){
        HashMap<String,Object> data=new HashMap<>();
        data.put("attendances",attendanceService.getAllAttendances());
        return new Result(data,"yes",200);
    }

}
