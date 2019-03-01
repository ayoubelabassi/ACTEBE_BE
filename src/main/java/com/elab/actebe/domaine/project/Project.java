package com.elab.actebe.domaine.project;

import com.elab.actebe.domaine.AuditedEntity;
import com.elab.actebe.domaine.config.Category;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity(name="project")
public class Project extends AuditedEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="code")
    private String code;

    @Column(name="description")
    private String description;

    @Column(name="start_date")
    private Date startDate;

    @Column(name="end_date")
    private Date endDate;

    @Column(name="statut")
    private String statut;

    @Column(name="nature")
    private String nature;

    @Column(name="studiesBudget")
    private double studiesBudget;

    @Column(name="affaireBudget")
    private double affaireBudget;

    @Column(name="referencedCost")
    private double referencedCost;

    @Column(name="alouedCost")
    private double alouedCost;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_fk")
    private Category category;

    @OneToMany(mappedBy = "project")
    private Set<Plan> plans = new HashSet<>();

    /**
     * Getters and setters
     * @return
     */

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

    public Set<Plan> getPlans() {
        return plans;
    }

    public void setPlans(Set<Plan> plans) {
        this.plans = plans;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
