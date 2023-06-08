package com.mnz.service;

import com.mnz.service.exception.CreateTextFileException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CreateTextFile implements ICreateTextFile{

    @Override
    public void createSortedNamesTextFile(List<String> names) {
        try {
            Files.write(Paths.get("sorted-names-list.txt"), names);
        } catch (IOException e) {
            throw new CreateTextFileException("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
