package com.silent.detector.service.searching;

import com.silent.detector.domain.model.GenderName;
import com.silent.detector.service.fileParse.TextParserService;
import org.springframework.stereotype.Service;

@Service
public class MoreThanOneNameSearchingServiceServiceImpl extends OneNameSearchingServiceServiceImpl {

    public MoreThanOneNameSearchingServiceServiceImpl(TextParserService textParserService) {
        super(textParserService);
    }

    @Override
    public GenderName whatGenderIsName(String searchingName) {

        return null;
    }
}
