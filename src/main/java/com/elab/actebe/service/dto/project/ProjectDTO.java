package com.elab.actebe.service.dto.project;

import com.elab.actebe.service.dto.AuditedEntityDTO;

import java.io.Serializable;
import java.util.Date;

public class ProjectDTO extends AuditedEntityDTO implements Serializable {

    private long id;

    private String name;

    private String code;

    private String description;

    private Date startDate;

    private Date endDate;

    private String statut;

    private String nature;

    private double studiesBudget;

    private double affaireBudget;

    private double referencedCost;

    private double alouedCost;

    private long category;

    private String categoryName;

    //private List<Plan> plans = new ArrayList<Plan>();


    public ProjectDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public double getStudiesBudget() {
        return studiesBudget;
    }

    public void setStudiesBudget(double studiesBudget) {
        this.studiesBudget = studiesBudget;
    }

    public double getAffaireBudget() {
        return affaireBudget;
    }

    public void setAffaireBudget(double affaireBudget) {
        this.affaireBudget = affaireBudget;
    }

    public double getReferencedCost() {
        return referencedCost;
    }

    public void setReferencedCost(double referencedCost) {
        this.referencedCost = referencedCost;
    }

    public double getAlouedCost() {
        return alouedCost;
    }

    public void setAlouedCost(double alouedCost) {
        this.alouedCost = alouedCost;
    }

    public long getCategory() {
        return category;
    }

    public void setCategory(long category) {
        this.category = category;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
