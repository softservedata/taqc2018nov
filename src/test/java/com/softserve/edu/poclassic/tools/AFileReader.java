package com.softserve.edu.poclassic.tools;

import java.util.List;

public abstract class AFileReader implements IExternalReader {
    protected final String PATH_SEPARATOR = "/";
    protected String filename;
    protected String path;

    public AFileReader(String filename) {
        this.filename = filename;
        this.path = this.getClass().getResource(PATH_SEPARATOR + filename).getPath().substring(1);
        System.out.println("***PATH = " + path);
    }
    
    public String getFilename() {
        return this.filename;
    }

    public String getPath() {
        return this.path;
    }

    @Override
    public List<List<String>> getAllCells() {
        return getAllCells(path);
    }

}