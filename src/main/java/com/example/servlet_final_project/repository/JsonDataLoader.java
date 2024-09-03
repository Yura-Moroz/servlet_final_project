package com.example.servlet_final_project.repository;

import com.example.servlet_final_project.entity.Question;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Setter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@Setter
public class JsonDataLoader implements Repository {
    private String fileName;
    private Map<Integer, Question> questionMap;

    public JsonDataLoader(String fileName) {
        this.fileName = fileName;
        loadFromDB(fileName);
    }
    @Override
    public void loadFromDB(String fileName) {
        Map<Integer, Question> questions;

        try {
            ObjectMapper mapper = new ObjectMapper();

            InputStream inputStream = getClass().getResourceAsStream("/" + fileName);

            if (inputStream == null) {
                throw new FileNotFoundException("File not found: " + '\'' + fileName + '\'');
            }

            questions = mapper.readValue(inputStream,
                    mapper.getTypeFactory().constructMapType(Map.class, Integer.class, Question.class));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        setQuestionMap(questions);
    }


    @Override
    public Map<Integer, Question> getQuestionMap() {
        return questionMap;
    }

}