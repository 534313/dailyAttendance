package com.example.demo.service;

import com.example.demo.dao.planDao;
import com.example.demo.entity.plan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class planService {
    @Autowired
    planDao planDao;

    /**
     * 获取当前计划列表
     * @return
     */
    public List<plan> getNowPlan(){
        return planDao.getNowPlan();
    }

    /**
     * 获取明日计划列表
     * @return
     */
    public List<plan> getFuturePlan(){
        return planDao.getFuturePlan();
    }

    /**
     * 修改指定id计划的打卡状态（若为已经打卡，则改为未打卡，若为未打卡，则修改为已打卡）
     * @param id 计划的id
     */
    public void changeStatus(int id){
        planDao.changeStatus(id,!planDao.getStatusById(id));
    }

    /**
     * 获取打卡完成率
     * @return
     */
    public int getCompleteRate(){
        return 100*(planDao.getCompleteNum())/(planDao.getNowPlan().size());
    }

    /**
     * 重置计划
     */
    public void resetPlan(){
        planDao.resetPlan();
    }

    /**
     * 修改今日计划（即将明日计划覆盖今日计划）
     */
    public void changePlan(){
        planDao.changePlan();
    }

    /**
     * 制定计划
     * @param a
     */
    public void makePlan(plan a){
        planDao.MakePlan(a);
    }

}
