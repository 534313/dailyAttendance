package com.example.demo.dao;

import com.example.demo.entity.plan;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface planDao {
    List<plan> getNowPlan();
    List<plan> getFuturePlan();
    boolean getStatusById(int id);
    void changeStatus(int id,boolean status);
    int getCompleteNum();
    void resetPlan();
    void MakePlan(plan p);
    void changePlan();
}
