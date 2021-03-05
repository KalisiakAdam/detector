package com.silent.detector.service.genderDetector;

import com.silent.detector.domain.model.GenderName;
import com.silent.detector.service.engine.ChooseSearchEngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GenderDetectorServiceImpl implements GenderDetectorService {

    private final ChooseSearchEngineService chooseSearchEngineService;

    @Autowired
    public GenderDetectorServiceImpl(ChooseSearchEngineService chooseSearchEngineService) {
        this.chooseSearchEngineService = chooseSearchEngineService;
    }

    @Override
    public GenderName getNameWithGender(String name) {
        return chooseSearchEngineService.whatIsNameGender(name);
    }

    @Override
    public List<GenderName> getListOfAllNamesWithGender() {
        return null;
    }
}
