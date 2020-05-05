package app.controllers;

import app.entities.ClientEntity;
import app.services.ClientService;
import javassist.tools.rmi.Sample;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

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
        ClientEntity clientEntity = new ClientEntity();
        Iterator<String> header = request.getParameterNames().asIterator();
       /* while(header.hasNext()){
            if(request.getParameter(header.next()).equals("")) {
                request.setAttribute("client", "не добавлен");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/addClient.jsp");
                requestDispatcher.forward(request, response);
            }
        }*/
        if(request.getServletPath().equals("/addClient")) {
            if (!request.getParameter("name").isEmpty())
                clientEntity.setName(request.getParameter("name"));
            if (!request.getParameter("surname").isEmpty())
                clientEntity.setSurname(request.getParameter("surname"));
            if (!request.getParameter("patronymic").isEmpty())
                clientEntity.setPatronymic(request.getParameter("patronymic"));
            if (!request.getParameter("gender").isEmpty())
                clientEntity.setGender(Boolean.valueOf(request.getParameter("gender")));
            if (!request.getParameter("dateOfBirth").isEmpty())
                clientEntity.setDateOfBirth(Date.valueOf(request.getParameter("dateOfBirth")));
            if (!request.getParameter("phoneNumber").isEmpty())
                clientEntity.setPhoneNumber((request.getParameter("phoneNumber")));
            if (!request.getParameter("email").isEmpty())
                clientEntity.setEmail((request.getParameter("email")));

            if (clientService.addClient(clientEntity)) {
                request.setAttribute("isClientAdded", "true");
            } else request.setAttribute("isClientAdded", "false");

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/addClient.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}


