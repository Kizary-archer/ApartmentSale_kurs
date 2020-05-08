package app.controllers;

import app.builder.AgentBuilder;
import app.builder.ClientBuilder;
import app.entities.AgentEntity;
import app.entities.ClientEntity;
import app.services.AgentService;
import app.services.ClientService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/listAgents","/addAgent","/delAgent","/updAgent","/viewAgent"})
public class AgentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        RequestDispatcher requestDispatcher = null;
        if(request.getServletPath().equals("/listAgents")) {
            requestDispatcher = request.getRequestDispatcher("view/listAgents.jsp");
        }
        if(request.getServletPath().equals("/addAgent")) {
            requestDispatcher = request.getRequestDispatcher("view/addAgent.jsp");
        }
        if(request.getServletPath().equals("/delAgent")) {
            requestDispatcher = request.getRequestDispatcher("view/viewAgent.jsp");
        }
        if(request.getServletPath().equals("/updAgent")) {
            requestDispatcher = request.getRequestDispatcher("view/viewAgent.jsp");
        }
        if(request.getServletPath().equals("/viewAgent")) {
            AgentService agentService = new AgentService();
            AgentEntity agentEntity = agentService.getAgentAllData(Integer.parseInt(request.getParameter("idAgent")));//получение определённого клиента из бд
            request.setAttribute("agent", agentEntity);
            requestDispatcher = request.getRequestDispatcher("view/viewAgent.jsp");
            }
        assert requestDispatcher != null;
        requestDispatcher.forward(request, response);
        }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        AgentService agentService = new AgentService();
        AgentEntity agentEntity = new AgentBuilder(request).build();
        if(request.getServletPath().equals("/addAgent")) {
            if (agentService.addAgent(agentEntity)) {
                request.setAttribute("isAgentAdded", "true");
            }
            else request.setAttribute("isAgentAdded", "false");
            doGet(request, response);
        }
        if(request.getServletPath().equals("/updAgent")) {
            if (agentService.updAgent(agentEntity)) {
                request.setAttribute("isAgentUpd", "true");
            }
            else {
                request.setAttribute("isAgentUpd", "false");
            }
            agentEntity = agentService.getAgentAllData(Integer.parseInt(request.getParameter("idAgent")));//получение определённого агента из бд
            request.setAttribute("agent", agentEntity);
            doGet(request,response);
        }
        if(request.getServletPath().equals("/delAgent")) {
            if (agentService.delAgent(agentEntity)) {
                request.setAttribute("isAgentdel", "true");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
                requestDispatcher.forward(request, response);
            }
            else {
                request.setAttribute("isAgentdel", "false");
                agentEntity = agentService.getAgentAllData(Integer.parseInt(request.getParameter("idAgent")));//получение определённого агента из бд
                request.setAttribute("agent", agentEntity);
                doGet(request, response);
            }
        }
        if(request.getServletPath().equals("/listAgents")) {
            List<AgentEntity> agentData = new ArrayList<>(agentService.getAgents(1000, 0, agentEntity));
            request.setAttribute("agents",agentData);
            doGet(request, response);
        }
    }
}


