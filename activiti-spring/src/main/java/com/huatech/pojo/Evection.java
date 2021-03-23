package com.huatech.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 廖恩光
 * @version 1.0
 * @date 2021/3/22 15:47
 * 出差申请中流程变量对象
 */
public class Evection implements Serializable {

    private Long id;//主键ID
    private String evectionName;//出差单名字
    private Double num;//出差天数
    private Date beginDate;//出差开始时间
    private Date endDate;//出差结束时间
    private String destination;//目的地
    private String reson;//出差原因

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEvectionName() {
        return evectionName;
    }

    public void setEvectionName(String evectionName) {
        this.evectionName = evectionName;
    }

    public Double getNum() {
        return num;
    }

    public void setNum(Double num) {
        this.num = num;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getReson() {
        return reson;
    }

    public void setReson(String reson) {
        this.reson = reson;
    }
}
