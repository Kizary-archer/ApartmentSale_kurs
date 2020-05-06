package app.controllers;

import app.builder.ClientBuilder;
import app.entities.ClientEntity;
import app.services.ClientService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;

@WebServlet(urlPatterns = {"/client","/addClient","/delClient","/updClient"})
public class ClientServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        RequestDispatcher requestDispatcher;
       String d =  request.getServletPath();
        if (request.getParameter("idClient") == null)//Добавление клиента
             requestDispatcher = request.getRequestDispatcher("view/addClient.jsp");
        else {//Вывод определённого клиента
            ClientService clientService = new ClientService();
            ClientEntity client = clientService.getClientAllData(Integer.parseInt(request.getParameter("idClient")));//получение определённого клиента из бд
            request.setAttribute("client", client);
             requestDispatcher = request.getRequestDispatcher("view/viewClient.jsp");
        }
        requestDispatcher.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        ClientService clientService = new ClientService();
        ClientEntity clientEntity = new ClientBuilder(request).buidl();
        Iterator<String> header = request.getParameterNames().asIterator();
       /* while(header.hasNext()){
            if(request.getParameter(header.next()).equals("")) {
                request.setAttribute("client", "не добавлен");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/addClient.jsp");
                requestDispatcher.forward(request, response);
            }
        }*/
        if(request.getServletPath().equals("/addClient")) {
            if (clientService.addClient(clientEntity)) {
                request.setAttribute("isClientAdded", "true");
            }
            else request.setAttribute("isClientAdded", "false");

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/addClient.jsp");
            requestDispatcher.forward(request, response);
        }
        if(request.getServletPath().equals("/updClient")) {
            if (clientService.updClient(clientEntity)) {
                request.setAttribute("isClientUpd", "true");
            }
            else {
                request.setAttribute("isClientUpd", "false");
            }
            doGet(request,response);
        }
    }
}


