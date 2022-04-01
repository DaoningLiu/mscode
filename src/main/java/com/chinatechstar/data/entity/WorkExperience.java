package com.chinatechstar.data.entity;

import com.chinatechstar.component.commons.entity.TimeEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * 工作经历信息集
 */
public class WorkExperience extends TimeEntity implements Serializable {
    private static final long serialVersionUID = 798525187491819529L;
    private String id;//
    private String unitsName;//所在单位名称
    private String unitsProveName;//单位证明人
    private Date createTime;//工作起始时间
    private Date stopTime;//工作终止时间
    private String unitsJop;//从事工作或者担任职务

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUnitsName() {
        return unitsName;
    }

    public void setUnitsName(String unitsName) {
        this.unitsName = unitsName;
    }

    public String getUnitsProveName() {
        return unitsProveName;
    }

    public void setUnitsProveName(String unitsProveName) {
        this.unitsProveName = unitsProveName;
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

    public String getUnitsJop() {
        return unitsJop;
    }

    public void setUnitsJop(String unitsJop) {
        this.unitsJop = unitsJop;
    }
}
