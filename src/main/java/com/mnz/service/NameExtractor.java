package com.mnz.service;

import com.mnz.service.exception.ExtractNameException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NameExtractor implements INameExtractor {

    @Override
    public List<String> extractNamesToList(String fileName) {
        List<String> names = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                names.add(line);
            }
        } catch (IOException e) {
            throw new ExtractNameException("An error occurred while reading the file: " + e.getMessage());
        }
        return names;
    }
}
