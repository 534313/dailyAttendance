package com.example.demo;

import com.example.demo.service.planService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class planTests {
    @Autowired
    planService planService;

    @Test
    void getAllPlans(){
        System.out.println(planService.getNowPlan());
    }

    @Test
    void changeStatus(){
        planService.changeStatus(1);
    }
    @Test
    void getCompleteRate(){
        System.out.println(planService.getCompleteRate());
    }
    @Test
    void resetPlan(){
        planService.changePlan();
    }
}
