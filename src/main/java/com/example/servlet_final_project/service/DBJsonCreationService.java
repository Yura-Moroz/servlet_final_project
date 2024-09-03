package com.example.servlet_final_project.service;

import com.example.servlet_final_project.entity.Question;
import com.example.servlet_final_project.repository.JsonDataLoader;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class DBJsonCreationService {
    private String filePath;
    private JsonDataLoader loader;

    public DBJsonCreationService(String filePath) {
        this.filePath = filePath;
        loader = new JsonDataLoader(filePath);
    }

    public Map<Integer, Question> getQuestionMap() {
        return loader.getQuestionMap();
    }
}
