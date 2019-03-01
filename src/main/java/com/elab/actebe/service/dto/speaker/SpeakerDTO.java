package com.elab.actebe.service.dto.speaker;

import com.elab.actebe.service.dto.AuditedEntityDTO;

public class SpeakerDTO extends AuditedEntityDTO {
    private long id;

    private String name;

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
