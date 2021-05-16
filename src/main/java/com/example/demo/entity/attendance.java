package com.example.demo.entity;


import java.text.SimpleDateFormat;
import java.util.Date;

public class attendance {
    Integer id;
    Date time;
    int rate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public attendance() {
    }

    public attendance(Date time, int rate) {
        this.time = time;
        this.rate = rate;
    }

    @Override
    public String toString() {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd ");
        return "attendance{" +
                "id=" + id +
                ", time=" + fmt.format(time) +
                ", rate=" + rate +
                '}';
    }
}
