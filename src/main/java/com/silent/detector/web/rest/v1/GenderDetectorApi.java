package com.silent.detector.web.rest.v1;

import com.silent.detector.domain.model.GenderName;
import com.silent.detector.service.genderDetector.GenderDetectorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(GenderDetectorApi.resource)
public class GenderDetectorApi {
    public static final String resource = ApiVersion.v1 + "/gender-detector";
    private final Logger logger = LoggerFactory.getLogger(GenderDetectorApi.class);
    private final GenderDetectorService genderDetectorService;

    @Autowired
    public GenderDetectorApi(GenderDetectorService genderDetectorService) {
        this.genderDetectorService = genderDetectorService;
    }

    @GetMapping
    public ResponseEntity<List<GenderName>> getAllNamesWithGender() {
        logger.info("REST request to get all names with gender");
        return ResponseEntity.ok(genderDetectorService.getListOfAllNamesWithGender());
    }

    @GetMapping("{name}")
    public ResponseEntity<GenderName> getNameWithGender(@PathVariable(name = "name") String name) {
        logger.info("REST request to get name gender by name: {} ", name);
        return ResponseEntity.ok(genderDetectorService.getNameWithGender(name));
    }
}
