package com.elab.actebe.domaine.config;

import com.elab.actebe.domaine.AuditedEntity;
import com.elab.actebe.domaine.security.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "meta_file")
public class MetaFile  extends AuditedEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    @Column(name="file_name")
    private String fileName;
    @Column(name="file_path")
    private String filePath;
    @Column(name="file_size")
    private long fileSize;
    @Column(name="file_type")
    private String fileType;
    @Column(name="file_size_text")
    private long fileSizeText;

    /**
     * Getters and setters
     */

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public long getFileSizeText() {
        return fileSizeText;
    }

    public void setFileSizeText(long fileSizeText) {
        this.fileSizeText = fileSizeText;
    }

}
