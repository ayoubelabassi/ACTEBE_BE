package com.elab.actebe.domaine.config;

import com.elab.actebe.domaine.AuditedEntity;
import com.elab.actebe.domaine.security.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "noeud")
public class Noeud extends AuditedEntity implements Serializable {
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
    @JoinColumn(name = "noeud_fk")
    private Noeud noeud;

    @OneToMany(mappedBy = "noeud")
    private List<Noeud> noeuds = new ArrayList<Noeud>();

    /**
     * Getters and setters
     * @return
     */
    public Noeud getNoeud() {
        return noeud;
    }

    public void setNoeud(Noeud noeud) {
        this.noeud = noeud;
    }

    public List<Noeud> getNoeuds() {
        return noeuds;
    }

    public void setNoeuds(List<Noeud> noeuds) {
        this.noeuds = noeuds;
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
