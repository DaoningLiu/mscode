package com.chinatechstar.data.entity;

import com.chinatechstar.component.commons.entity.TimeEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * 培训经历信息集
 */
public class TrainingClass extends TimeEntity implements Serializable {

    private static final long serialVersionUID = -5640700697264668150L;
    private String id;//
    private String trainingClassName;//培训班名称
    private String trainingClassUnits;//培训班主办单位
    private Date createTime;//起始时间
    private Date stopTime;//培训终止时间

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTrainingClassName() {
        return trainingClassName;
    }

    public void setTrainingClassName(String trainingClassName) {
        this.trainingClassName = trainingClassName;
    }

    public String getTrainingClassUnits() {
        return trainingClassUnits;
    }

    public void setTrainingClassUnits(String trainingClassUnits) {
        this.trainingClassUnits = trainingClassUnits;
    }

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getStopTime() {
        return stopTime;
    }

    public void setStopTime(Date stopTime) {
        this.stopTime = stopTime;
    }
}
