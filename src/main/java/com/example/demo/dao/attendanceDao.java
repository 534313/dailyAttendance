package com.example.demo.dao;

import com.example.demo.entity.attendance;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface attendanceDao {
    int getNum();
    void insertAttendance(attendance a);
    attendance getNowAttendance();
    List<attendance> getAllAttendances();
    void updateAttendance(int rate,int id);
}
