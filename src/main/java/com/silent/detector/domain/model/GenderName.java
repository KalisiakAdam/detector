package com.silent.detector.domain.model;

import com.silent.detector.domain.enumeration.Gender;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GenderName {
    private String name;
    private Gender gender;
}
