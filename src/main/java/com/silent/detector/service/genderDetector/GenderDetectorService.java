package com.silent.detector.service.genderDetector;

import com.silent.detector.domain.model.GenderName;

import java.util.List;

public interface GenderDetectorService {
    GenderName getNameWithGender(String name);
    List<GenderName> getListOfAllNamesWithGender();
}
