package com.elab.actebe.domaine.config;

import com.elab.actebe.domaine.AuditedEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "file_type")
public class FileType extends AuditedEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="code")
    private String code;

    @Column(name="name")
    private String name;

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
}
