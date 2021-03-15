package com.silent.detector.service.searching;

import com.silent.detector.domain.enumeration.Gender;
import com.silent.detector.domain.model.GenderName;
import com.silent.detector.service.fileParse.TextParserService;
import com.silent.detector.service.fileParse.TextParserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OneNameSearchingServiceServiceTest {

    private final TextParserService textParserService = new TextParserServiceImpl();
    private final NameSearchingService nameSearchingService = new OneNameSearchingServiceServiceImpl(textParserService);

    @Test
    public void testReturnFemaleGender(){
        // arrange
        String searchingName = "Ula";

        //act
        GenderName nameWithGender = nameSearchingService.whatGenderIsName(searchingName);

        //assert
        Assertions.assertEquals(nameWithGender, GenderName.builder().name("Ula").gender(Gender.FEMALE).build());
    }

    @Test
    public void testReturnMaleGender(){
        // arrange
        String searchingName = "Marcin";

        //act
        GenderName nameWithGender = nameSearchingService.whatGenderIsName(searchingName);

        //assert
        Assertions.assertEquals(nameWithGender, GenderName.builder().name("Marcin").gender(Gender.MALE).build());
    }

    @Test
    public void testReturnInconclusiveGender(){
        // arrange
        String searchingName = "Tomasz";

        //act
        GenderName nameWithGender = nameSearchingService.whatGenderIsName(searchingName);

        //assert
        Assertions.assertEquals(nameWithGender, GenderName.builder().name("Tomasz").gender(Gender.INCONCLUSIVE).build());
    }
}
