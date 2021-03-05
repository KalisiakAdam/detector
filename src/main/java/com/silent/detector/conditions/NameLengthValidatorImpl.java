package com.silent.detector.conditions;

import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;

@Service
public class NameLengthValidatorImpl implements NameLengthValidator {

    @Override
    public boolean isOneName(String name) {
        return !StringUtils.containsWhitespace(name);
    }
}
