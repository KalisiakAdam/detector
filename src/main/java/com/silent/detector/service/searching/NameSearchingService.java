package com.silent.detector.service.searching;

import com.silent.detector.domain.model.GenderName;

public interface NameSearchingService {
    GenderName whatGenderIsName(String searchingName);
}
