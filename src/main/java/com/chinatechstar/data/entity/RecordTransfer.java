package com.chinatechstar.data.entity;

import com.chinatechstar.component.commons.entity.TimeEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * 档案接转信息集
 */

public class RecordTransfer extends TimeEntity implements Serializable {
    private static final long serialVersionUID = 4239276655782924119L;
    private String id;
    private String unitName;//委托存档单位名称
    private String beforeName;//原存档单位名称
    private String beforeCode;//原存档单位行政化代码
    private String transferUnit;//转往单位名称
    private String transferCode;//转往单位行政区划代码
    private String recordCode;//存档编号
    private Integer pullCode;//牵引号
    private Integer recordState;//存档状态
    private Integer recordNature;//存档性质
    private Date joinTime;//转入日期
    private Integer joinCause;//转入原因
    private Date leaveime;//转出日期
    private Integer leaveause;//转出原因

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getBeforeName() {
        return beforeName;
    }

    public void setBeforeName(String beforeName) {
        this.beforeName = beforeName;
    }

    public String getBeforeCode() {
        return beforeCode;
    }

    public void setBeforeCode(String beforeCode) {
        this.beforeCode = beforeCode;
    }

    public String getTransferUnit() {
        return transferUnit;
    }

    public void setTransferUnit(String transferUnit) {
        this.transferUnit = transferUnit;
    }

    public String getTransferCode() {
        return transferCode;
    }

    public void setTransferCode(String transferCode) {
        this.transferCode = transferCode;
    }

    public String getRecordCode() {
        return recordCode;
    }

    public void setRecordCode(String recordCode) {
        this.recordCode = recordCode;
    }

    public Integer getPullCode() {
        return pullCode;
    }

    public void setPullCode(Integer pullCode) {
        this.pullCode = pullCode;
    }

    public Integer getRecordState() {
        return recordState;
    }

    public void setRecordState(Integer recordState) {
        this.recordState = recordState;
    }

    public Integer getRecordNature() {
        return recordNature;
    }

    public void setRecordNature(Integer recordNature) {
        this.recordNature = recordNature;
    }

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    public Integer getJoinCause() {
        return joinCause;
    }

    public void setJoinCause(Integer joinCause) {
        this.joinCause = joinCause;
    }

    public Date getLeaveime() {
        return leaveime;
    }

    public void setLeaveime(Date leaveime) {
        this.leaveime = leaveime;
    }

    public Integer getLeaveause() {
        return leaveause;
    }

    public void setLeaveause(Integer leaveause) {
        this.leaveause = leaveause;
    }
}
