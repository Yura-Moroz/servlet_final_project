package com.example.servlet_final_project.controller;

import com.example.servlet_final_project.entity.Answer;
import com.example.servlet_final_project.entity.Question;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.*;

class QuestionServletTest {

    private QuestionServlet questionServlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;

    private Map<Integer, Question> questionMap;
    private Question question;

    @BeforeEach
    void setUp() {
        questionServlet = new QuestionServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        session = mock(HttpSession.class);

        when(request.getSession()).thenReturn(session);
    }

    @BeforeEach
    void initialize(){
        questionMap = new HashMap<>();
        question = new Question();
        question.setId(1);
        question.setAnswers(List.of(new Answer(), new Answer()));
        question.setNextQuestionID(2);
        questionMap.put(1, question);
    }

    @Test
    void testDoPostCorrectAnswer() throws Exception {
        Answer correctAnswer = new Answer();
        correctAnswer.setRight(true);
        question.setAnswers(List.of(correctAnswer, new Answer()));
        question.setNextQuestionID(-1);

        when(session.getAttribute("questionMap")).thenReturn(questionMap);
        when(session.getAttribute("questionID")).thenReturn(1);
        when(request.getParameter("SQL_command")).thenReturn("0");

        questionServlet.doPost(request, response);

        verify(response).sendRedirect("/finish.jsp");
    }

    @Test
    void testDoPostIncorrectAnswer() throws Exception {
        Answer incorrectAnswer = new Answer();
        incorrectAnswer.setRight(false);
        question.setAnswers(List.of(incorrectAnswer, new Answer()));

        when(session.getAttribute("questionMap")).thenReturn(questionMap);
        when(session.getAttribute("questionID")).thenReturn(1);
        when(request.getParameter("SQL_command")).thenReturn("0");

        questionServlet.doPost(request, response);

        verify(response).sendRedirect("/error.jsp");
    }

    @Test
    void testDoPostNoQuestionID() throws Exception {
        when(session.getAttribute("questionMap")).thenReturn(null);
        when(session.getAttribute("questionID")).thenReturn(null);

        questionServlet.doPost(request, response);

        verify(response).sendRedirect("/error.jsp");
    }

    @Test
    void testDoPostNoSelectedAnswer() throws Exception {
        when(session.getAttribute("questionMap")).thenReturn(questionMap);
        when(session.getAttribute("questionID")).thenReturn(1);
        when(request.getParameter("SQL_command")).thenReturn(null);

        questionServlet.doPost(request, response);

        verify(response).sendRedirect("questions.jsp");
    }

    @Test
    void testDoPostNumberFormatException() throws Exception {
        when(session.getAttribute("questionMap")).thenReturn(questionMap);
        when(session.getAttribute("questionID")).thenReturn(1);
        when(request.getParameter("SQL_command")).thenReturn("invalid");

        questionServlet.doPost(request, response);

        verify(response).sendRedirect("/error.jsp");
    }
}
