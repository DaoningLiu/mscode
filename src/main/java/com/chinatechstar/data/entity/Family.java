package com.chinatechstar.data.entity;

import com.chinatechstar.component.commons.entity.TimeEntity;

import java.io.Serializable;

/**
 * 家庭情况信息集
 */
public class Family extends TimeEntity implements Serializable {
    private static final long serialVersionUID = -4868031010675520377L;
    private String id;//主键
    private String familyMemberName;//家庭成员名字
    private String familyRelation;//与本人关系
    private String unitPost;//家庭成员工作单位或者职务

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFamilyMemberName() {
        return familyMemberName;
    }

    public void setFamilyMemberName(String familyMemberName) {
        this.familyMemberName = familyMemberName;
    }

    public String getFamilyRelation() {
        return familyRelation;
    }

    public void setFamilyRelation(String familyRelation) {
        this.familyRelation = familyRelation;
    }

    public String getUnitPost() {
        return unitPost;
    }

    public void setUnitPost(String unitPost) {
        this.unitPost = unitPost;
    }
}
