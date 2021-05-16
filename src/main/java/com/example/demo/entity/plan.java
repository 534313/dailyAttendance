package com.example.demo.entity;

import java.sql.Time;

public class plan {
    Time beginTime;
    Time endTime;
    String work;
    Integer id;
    Boolean status;

    public Time getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Time beginTime) {
        this.beginTime = beginTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public plan(Time beginTime, Time endTime, String work) {
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.work = work;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public plan() {
    }

    @Override
    public String toString() {
        return "plan{" +
                "beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", work='" + work + '\'' +
                ", id=" + id +
                ", status=" + status +
                '}';
    }
}
