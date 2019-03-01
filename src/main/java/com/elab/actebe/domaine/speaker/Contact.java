package com.elab.actebe.domaine.speaker;

import com.elab.actebe.domaine.AuditedEntity;

import javax.persistence.*;

@Entity(name="contact")
public class Contact extends AuditedEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    @Column(name="address")
    private String address;
    @Column(name="tel")
    private String tel;
    @Column(name="fix")
    private String fix;
    @Column(name="email")
    private String email;
    @Column(name="fax")
    private String fax;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFix() {
        return fix;
    }

    public void setFix(String fix) {
        this.fix = fix;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }
}
