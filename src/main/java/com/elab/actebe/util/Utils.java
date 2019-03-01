package com.elab.actebe.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class Utils {

    public static HttpHeaders getPDFHeaders(String fileName) {
        HttpHeaders head = new HttpHeaders();
        head.setContentType(MediaType.parseMediaType("application/pdf"));
        head.add("content-disposition", "attachment; filename=\"" + fileName+"\"");
        head.setContentDispositionFormData(fileName, fileName);
        head.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        return head;
    }

    public static HttpHeaders getAnyFileHeaders(String fileName, long lenght) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/octet-stream"));
        headers.setContentLength(lenght);
        headers.add("content-disposition", "attachment; filename=\"" + fileName+"\"");
        headers.setContentDispositionFormData(fileName, fileName);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        return headers;
    }

}
