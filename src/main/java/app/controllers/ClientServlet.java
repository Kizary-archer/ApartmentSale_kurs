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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@WebServlet(urlPatterns = {"/listClients","/addClient","/delClient","/updClient","/viewClient"})
public class ClientServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        RequestDispatcher requestDispatcher = null;
        if(request.getServletPath().equals("/listClients")) {
            requestDispatcher = request.getRequestDispatcher("view/listClients.jsp");
        }
        if(request.getServletPath().equals("/addClient")) {
            requestDispatcher = request.getRequestDispatcher("view/addClient.jsp");
        }
        if(request.getServletPath().equals("/delClient")) {
            requestDispatcher = request.getRequestDispatcher("view/viewClient.jsp");
        }
        if(request.getServletPath().equals("/updClient")) {
            requestDispatcher = request.getRequestDispatcher("view/viewClient.jsp");
        }
        if(request.getServletPath().equals("/viewClient")) {
            ClientService clientService = new ClientService();
            ClientEntity client = clientService.getClientAllData(Integer.parseInt(request.getParameter("idClient")));//получение определённого клиента из бд
            request.setAttribute("client", client);
            requestDispatcher = request.getRequestDispatcher("view/viewClient.jsp");
            }
        assert requestDispatcher != null;
        requestDispatcher.forward(request, response);
        }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        ClientService clientService = new ClientService();
        ClientEntity clientEntity = new ClientBuilder(request).build();
       // Iterator<String> header = request.getParameterNames().asIterator();
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
            doGet(request, response);
        }
        if(request.getServletPath().equals("/updClient")) {
            if (clientService.updClient(clientEntity)) {
                request.setAttribute("isClientUpd", "true");
            }
            else {
                request.setAttribute("isClientUpd", "false");
            }
            clientEntity = clientService.getClientAllData(Integer.parseInt(request.getParameter("idClient")));//получение определённого клиента из бд
            request.setAttribute("client", clientEntity);
            doGet(request,response);
        }
        if(request.getServletPath().equals("/delClient")) {
            if (clientService.delClient(clientEntity)) {
                request.setAttribute("isClientdel", "true");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/listClients.jsp");
                requestDispatcher.forward(request, response);
            }
            else {
                request.setAttribute("isClientdel", "false");
                clientEntity = clientService.getClientAllData(Integer.parseInt(request.getParameter("idClient")));//получение определённого клиента из бд
                request.setAttribute("client", clientEntity);
                doGet(request, response);
            }
        }
        if(request.getServletPath().equals("/listClients")) {
            List<ClientEntity> clientData = new ArrayList<ClientEntity>(clientService.getClients(1000, 0,clientEntity));
            request.setAttribute("clients",clientData);
            doGet(request, response);
        }
    }
}


