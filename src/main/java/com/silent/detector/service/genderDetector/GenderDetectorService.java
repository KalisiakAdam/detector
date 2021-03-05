package com.silent.detector.service.genderDetector;

import com.silent.detector.domain.enumeration.Gender;
import com.silent.detector.domain.model.GenderName;

import java.util.List;
import java.util.Map;

public interface GenderDetectorService {
    GenderName getNameWithGender(String name);
    Map<Gender,List<String>> getListOfAllNamesWithGender();
}
