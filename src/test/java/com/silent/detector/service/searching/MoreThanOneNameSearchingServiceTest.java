package com.silent.detector.service.searching;

import com.silent.detector.domain.enumeration.Gender;
import com.silent.detector.domain.model.GenderName;
import com.silent.detector.service.fileParse.TextParserService;
import com.silent.detector.service.fileParse.TextParserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MoreThanOneNameSearchingServiceTest {

    private final TextParserService textParserService = new TextParserServiceImpl();
    private final NameSearchingService nameSearchingService = new MoreThanOneNameSearchingServiceServiceImpl(textParserService);

    @Test
    public void testReturnFemaleGenderInMoreThanOneFemaleNames(){
        // arrange
        String searchingName = "Ula Ania";

        //act
        GenderName namesWithGender = nameSearchingService.whatGenderIsName(searchingName);

        //assert
        Assertions.assertEquals(namesWithGender, GenderName.builder().name("Ula Ania").gender(Gender.FEMALE).build());
    }

    @Test
    public void testReturnMaleGenderInMoreThanOneFemaleNames(){
        // arrange
        String searchingName = "Piotr Jan";

        //act
        GenderName namesWithGender = nameSearchingService.whatGenderIsName(searchingName);

        //assert
        Assertions.assertEquals(namesWithGender, GenderName.builder().name("Piotr Jan").gender(Gender.MALE).build());
    }

    @Test
    public void testReturnInconclusiveGenderInMoreThanOneFemaleNames(){
        // arrange
        String searchingName = "Piotr Jan Zenon";

        //act
        GenderName namesWithGender = nameSearchingService.whatGenderIsName(searchingName);

        //assert
        Assertions.assertEquals(namesWithGender, GenderName.builder().name("Piotr Jan Zenon").gender(Gender.INCONCLUSIVE).build());
    }

    @Test
    public void testReturnFemaleGenderWhenIsOneMaleNameInMoreThanOneFemaleNames(){
        // arrange
        String searchingName = "Ula Ania Piotr";

        //act
        GenderName namesWithGender = nameSearchingService.whatGenderIsName(searchingName);

        //assert
        Assertions.assertEquals(namesWithGender, GenderName.builder().name("Ula Ania Piotr").gender(Gender.FEMALE).build());
    }

    @Test
    public void testReturnMaleGenderWhenIsOneFemaleNameInMoreThanOneFemaleNames(){
        // arrange
        String searchingName = "Piotr Ula Jan";

        //act
        GenderName namesWithGender = nameSearchingService.whatGenderIsName(searchingName);

        //assert
        Assertions.assertEquals(namesWithGender, GenderName.builder().name("Piotr Ula Jan").gender(Gender.MALE).build());
    }
}
