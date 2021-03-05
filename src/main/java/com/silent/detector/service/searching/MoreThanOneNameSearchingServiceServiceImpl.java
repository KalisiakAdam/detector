package com.silent.detector.service.searching;

import com.silent.detector.domain.enumeration.Gender;
import com.silent.detector.domain.model.GenderName;
import com.silent.detector.service.fileParse.TextParserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

@Service
public class MoreThanOneNameSearchingServiceServiceImpl extends OneNameSearchingServiceServiceImpl {

    public MoreThanOneNameSearchingServiceServiceImpl(TextParserService textParserService) {
        super(textParserService);
    }

    @Override
    public GenderName whatGenderIsName(String searchingName) {
        Map<Gender, Long> map = attachedGenderToName(searchingName).stream()
                .collect(groupingBy(GenderName::getGender, counting()));
        if(map.containsKey(Gender.INCONCLUSIVE)) {
            return GenderName.builder().name(capitalizeAllNames(searchingName)).gender(Gender.INCONCLUSIVE).build();
        } else if (!map.containsKey(Gender.FEMALE) ) {
            return GenderName.builder().name(capitalizeAllNames(searchingName)).gender(Gender.MALE).build();
        } else if (!map.containsKey(Gender.MALE) ) {
            return GenderName.builder().name(capitalizeAllNames(searchingName)).gender(Gender.FEMALE).build();
        } else if (map.get(Gender.MALE) > map.get(Gender.FEMALE)) {
            return GenderName.builder().name(capitalizeAllNames(searchingName)).gender(Gender.MALE).build();
        } else if (map.get(Gender.MALE) < map.get(Gender.FEMALE)) {
            return GenderName.builder().name(capitalizeAllNames(searchingName)).gender(Gender.FEMALE).build();
        } else {
            return GenderName.builder().name(searchingName).gender(Gender.INCONCLUSIVE).build();
        }
    }

    private List<String> splitNamesFromString(String name) {
        return Arrays.asList(StringUtils.split(name));
    }

    private List<GenderName> attachedGenderToName(String searchingName) {
            return splitNamesFromString(searchingName.toLowerCase()).stream()
                    .map(this::getNameAndGender)
                    .collect(Collectors.toList());
    }

    private String capitalizeAllNames(String name) {
        return splitNamesFromString(name).stream()
                .map(StringUtils::capitalize)
                .collect(Collectors.joining(" "));
    }
}
