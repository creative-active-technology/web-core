/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inkubator.webcore.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

/**
 *
 * @author Deni Husni Fahri Rizal
 * @version 1
 * @since 10 February 2014
 */
public class FacesIO implements ResourceLoaderAware, InitializingBean {

    private String pathUpload;
    private Integer bufferSize;
    private ResourceLoader resourceLoader;
    private Resource dataIn;

    public Integer getBufferSize() {
        return bufferSize;
    }

    public void setBufferSize(Integer bufferSize) {
        this.bufferSize = bufferSize;
    }

    public String getPathUpload() {
        return pathUpload;
    }

    public void setPathUpload(String pathUpload) {
        this.pathUpload = pathUpload;
    }

    public void transferFile(UploadedFile uploadedFile) throws IOException {
        File fileHasTransfer = new File(pathUpload, uploadedFile.getFileName());
        InputStream inputStream;
        try (OutputStream outputStream = new FileOutputStream(fileHasTransfer)) {
            byte[] buffer = new byte[bufferSize];
            int bulk;
            inputStream = uploadedFile.getInputstream();
            while (true) {
                bulk = inputStream.read(buffer);
                if (bulk < 0) {
                    break;
                }
                outputStream.write(buffer, 0, bulk);
                outputStream.flush();
            }
        }
        inputStream.close();
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public InputStream getInputStreamFromName(String namaFile) throws IOException {
        dataIn = resourceLoader.getResource("file:" + pathUpload + namaFile);
        return dataIn.getInputStream();
    }

    public InputStream getInputStreamFromURL(String url) throws IOException {
        dataIn = resourceLoader.getResource("file:" + url);
        return dataIn.getInputStream();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (pathUpload.equalsIgnoreCase("") || pathUpload == null) {
            throw new Exception("Mr. DHFR say :Property of pathUpload can't be null. "
                    + "Please see and config web_util.properties");
        }

        if (bufferSize == null || bufferSize == 0) {
            throw new Exception("Mr. DHFR say :Property of bufferSize can't be null or zero. "
                    + "Please see and config web_util.properties");

        }
        if (resourceLoader == null) {
            throw new Exception("Mr. DHFR say :Property of resourceLoader can't be null "
                    + "Please see and spring web config or config web_util.properties");

        }
    }
}
