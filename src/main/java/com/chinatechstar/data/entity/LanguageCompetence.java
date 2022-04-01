package com.chinatechstar.data.entity;

import com.chinatechstar.component.commons.entity.TimeEntity;

import java.io.Serializable;

/**
 * 语言能力信息集
 */
public class LanguageCompetence extends TimeEntity implements Serializable {
    private static final long serialVersionUID = -5692576124807799138L;
    private Integer id;//主键
    private Integer languageName;//语种
    private Integer languageGrade;//语言熟悉程度

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLanguageName() {
        return languageName;
    }

    public void setLanguageName(Integer languageName) {
        this.languageName = languageName;
    }

    public Integer getLanguageGrade() {
        return languageGrade;
    }

    public void setLanguageGrade(Integer languageGrade) {
        this.languageGrade = languageGrade;
    }
}
