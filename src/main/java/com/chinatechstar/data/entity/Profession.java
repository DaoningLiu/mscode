package com.chinatechstar.data.entity;

import com.chinatechstar.component.commons.entity.TimeEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * 职称与职业资格信息集
 */
public class Profession extends TimeEntity implements Serializable {
    private static final long serialVersionUID = -4982121155655927237L;
    private String id;//主键
    private String ProfessionalLevel;//职业级别
    private String statusGrade;//国家职业资格等级（技术人员等级）
    private String professionName;//职业名称
    private Date credentialTime;//取得专业资格日期
    private String professionStatus;//职业（工种）资格名称

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProfessionalLevel() {
        return ProfessionalLevel;
    }

    public void setProfessionalLevel(String professionalLevel) {
        ProfessionalLevel = professionalLevel;
    }

    public String getStatusGrade() {
        return statusGrade;
    }

    public void setStatusGrade(String statusGrade) {
        this.statusGrade = statusGrade;
    }

    public String getProfessionName() {
        return professionName;
    }

    public void setProfessionName(String professionName) {
        this.professionName = professionName;
    }

    public Date getCredentialTime() {
        return credentialTime;
    }

    public void setCredentialTime(Date credentialTime) {
        this.credentialTime = credentialTime;
    }

    public String getProfessionStatus() {
        return professionStatus;
    }

    public void setProfessionStatus(String professionStatus) {
        this.professionStatus = professionStatus;
    }
}
