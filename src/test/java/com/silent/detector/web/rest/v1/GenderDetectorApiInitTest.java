package com.silent.detector.web.rest.v1;

import com.silent.detector.DetectorApplication;
import com.silent.detector.domain.enumeration.Gender;
import com.silent.detector.domain.model.GenderName;
import com.silent.detector.service.genderDetector.GenderDetectorService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DetectorApplication.class)
public class GenderDetectorApiInitTest {

    @Mock
    private GenderDetectorService genderDetectorService;

    @Autowired
    private HttpMessageConverter<?>[] httpMessageConverters;

    private MockMvc restMvc;

    @Before
    public void setup() {

        GenderDetectorApi genderDetectorApi = new GenderDetectorApi(genderDetectorService);

        this.restMvc = MockMvcBuilders.standaloneSetup(genderDetectorApi)
                .setMessageConverters(httpMessageConverters)
                .build();

        GenderName genderName = GenderName.builder().name("Adam").gender(Gender.MALE).build();
        when(genderDetectorService.getNameWithGender(any()))
                .thenReturn(genderName);
    }

    @Test
    public void testGetNameWithGender() throws Exception {
        restMvc.perform(get("/api/v1/gender-detector/Adam")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(genderDetectorService, times(1)).getNameWithGender("Adam");
    }
}
