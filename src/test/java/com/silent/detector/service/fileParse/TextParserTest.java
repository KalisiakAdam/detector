package com.silent.detector.service.fileParse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

import static com.silent.detector.config.Constants.FEMALE_FILE_NAME;

public class TextParserTest {

    private final TextParserServiceImpl textParserService = new TextParserServiceImpl();

    @Test
    public void testParseTextByLineFromFileToLowerCase() {
        // arrange
        String fileName = FEMALE_FILE_NAME;

        //act
        List<String> listOfNames = textParserService.parseTextByLinesToListAsLowerCase(fileName);

        //assert
        Assertions.assertEquals(listOfNames.get(0), "ania");
    }
}
