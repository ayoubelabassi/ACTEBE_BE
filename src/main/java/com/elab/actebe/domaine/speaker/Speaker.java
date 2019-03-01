package com.elab.actebe.domaine.speaker;

import com.elab.actebe.domaine.AuditedEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "speaker")
public class Speaker extends AuditedEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    /**
     * Getters and setters
     *
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
}
