package com.silent.detector.service.searching;

import com.silent.detector.domain.enumeration.Gender;
import com.silent.detector.domain.model.GenderName;
import com.silent.detector.service.fileParse.TextParserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.silent.detector.config.Constants.FEMALE_FILE_NAME;
import static com.silent.detector.config.Constants.MALE_FILE_NAME;

@Service
public class OneNameSearchingServiceServiceImpl implements NameSearchingService {

    private final TextParserService textParserService;

    @Autowired
    public OneNameSearchingServiceServiceImpl(TextParserService textParserService) {
        this.textParserService = textParserService;
    }

    @Override
    public GenderName whatGenderIsName(String searchingName) {
        if(isItAvailableInTextFile(searchingName, FEMALE_FILE_NAME)) {
            return GenderName.builder().name(StringUtils.capitalize(searchingName)).gender(Gender.FEMALE).build();
        } else if (isItAvailableInTextFile(searchingName, MALE_FILE_NAME)) {
            return GenderName.builder().name(StringUtils.capitalize(searchingName)).gender(Gender.MALE).build();
        } else {
            return GenderName.builder().name(StringUtils.capitalize(searchingName)).gender(Gender.INCONCLUSIVE).build();
        }
    }

    private boolean isItAvailableInTextFile (String searchingName, String fileName) {
        return textParserService.parseText(fileName).stream()
                .parallel().anyMatch(searchingName.toLowerCase()::contains);
    }
}
