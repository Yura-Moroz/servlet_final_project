package com.example.servlet_final_project.repository;

import com.example.servlet_final_project.entity.Question;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class JsonDataLoaderTest {

    @Mock
    private ObjectMapper mockObjectMapper;

    @Mock
    private InputStream mockInputStream;

    private JsonDataLoader jsonDataLoader;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        jsonDataLoader = new JsonDataLoader("dummy.json");
    }

    @Test
    public void testLoadFromDBSuccess() throws Exception {
        Map<Integer, Question> mockQuestions = new HashMap<>();

        when(mockObjectMapper.readValue(any(InputStream.class),
                eq(mockObjectMapper.getTypeFactory().constructMapType(Map.class, Integer.class, Question.class))))
                .thenReturn(mockQuestions);

        when(getClass().getResourceAsStream("/dummy.json")).thenReturn(mockInputStream);

        jsonDataLoader.loadFromDB("dummy.json");

        assertNotNull(jsonDataLoader.getQuestionMap());
        assertEquals(mockQuestions, jsonDataLoader.getQuestionMap());
    }

    @Test
    public void testLoadFromDBFileNotFound() {
        when(getClass().getResourceAsStream("/dummy.json")).thenReturn(null);

        assertThrows(RuntimeException.class, () -> {
            jsonDataLoader.loadFromDB("dummy.json");
        });
    }
}

