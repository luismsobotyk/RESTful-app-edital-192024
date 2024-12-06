package com.example.restfulappedital192024;

import com.example.restfulappedital192024.controller.PublicationController;
import com.example.restfulappedital192024.model.Publication;
import com.example.restfulappedital192024.services.PublicationServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Collections;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class PublicationControllerTest {

    @Mock
    private PublicationServices service;

    @InjectMocks
    private PublicationController controller;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void testFindByDOI() throws Exception {
        String doi = "10.1080/16549716.2024.2330758";
        Publication publication = new Publication();
        publication.setDoi(doi);

        when(service.findByDOI(doi)).thenReturn(publication);

        mockMvc.perform(get("/findByDoi")
                        .param("doi", doi))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.doi").value(doi));

        verify(service, times(1)).findByDOI(doi);
    }

    @Test
    void testFindByYear() throws Exception {
        int year = 2024;
        Publication publication = new Publication();
        publication.setPublicationYear(year);
        when(service.findByPublicationYear(year)).thenReturn(Collections.singletonList(publication));

        mockMvc.perform(get("/findByYear/{year}", year))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].year").value(year));

        verify(service, times(1)).findByPublicationYear(year);
    }

    @Test
    void testFindByYear_NoResults() throws Exception {
        int year = 2025;
        when(service.findByPublicationYear(year)).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/findByYear/{year}", year))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Nenhuma publicação encontrada para o ano informado!"))
                .andExpect(jsonPath("$.details").value("uri=/findByYear/2025"))
                .andExpect(jsonPath("$.timestamp").exists());

        verify(service, times(1)).findByPublicationYear(year);
    }

    @Test
    void testCreate() throws Exception {
        Publication publication = new Publication();
        when(service.create()).thenReturn(publication);

        mockMvc.perform(get("/create"))
                .andExpect(status().isOk());

        verify(service, times(1)).create();
    }
}