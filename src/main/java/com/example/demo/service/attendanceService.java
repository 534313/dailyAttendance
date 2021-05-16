package com.example.demo.service;

import com.example.demo.dao.attendanceDao;
import com.example.demo.entity.attendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class attendanceService {
    @Autowired
    attendanceDao attendanceDao;

    /**
     * 获取打卡的天数
     * @return
     */
    public int getNum(){
        return attendanceDao.getNum();
    }

    /**
     * 插入打卡记录（开始打卡）
     * @param a
     */
    public void insertAttendance(attendance a){
        attendanceDao.insertAttendance(a);
    }

    /**
     * 获取今天的打卡记录
     * @return
     */
    public attendance getNowAttendance(){
        return attendanceDao.getNowAttendance();
    }

    /**
     * 判断今天是否打卡
     * @return
     */
    public boolean judgeAttendance(){
        attendance a=attendanceDao.getNowAttendance();
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd ");
        if(a==null){
            return false;
        }
        return fmt.format(new Date()).equals(fmt.format(a.getTime()));
    }

    /**
     * 修改指定id的打卡记录的完成率
     * @param rate
     * @param id
     */
    public void updateAttendance(int rate,int id){
        attendanceDao.updateAttendance(rate,id);
    }

    /**
     * 获取全部的打卡记录
     * @return
     */
    public List<attendance> getAllAttendances(){
        return attendanceDao.getAllAttendances();
    }

}
