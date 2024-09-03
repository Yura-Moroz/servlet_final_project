package com.example.servlet_final_project.controller;

import com.example.servlet_final_project.entity.Question;
import com.example.servlet_final_project.service.DBJsonCreationService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Map;

import static org.mockito.Mockito.*;

class UserServletTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private HttpSession session;

    @Mock
    private RequestDispatcher dispatcher;

    @Mock
    private DBJsonCreationService jsonCreationService;

    @Mock
    private Map<Integer, Question> questionMap;

    private UserServlet userServlet;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userServlet = new UserServlet();
    }

    @Test
    void testDoPost_withValidUsername() throws Exception {
        when(request.getParameter("username")).thenReturn("testUser");
        when(request.getRemoteAddr()).thenReturn("127.0.0.1");
        when(request.getSession()).thenReturn(session);
        when(jsonCreationService.getQuestionMap()).thenReturn(questionMap);
        when(questionMap.get(1)).thenReturn(new Question());
        when(request.getRequestDispatcher("questions.jsp")).thenReturn(dispatcher);

        userServlet.doPost(request, response);

        verify(session).setAttribute("username", "testUser");
        verify(session).setAttribute("IPAddress", "127.0.0.1");
        verify(session).setAttribute("gamesCounter", 1);
        verify(dispatcher).forward(request, response);
    }

    @Test
    void testDoPost_withEmptyUsername() throws Exception {
        when(request.getParameter("username")).thenReturn("");

        userServlet.doPost(request, response);

        verify(response).sendRedirect("index.jsp");
    }

    @Test
    void testDoPost_withNullUsername() throws Exception {
        when(request.getParameter("username")).thenReturn(null);

        userServlet.doPost(request, response);

        verify(response).sendRedirect("index.jsp");
    }
}
