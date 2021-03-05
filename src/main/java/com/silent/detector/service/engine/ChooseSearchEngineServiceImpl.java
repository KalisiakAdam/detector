package com.silent.detector.service.engine;

import com.silent.detector.conditions.NameLengthValidator;
import com.silent.detector.domain.model.GenderName;
import com.silent.detector.service.searching.NameSearchingService;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Service;

@Service
public class ChooseSearchEngineServiceImpl implements ChooseSearchEngineService {

    private final NameLengthValidator nameLengthValidator;
    private final NameSearchingService oneNameSearchingServiceService;
    private final NameSearchingService multipleNameSearchingServiceService;

    public ChooseSearchEngineServiceImpl(NameLengthValidator nameLengthValidator,
                                         @Qualifier("oneNameSearchingServiceServiceImpl") NameSearchingService oneNameSearchingServiceService,
                                         @Qualifier("moreThanOneNameSearchingServiceServiceImpl") NameSearchingService multipleNameSearchingServiceService) {
        this.nameLengthValidator = nameLengthValidator;
        this.oneNameSearchingServiceService = oneNameSearchingServiceService;
        this.multipleNameSearchingServiceService = multipleNameSearchingServiceService;
    }

    public GenderName whatIsNameGender(String name) {
        if(nameLengthValidator.isOneName(name)){
            return oneNameSearchingServiceService.whatGenderIsName(name);
        } else {
            return multipleNameSearchingServiceService.whatGenderIsName(name);
        }
    }
}
