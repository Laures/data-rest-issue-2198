package com.example.demo.lombok;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class LombokExampleRepositoryTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    LombokExampleRepository lombokExampleRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void createExample() throws Exception {
        mockMvc.perform(post("/lombok-examples")
                        .content("""
                                {
                                "dataValue" : "test"
                                }
                                """))
                .andExpect(status().isCreated());
    }

    @Test
    void putExample() throws Exception {
        var lombokExample = lombokExampleRepository.save(LombokExample.builder()
                .dataValue("preTest")
                .build());

        mockMvc.perform(put("/lombok-examples/{id}", lombokExample.getId())
                        .content("""
                                {
                                "dataValue" : "test"
                                }
                                """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("dataValue").value("test"));
    }

    @Test
    void patchExampleExpected() throws Exception {
        var lombokExample = lombokExampleRepository.save(LombokExample.builder()
                .dataValue("preTest")
                .build());

        mockMvc.perform(patch("/lombok-examples/{id}", lombokExample.getId())
                        .content("""
                                {
                                "dataValue" : "test"
                                }
                                """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("dataValue").value("test"));
    }

    @Test
    void patchExampleCurrentError() throws Exception {
        var example = lombokExampleRepository.save(LombokExample.builder()
                .dataValue("preTest")
                .build());

        mockMvc.perform(patch("/lombok-examples/{id}", example.getId())
                        .content("""
                                {
                                "dataValue" : "test"
                                }
                                """))
                .andExpect(status().isBadRequest());

        // no update happened
        assertThat(example.getDataValue()).isEqualTo("preTest");
    }
}