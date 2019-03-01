package com.elab.actebe.domaine.security;

import com.elab.actebe.domaine.AuditedEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name="permission")
public class Permission extends AuditedEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="familly")
    private String familly;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;
    /**
     * getters and setters
     * @return
     */

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFamilly() {
        return familly;
    }

    public void setFamilly(String familly) {
        this.familly = familly;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
