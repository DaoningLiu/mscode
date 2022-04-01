package com.chinatechstar.data.entity;

import com.chinatechstar.component.commons.entity.TimeEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * 个人基本信息集
 */
public class ProsonDateils extends TimeEntity implements Serializable {
    private static final long serialVersionUID = 5619522679176021281L;
    private String id;//
    private String personName;//姓名
    private String personNation;//民族
    private Date birthTime;//出生日期
    private Date workTime;//参加工作日期
    private String familyArea;//户籍所在地
    private Integer whetherMarried;//婚姻状况
    private Integer politicsVisage;//政治面貌
    private Date joinPartyTime;//入党时间
    private Integer personNumber;//个人手机号
    private String usedName;//曾用名
    private String personCard;//身份证
    private Integer tallBackground;//最高学历
    private String lowBackground;//最低学历
    private String graduationAcademy;//毕业院校、最高学历
    private String specialtyName;//最高学历、所学专业名称
    private String specialtyType;//最高学历、所学专业类别
    private Date backgroundTime;//最高学历毕业时间
    private Integer occupationType;//工作职位(岗位)类型
    private Integer nativePlace;//籍贯
    private Integer personBirthplace;//出生地
    private Integer registerCode;//户籍地行政化代码
    private String presentAddress;//现住址
    private String emailAddress;//电子邮箱
    private String companyName;//工作单位名称
    private String organizationCode;//组织机构代码
    private String creditCode;//组织机构社会信用代码
    private Integer organizationType;//工作单位机构类型
    private Integer organizationIndustry;//工作单位所属行业
    private Integer economicsType;//工作单位经济类型
    private Integer workplaceCode;//工作地点行政化代码
    private Integer postalCode;//邮政编码
    private Integer fileCode;//行政区划+地方档案编码

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonNation() {
        return personNation;
    }

    public void setPersonNation(String personNation) {
        this.personNation = personNation;
    }

    public Date getBirthTime() {
        return birthTime;
    }

    public void setBirthTime(Date birthTime) {
        this.birthTime = birthTime;
    }

    public Date getWorkTime() {
        return workTime;
    }

    public void setWorkTime(Date workTime) {
        this.workTime = workTime;
    }

    public String getFamilyArea() {
        return familyArea;
    }

    public void setFamilyArea(String familyArea) {
        this.familyArea = familyArea;
    }

    public Integer getWhetherMarried() {
        return whetherMarried;
    }

    public void setWhetherMarried(Integer whetherMarried) {
        this.whetherMarried = whetherMarried;
    }

    public Integer getPoliticsVisage() {
        return politicsVisage;
    }

    public void setPoliticsVisage(Integer politicsVisage) {
        this.politicsVisage = politicsVisage;
    }

    public Date getJoinPartyTime() {
        return joinPartyTime;
    }

    public void setJoinPartyTime(Date joinPartyTime) {
        this.joinPartyTime = joinPartyTime;
    }

    public Integer getPersonNumber() {
        return personNumber;
    }

    public void setPersonNumber(Integer personNumber) {
        this.personNumber = personNumber;
    }

    public String getUsedName() {
        return usedName;
    }

    public void setUsedName(String usedName) {
        this.usedName = usedName;
    }

    public String getPersonCard() {
        return personCard;
    }

    public void setPersonCard(String personCard) {
        this.personCard = personCard;
    }

    public Integer getTallBackground() {
        return tallBackground;
    }

    public void setTallBackground(Integer tallBackground) {
        this.tallBackground = tallBackground;
    }

    public String getLowBackground() {
        return lowBackground;
    }

    public void setLowBackground(String lowBackground) {
        this.lowBackground = lowBackground;
    }

    public String getGraduationAcademy() {
        return graduationAcademy;
    }

    public void setGraduationAcademy(String graduationAcademy) {
        this.graduationAcademy = graduationAcademy;
    }

    public String getSpecialtyName() {
        return specialtyName;
    }

    public void setSpecialtyName(String specialtyName) {
        this.specialtyName = specialtyName;
    }

    public String getSpecialtyType() {
        return specialtyType;
    }

    public void setSpecialtyType(String specialtyType) {
        this.specialtyType = specialtyType;
    }

    public Date getBackgroundTime() {
        return backgroundTime;
    }

    public void setBackgroundTime(Date backgroundTime) {
        this.backgroundTime = backgroundTime;
    }

    public Integer getOccupationType() {
        return occupationType;
    }

    public void setOccupationType(Integer occupationType) {
        this.occupationType = occupationType;
    }

    public Integer getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(Integer nativePlace) {
        this.nativePlace = nativePlace;
    }

    public Integer getPersonBirthplace() {
        return personBirthplace;
    }

    public void setPersonBirthplace(Integer personBirthplace) {
        this.personBirthplace = personBirthplace;
    }

    public Integer getRegisterCode() {
        return registerCode;
    }

    public void setRegisterCode(Integer registerCode) {
        this.registerCode = registerCode;
    }

    public String getPresentAddress() {
        return presentAddress;
    }

    public void setPresentAddress(String presentAddress) {
        this.presentAddress = presentAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public Integer getOrganizationType() {
        return organizationType;
    }

    public void setOrganizationType(Integer organizationType) {
        this.organizationType = organizationType;
    }

    public Integer getOrganizationIndustry() {
        return organizationIndustry;
    }

    public void setOrganizationIndustry(Integer organizationIndustry) {
        this.organizationIndustry = organizationIndustry;
    }

    public Integer getEconomicsType() {
        return economicsType;
    }

    public void setEconomicsType(Integer economicsType) {
        this.economicsType = economicsType;
    }

    public Integer getWorkplaceCode() {
        return workplaceCode;
    }

    public void setWorkplaceCode(Integer workplaceCode) {
        this.workplaceCode = workplaceCode;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    public Integer getFileCode() {
        return fileCode;
    }

    public void setFileCode(Integer fileCode) {
        this.fileCode = fileCode;
    }
}
