package com.mnz.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class NameSorterTest {

    private INameSorter sorter;
    private INameExtractor extractor;

    @BeforeEach
    void setUp() {
        sorter = new NameSorter();
        extractor = new NameExtractor();
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "src/test/java/com/mnz/service/unsorted-names-tests/50_unsorted-names.txt",
            "src/test/java/com/mnz/service/unsorted-names-tests/250_unsorted-names.txt",
            "src/test/java/com/mnz/service/unsorted-names-tests/1000_unsorted-names.txt",
            "src/test/java/com/mnz/service/unsorted-names-tests/10000_unsorted-names.txt",
            "src/test/java/com/mnz/service/unsorted-names-tests/100000_unsorted-names.txt",
            "src/test/java/com/mnz/service/unsorted-names-tests/1000000_unsorted-names.txt"
    })
    void testSortNames(String filePath) {
        List<String> names = extractor.extractNamesToList(filePath);

        sorter.sortNames(names);

        assertNotNull(names);
        assertNotEquals(0, names.size());
    }
}