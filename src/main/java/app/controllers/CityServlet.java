package app.controllers;

import app.services.CityServices;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class CityServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/addCity.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String cityName = request.getParameter("cityName");
        CityServices cityServices = new CityServices();
        try {
            if(cityServices.addCity(cityName))request.setAttribute("cityName", cityName);
            else request.setAttribute("cityName", "не");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        doGet(request, response);
    }
}


