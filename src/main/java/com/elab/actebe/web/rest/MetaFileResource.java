package com.elab.actebe.web.rest;

import com.elab.actebe.domaine.config.MetaFile;
import com.elab.actebe.repository.MetaFileRepository;
import com.elab.actebe.service.intf.MetaFileService;
import com.elab.actebe.util.Globals;
import com.elab.actebe.util.Utils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.inject.Inject;
import java.io.*;

@RestController
@RequestMapping("/api/meta_files")
public class MetaFileResource {

    @Inject
    private MetaFileService fileService;

    @Inject
    private MetaFileRepository fileRepository;

    @Inject
    private Environment environment;

    /**
     * @Author AYOUB
     * @Date 07/11/2018
     * @param mFile
     * @return
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResponseEntity<MetaFile> upload(@RequestParam("file") MultipartFile mFile){
        File file=new File(environment.getProperty(Globals.WORK_DIRECTORY)+mFile.getOriginalFilename());
        MetaFile metaFile=new MetaFile();
        try {
            file.createNewFile();
            FileOutputStream fout= new FileOutputStream(file);
            fout.write(mFile.getBytes());
            fout.close();

            metaFile.setFileName(file.getName());
            metaFile.setFilePath(file.getPath());
            metaFile.setFileSize(file.getTotalSpace());
            metaFile.setFileType(FilenameUtils.getExtension(file.getName()));
            metaFile = fileService.save(metaFile);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity(e, HttpStatus.EXPECTATION_FAILED);
        }
        return new ResponseEntity(metaFile,HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "/download/{id}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> download(@PathVariable("id") long id) throws Exception {
        MetaFile metaFile=fileRepository.getOne(id);
        if(metaFile==null){
            throw new Exception("File not Found");
        }
        else {
            File file=new File(metaFile.getFilePath());
            InputStream inputStream=new FileInputStream(file);
            /*
            Path path = Paths.get(metaFile.getFilePath());
            ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));
            return new ResponseEntity<Resource>(resource, Utils.getAnyFileHeaders(metaFile.getFileName(),file.length()), HttpStatus.OK);
            */
            return new ResponseEntity<byte[]>(IOUtils.toByteArray(inputStream), Utils.getAnyFileHeaders(metaFile.getFileName(),file.length()), HttpStatus.OK);
        }
    }
}
