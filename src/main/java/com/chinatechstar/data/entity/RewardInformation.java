package com.chinatechstar.data.entity;

import com.chinatechstar.component.commons.entity.TimeEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * 奖惩信息集
 */
public class RewardInformation extends TimeEntity implements Serializable {
    private static final long serialVersionUID = 6663566508265892307L;

    private String id;//
    private String awardName;//奖励名称
    private String awardUnit;//奖励批准单位
    private Date create_time;//奖励批准时间
    private String punishmentName;//处分名称
    private String punishmentUnitName;//处分批准单位名称
    private Date punishmentTime;//处分批准日期

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

    public String getAwardUnit() {
        return awardUnit;
    }

    public void setAwardUnit(String awardUnit) {
        this.awardUnit = awardUnit;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getPunishmentName() {
        return punishmentName;
    }

    public void setPunishmentName(String punishmentName) {
        this.punishmentName = punishmentName;
    }

    public String getPunishmentUnitName() {
        return punishmentUnitName;
    }

    public void setPunishmentUnitName(String punishmentUnitName) {
        this.punishmentUnitName = punishmentUnitName;
    }

    public Date getPunishmentTime() {
        return punishmentTime;
    }

    public void setPunishmentTime(Date punishmentTime) {
        this.punishmentTime = punishmentTime;
    }
}
