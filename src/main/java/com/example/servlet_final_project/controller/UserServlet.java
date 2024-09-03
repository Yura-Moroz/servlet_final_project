package com.example.servlet_final_project.controller;

import java.io.*;
import java.util.Map;

import com.example.servlet_final_project.entity.Question;
import com.example.servlet_final_project.service.DBJsonCreationService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "mainPage", value = "/start")
public class UserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String IPAddress = req.getRemoteAddr();
        HttpSession session = req.getSession();

        if (username != null && !username.trim().isEmpty()) {
            DBJsonCreationService jsonCreationService = new DBJsonCreationService("questionMap.json");
            Map<Integer, Question> questions = jsonCreationService.getQuestionMap();
            Question question = questions.get(1);

            session.setAttribute("username", username);
            session.setAttribute("IPAddress", IPAddress);

            Integer gamesPlayed = (Integer) session.getAttribute("gamesCounter");
            if (gamesPlayed == null) {
                gamesPlayed = 0;
            }
            gamesPlayed++;
            session.setAttribute("gamesCounter", gamesPlayed);

            session.setAttribute("questionID", 1);
            session.setAttribute("questionMap", questions);
            session.setAttribute("question", question);

            req.getRequestDispatcher("questions.jsp").forward(req, resp);

        } else {
            resp.sendRedirect("index.jsp");
        }
    }
}
