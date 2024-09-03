package com.example.servlet_final_project.controller;

import com.example.servlet_final_project.entity.Answer;
import com.example.servlet_final_project.entity.Question;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Map;

@WebServlet(name = "questionServlet", value = "/question-servlet")
public class QuestionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Map<Integer, Question> questionMap = (Map<Integer, Question>) session.getAttribute("questionMap");
        Integer questionID = (Integer) session.getAttribute("questionID");

        if (questionMap == null || questionID == null) {
            resp.sendRedirect("/error.jsp");
            return;
        }

        String selectedAnswerIndex = req.getParameter("SQL_command");

        if (selectedAnswerIndex == null || selectedAnswerIndex.isEmpty()) {
            resp.sendRedirect("questions.jsp");
            return;
        }

        try {
            Question currentQuestion = questionMap.get(questionID);
            int answerIndex = Integer.parseInt(selectedAnswerIndex);
            Answer selectedAnswer = currentQuestion.getAnswers().get(answerIndex);

            if (selectedAnswer.isRight()) {
                if (currentQuestion.getNextQuestionID() == -1) {
                    resp.sendRedirect("/finish.jsp");
                    return;
                }

                session.setAttribute("question", questionMap.get(currentQuestion.getNextQuestionID()));
                session.setAttribute("questionID", currentQuestion.getNextQuestionID());
                resp.sendRedirect("questions.jsp");
            } else {
                resp.sendRedirect("/error.jsp");
            }
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            e.printStackTrace();
            resp.sendRedirect("/error.jsp");
        }
    }
}

