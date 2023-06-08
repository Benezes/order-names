package com.mnz;

import com.mnz.service.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class App {
    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Please provide a file name as an argument.");
            return;
        }

        INameExtractor extractor = new NameExtractor();
        List<String> names = extractor.extractNamesToList(args[0]);

        INameSorter sorter = new NameSorter();
        sorter.sortNames(names);

        ICreateTextFile createTextFile = new CreateTextFile();
        createTextFile.createSortedNamesTextFile(names);

        for (String name :
                names) {
            System.out.println(name);
        }
    }
}
