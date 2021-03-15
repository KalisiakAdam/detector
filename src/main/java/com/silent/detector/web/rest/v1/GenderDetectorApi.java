package com.silent.detector.web.rest.v1;

import com.silent.detector.domain.enumeration.Gender;
import com.silent.detector.domain.model.GenderName;
import com.silent.detector.exception.DetectorRuntimeException;
import com.silent.detector.service.genderDetector.GenderDetectorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(GenderDetectorApi.resource)
public class GenderDetectorApi {
    public static final String resource = ApiVersion.v1 + "/genders";
    private final Logger logger = LoggerFactory.getLogger(GenderDetectorApi.class);
    private final GenderDetectorService genderDetectorService;

    @Autowired
    public GenderDetectorApi(GenderDetectorService genderDetectorService) {
        this.genderDetectorService = genderDetectorService;
    }

    @GetMapping
    public ResponseEntity<Map<Gender,List<String>>> getAllNamesWithGender() {
        try {
            ResponseEntity<Map<Gender,List<String>>> responseEntity = ResponseEntity.ok(genderDetectorService.getListOfAllNamesWithGender());
            logger.info("REST request to get all names by gender");
            return responseEntity;
        } catch (DetectorRuntimeException exception) {
            logger.error("File with names not found or cannot be parsed");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "File with names not found or cannot be parsed", exception);
        }
    }

    @GetMapping("{name}")
    public ResponseEntity<GenderName> getOneNameWithGender(@PathVariable(name = "name") String name) {
        try {
            ResponseEntity<GenderName> responseEntity = ResponseEntity.ok(genderDetectorService.getNameWithGender(name));
            logger.info("REST request to get name gender by name: {} ", name);
            return responseEntity;
        } catch (DetectorRuntimeException exception) {
            logger.error("File with names not found or cannot be parsed");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "File with names not found or cannot be parsed", exception);
        }
    }
}
