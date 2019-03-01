package com.elab.actebe.service.dto.project;

import com.elab.actebe.service.dto.AuditedEntityDTO;

public class PlanDTO extends AuditedEntityDTO {
    private long id;

    private String code;

    private String name;

    private String statut;

    //private List<Revision> revisions = new ArrayList<Revision>();

    private long project_id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public long getProject_id() {
        return project_id;
    }

    public void setProject_id(long project_id) {
        this.project_id = project_id;
    }
}
