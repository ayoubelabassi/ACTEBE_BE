package com.elab.actebe.domaine.config;

import com.elab.actebe.domaine.AuditedEntity;
import com.elab.actebe.domaine.security.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "entity")
public class Entite extends AuditedEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="code")
    private String code;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entity_fk")
    private Entite entity;

    /**
     * Getters and setters
     * @return
     */
    public Entite getEntity() {
        return entity;
    }

    public void setEntity(Entite entity) {
        this.entity = entity;
    }

    @OneToMany(mappedBy = "entity")
    private List<Entite> entities = new ArrayList<Entite>();

    public List<Entite> getEntities() {
        return entities;
    }

    public void setEntities(List<Entite> entities) {
        this.entities = entities;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
