package com.example.servlet_final_project.repository;

import com.example.servlet_final_project.entity.Question;

import java.util.Map;

public interface Repository {
    void loadFromDB(String fileName);
    public Map<Integer, Question> getQuestionMap();
}
