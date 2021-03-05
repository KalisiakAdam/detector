package com.silent.detector.service.engine;

import com.silent.detector.conditions.NameLengthValidator;
import com.silent.detector.domain.model.GenderName;
import com.silent.detector.service.searching.NameSearching;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Service;

@Service
public class ChooseSearchEngineServiceImpl implements ChooseSearchEngineService {

    private final NameLengthValidator nameLengthValidator;
    private final NameSearching oneNameSearchingService;
    private final NameSearching multipleNameSearchingService;

    public ChooseSearchEngineServiceImpl(NameLengthValidator nameLengthValidator,
                                         @Qualifier("oneNameSearchingServiceImpl") NameSearching oneNameSearchingService,
                                         @Qualifier("multipleNameSearchingServiceImpl") NameSearching multipleNameSearchingService) {
        this.nameLengthValidator = nameLengthValidator;
        this.oneNameSearchingService = oneNameSearchingService;
        this.multipleNameSearchingService = multipleNameSearchingService;
    }

    public GenderName whatIsNameGender(String name) {
        if(nameLengthValidator.isOneName(name)){
            return oneNameSearchingService.whatGenderIsName(name);
        } else {
            return multipleNameSearchingService.whatGenderIsName(name);
        }
    }
}
