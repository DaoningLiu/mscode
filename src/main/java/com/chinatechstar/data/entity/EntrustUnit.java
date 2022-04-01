package com.chinatechstar.data.entity;

import com.chinatechstar.component.commons.entity.TimeEntity;

import java.io.Serializable;

/**
 * 委托单位存档信息表
 */
public class EntrustUnit extends TimeEntity implements Serializable {
    private static final long serialVersionUID = 1381391326522542403L;
    private String id;//主键
    private String recordUnitName;//存档单位名称
    private String unitCredit;//委托存档单位统一信用代码
    private String unitCode;//委托存档单位编码
    private String unitType;//委托存档单位机构类型
    private String unitTrade;//委托存档单位所属行业
    private String unitEconomics;//委托存档行业经济类型
    private String unitAdministrative;//委托存档行政化代码

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRecordUnitName() {
        return recordUnitName;
    }

    public void setRecordUnitName(String recordUnitName) {
        this.recordUnitName = recordUnitName;
    }

    public String getUnitCredit() {
        return unitCredit;
    }

    public void setUnitCredit(String unitCredit) {
        this.unitCredit = unitCredit;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public String getUnitTrade() {
        return unitTrade;
    }

    public void setUnitTrade(String unitTrade) {
        this.unitTrade = unitTrade;
    }

    public String getUnitEconomics() {
        return unitEconomics;
    }

    public void setUnitEconomics(String unitEconomics) {
        this.unitEconomics = unitEconomics;
    }

    public String getUnitAdministrative() {
        return unitAdministrative;
    }

    public void setUnitAdministrative(String unitAdministrative) {
        this.unitAdministrative = unitAdministrative;
    }
}
