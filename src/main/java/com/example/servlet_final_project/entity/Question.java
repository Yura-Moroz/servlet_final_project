package com.example.servlet_final_project.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
public class Question {
    private Integer id;
    private String text;
    private List<Answer> answers;
    private int nextQuestionID;

    @JsonCreator
    public Question(@JsonProperty("id") Integer id, @JsonProperty("questionText") String text, @JsonProperty("answers") List<Answer> answers, @JsonProperty("nextQuestionID") int nextQuestionID) {
        this.id = id;
        this.text = text;
        this.answers = answers;
        this.nextQuestionID = nextQuestionID;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", answers=" + answers +
                ", nextQuestionID=" + nextQuestionID +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return nextQuestionID == question.nextQuestionID && Objects.equals(id, question.id) && Objects.equals(text, question.text) && Objects.equals(answers, question.answers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, answers, nextQuestionID);
    }
}
