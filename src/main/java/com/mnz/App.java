package com.mnz;

import com.mnz.service.*;

import java.util.List;

public class App {
    public static void main(String[] args) {

        INameExtractor extractor = new NameExtractor();
        List<String> names;
        if (args.length != 1) {
            names = extractor.extractNamesToList("sorted-names-list.txt");
        }else {
            names = extractor.extractNamesToList(args[0]);
        }

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
