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
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@WebServlet("/listClients")
public class listClientServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/listClients.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        ClientService clientService = new ClientService();
        ClientEntity clientEntity = new  ClientBuilder(request).buidl();
        List<ClientEntity> clientData = new ArrayList<ClientEntity>(clientService.getClients(1000, 0,clientEntity));
        request.setAttribute("clients",clientData);
        doGet(request, response);
    }
}


