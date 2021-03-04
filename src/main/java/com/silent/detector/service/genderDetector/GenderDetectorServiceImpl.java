package com.silent.detector.service.genderDetector;

import com.silent.detector.domain.model.GenderName;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenderDetectorServiceImpl implements GenderDetectorService {
    @Override
    public GenderName getNameWithGender(String name) {
        return null;
    }

    @Override
    public List<GenderName> getListOfAllNamesWithGender() {
        return null;
    }
}
