package com.softserve.edu.poclassic.tools;

import java.util.List;

public interface IExternalReader {
    String FILE_NOT_FOUND_EXCEPTION = "File %s could not be found";
    String FILE_NOT_READ_EXCEPTION = "File %s could not be read";
    String FILE_NOT_CLOSE_EXCEPTION = "File %s could not be closed";
    String DB_READING_ERROR = "DB Reading Error, %s";

    // String getPath();

    List<List<String>> getAllCells(); // public abstract

    List<List<String>> getAllCells(String path);

}