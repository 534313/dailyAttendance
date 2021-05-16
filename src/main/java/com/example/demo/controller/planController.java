package com.example.demo.controller;

import com.example.demo.Result;
import com.example.demo.entity.plan;
import com.example.demo.service.attendanceService;
import com.example.demo.service.planService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/plan")
public class planController {
    @Autowired
    planService planService;
    @Autowired
    attendanceService attendanceService;
    /**
     * 获取现在的计划
     * @return
     */
    @RequestMapping(value = "/getNowPlan",produces = "application/json;charset=UTF-8")
    Result getNowPlan(){
        HashMap<String,Object>data=new HashMap<>();
        data.put("plans",planService.getNowPlan());
        return new Result(data,"yes",200);
    }
    /**
     * 获取未来的计划
     * @return
     */
    @RequestMapping(value = "/getFuturePlan",produces = "application/json;charset=UTF-8")
    Result getFuturePlan(){
        HashMap<String,Object>data=new HashMap<>();
        data.put("plans",planService.getFuturePlan());
        return new Result(data,"yes",200);
    }
    /**
     * 改变指定id的计划的status
     * @param id 计划的id
     * @return data 中包含改变status后的rate
     */
    @RequestMapping(value = "/changeStatus/{id}",produces = "application/json;charset=UTF-8")
    Result changeStatus(@PathVariable Integer id){
        planService.changeStatus(id);
        HashMap<String,Object>data=new HashMap<>();
        int rate=planService.getCompleteRate();
        int Aid=attendanceService.getNowAttendance().getId();
        attendanceService.updateAttendance(rate,Aid);
        data.put("rate",rate);
        return new Result(data,"yes",200);
    }

    /**
     * 获取现在计划完成率
     * @return 计划完成率
     */
    @RequestMapping(value = "/getCompleteRate",produces = "application/json;charset=UTF-8")
    Result getCompleteRate(){
        HashMap<String,Object>data=new HashMap<>();
        data.put("rate",planService.getCompleteRate());
        return new Result(data,"yes",200);
    }

    /**
     * 制定明日计划
     * @param plans 明日计划List
     * @return
     */
    @RequestMapping(value = "/makePlan",method = RequestMethod.PUT,produces = "application/json;charset=UTF-8")
    Result makePlan(@RequestBody List<plan> plans){
        planService.resetPlan();
        for (plan plan : plans) {
            planService.makePlan(plan);
        }
        HashMap<String,Object>data=new HashMap<>();
        return new Result(data,"yes",200);
    }
}
