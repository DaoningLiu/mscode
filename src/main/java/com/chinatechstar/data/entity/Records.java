package com.chinatechstar.data.entity;

import com.chinatechstar.component.commons.entity.TimeEntity;

import java.io.Serializable;

public class Records extends TimeEntity implements Serializable {
    private static final long serialVersionUID = -5385821913419714895L;
    private String id ;
    private String ddc001;
    private String ddc002;
    private String ddc003;
    private String ddc004;
    private String accab19;
    private String materialType;
    private String recordsText;
    private String userId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDdc001() {
        return ddc001;
    }

    public void setDdc001(String ddc001) {
        this.ddc001 = ddc001;
    }

    public String getDdc002() {
        return ddc002;
    }

    public void setDdc002(String ddc002) {
        this.ddc002 = ddc002;
    }

    public String getDdc003() {
        return ddc003;
    }

    public void setDdc003(String ddc003) {
        this.ddc003 = ddc003;
    }

    public String getDdc004() {
        return ddc004;
    }

    public void setDdc004(String ddc004) {
        this.ddc004 = ddc004;
    }

    public String getAccab19() {
        return accab19;
    }

    public void setAccab19(String accab19) {
        this.accab19 = accab19;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public String getRecordsText() {
        return recordsText;
    }

    public void setRecordsText(String recordsText) {
        this.recordsText = recordsText;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
