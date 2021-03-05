package com.silent.detector.service.repository;

import com.silent.detector.domain.enumeration.Gender;
import com.silent.detector.service.fileParse.TextParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.silent.detector.config.Constants.FEMALE_FILE_NAME;
import static com.silent.detector.config.Constants.MALE_FILE_NAME;

@Service
public class GenderNameRepository {

    private final TextParserService textParserService;

    @Autowired
    public GenderNameRepository(TextParserService textParserService) {
        this.textParserService = textParserService;
    }

    public Map<Gender,List<String>> fetchAllNamesByGender() {
        Map<Gender, List<String>> mapOfNamesByGender = new HashMap<>();
        mapOfNamesByGender.put(Gender.FEMALE, new ArrayList<>(textParserService.parseTextByLinesToListAsLowerCase(FEMALE_FILE_NAME)));
        mapOfNamesByGender.put(Gender.MALE, new ArrayList<>(textParserService.parseTextByLinesToListAsLowerCase(MALE_FILE_NAME)));
        return mapOfNamesByGender;
    }
}
