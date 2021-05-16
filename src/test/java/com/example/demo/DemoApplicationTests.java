package com.example.demo;

import com.example.demo.service.attendanceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    attendanceService attendanceService;
    @Test
    void contextLoads() {
        System.out.println(attendanceService.getNum());
    }

}
