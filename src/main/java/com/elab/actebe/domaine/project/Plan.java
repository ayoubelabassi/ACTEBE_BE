package com.elab.actebe.domaine.project;

import com.elab.actebe.domaine.AuditedEntity;
import com.elab.actebe.domaine.security.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "plan")
public class Plan extends AuditedEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "statut")
    private String statut;

    @OneToMany(mappedBy = "plan")
    private List<Revision> revisions = new ArrayList<Revision>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_fk")
    private Project project;
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

    public List<Revision> getRevisions() {
        return revisions;
    }

    public void setRevisions(List<Revision> revisions) {
        this.revisions = revisions;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
