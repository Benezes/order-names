package com.mnz.service;

import com.mnz.service.exception.ExtractNameException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NameExtractorTest {

    private INameExtractor extractor;

    @BeforeEach
    void setUp() {
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
    void testExtractNamesToList(String filePath) {
        List<String> names = extractor.extractNamesToList(filePath);
        assertNotNull(names);
        assertNotEquals(0, names.size());
    }

    @ParameterizedTest
    @ValueSource(strings = "src/test/java/com/mnz/service/unsorted-names-tests/non_existent_file.txt")
    void testExtractNamesToListAndExpectException(String filePath) {
        INameExtractor mockExtractor = Mockito.mock(INameExtractor.class);
        Mockito.when(mockExtractor.extractNamesToList(filePath)).thenThrow(ExtractNameException.class);
        assertThrows(ExtractNameException.class, () -> mockExtractor.extractNamesToList(filePath));
    }

}