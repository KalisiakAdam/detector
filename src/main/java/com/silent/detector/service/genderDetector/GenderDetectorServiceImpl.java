package com.silent.detector.service.genderDetector;

import com.silent.detector.domain.enumeration.Gender;
import com.silent.detector.domain.model.GenderName;
import com.silent.detector.service.engine.ChooseSearchEngineService;
import com.silent.detector.service.repository.GenderNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class GenderDetectorServiceImpl implements GenderDetectorService {

    private final ChooseSearchEngineService chooseSearchEngineService;
    private final GenderNameRepository genderNameRepository;

    @Autowired
    public GenderDetectorServiceImpl(ChooseSearchEngineService chooseSearchEngineService, GenderNameRepository genderNameRepository) {
        this.chooseSearchEngineService = chooseSearchEngineService;
        this.genderNameRepository = genderNameRepository;
    }

    @Override
    public GenderName getNameWithGender(String name) {
        return chooseSearchEngineService.whatIsNameGender(name);
    }

    @Override
    public Map<Gender,List<String>> getListOfAllNamesWithGender() {
        return genderNameRepository.fetchAllNamesByGender();
    }
}
