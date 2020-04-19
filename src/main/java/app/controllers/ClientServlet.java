package app.controllers;

import app.services.CityServices;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

public class ClientServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/addClient.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        ArrayList<String> clientData = new ArrayList<String>();
        Iterator<String> header = request.getParameterNames().asIterator();
        while(request.getParameterNames().asIterator().hasNext()){
            clientData.add(header.next());
        }
       /* for (String head :header){
            System.out.println(head);
        }
        CityServices cityServices = new CityServices();
        try {
            if(cityServices.addCity())request.setAttribute("cityName", cityName);
            else request.setAttribute("cityName", "не");
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        doGet(request, response);
    }
}


