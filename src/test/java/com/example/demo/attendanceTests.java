package com.example.demo;

import com.example.demo.entity.attendance;
import com.example.demo.service.attendanceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;


@SpringBootTest
public class attendanceTests {
    @Autowired
    attendanceService attendanceService;
    @Test
    void contextLoads() {
        System.out.println(attendanceService.getNum());
    }
    @Test
    void insertAttendance(){
        attendance a=new attendance(new Date(),0);
        attendanceService.insertAttendance(a);
    }
    @Test
    void getNowAttendance(){
        System.out.println(attendanceService.getNowAttendance());
    }

    @Test
    void judge(){
        System.out.println(attendanceService.judgeAttendance());
    }
}
