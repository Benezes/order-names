package com.mnz.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NameSorter implements INameSorter {

    @Override
    public void sortNames(List<String> names) {
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String lastName1 = o1.substring(o1.lastIndexOf(" ") + 1);
                String lastName2 = o2.substring(o2.lastIndexOf(" ") + 1);
                int lastNameComparison = lastName1.compareTo(lastName2);
                if (lastNameComparison != 0) {
                    return lastNameComparison;
                } else {
                    return o1.compareTo(o2);
                }
            }
        };
        Collections.sort(names, comparator);
    }
}
