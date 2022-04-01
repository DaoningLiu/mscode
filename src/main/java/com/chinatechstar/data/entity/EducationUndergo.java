package com.chinatechstar.data.entity;

import com.chinatechstar.component.commons.entity.TimeEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * 教育经历信息表
 */
public class EducationUndergo extends TimeEntity implements Serializable {
    private static final long serialVersionUID = -62133195723921695L;
    private String id;//主键
    private String inSchool;//所在学校
    private Date joinTime;//入学时间
    private Date leaveTime;//离校时间
    private String specialtyName;//专业名称
    private String gainBackground;//所获得学历
    private String gainQualification;//所获学位
    private String educationType;//教育类别
    private String learnShape;//学习形式

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInSchool() {
        return inSchool;
    }

    public void setInSchool(String inSchool) {
        this.inSchool = inSchool;
    }

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    public Date getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(Date leaveTime) {
        this.leaveTime = leaveTime;
    }

    public String getSpecialtyName() {
        return specialtyName;
    }

    public void setSpecialtyName(String specialtyName) {
        this.specialtyName = specialtyName;
    }

    public String getGainBackground() {
        return gainBackground;
    }

    public void setGainBackground(String gainBackground) {
        this.gainBackground = gainBackground;
    }

    public String getGainQualification() {
        return gainQualification;
    }

    public void setGainQualification(String gainQualification) {
        this.gainQualification = gainQualification;
    }

    public String getEducationType() {
        return educationType;
    }

    public void setEducationType(String educationType) {
        this.educationType = educationType;
    }

    public String getLearnShape() {
        return learnShape;
    }

    public void setLearnShape(String learnShape) {
        this.learnShape = learnShape;
    }
}
