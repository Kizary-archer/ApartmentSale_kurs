package app.controllers;

import app.builder.ApartmentBuilder;
import app.builder.ApartmentSaleBuilder;
import app.builder.HouseViewBuilder;
import app.entities.ApartmentEntity;
import app.entities.ApartmentSaleEntity;
import app.entities.HouseView;
import app.services.ApartmentSaleService;
import app.services.ApartmentService;
import com.google.gson.Gson;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/addApartmentSale","/updApartmentSale","/viewApartmentSale","/delApartmentSale","/listApartmentSales"})
public class ApartmentSaleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        RequestDispatcher requestDispatcher = null;
        ApartmentSaleService apartmentSaleService = new ApartmentSaleService();
       if(request.getServletPath().equals("/listApartmentSales")) {
           requestDispatcher = request.getRequestDispatcher("view/listApartmentSales.jsp");
           requestDispatcher.forward(request, response);
       }
       /* if(request.getServletPath().equals("/addApartment")) {
            request.setAttribute("apartmentOwner", request.getParameter("idClient"));
            requestDispatcher = request.getRequestDispatcher("view/addApartment.jsp");
        }else { //вывод отпеделёной кв. или её обновление
            ApartmentEntity apartmentEntity = apartmentService.getApartmentAllChild(Integer.parseInt(request.getParameter("idApartment")));//получение определённой квартиры из бд
            request.setAttribute("apartment", apartmentEntity);
            requestDispatcher = request.getRequestDispatcher("view/viewApartment.jsp");
        }
        assert requestDispatcher != null;
        requestDispatcher.forward(request, response);*/
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        ApartmentSaleService apartmentSaleService = new ApartmentSaleService();
        ApartmentSaleEntity apartmentSaleEntity = null;
        try {
            apartmentSaleEntity = new ApartmentSaleBuilder(request).build();
        } catch (Exception e) {
            e.printStackTrace();
        }

      /* if(request.getServletPath().equals("/addApartment")) {
           if (apartmentService.addApartment(apartmentEntity)) {
               request.setAttribute("isApartmentAdded", "true");
           }
           else request.setAttribute("isApartmentAdded", "false");
           doGet(request, response);
        }

        if(request.getServletPath().equals("/searchHouse")) {
            HouseView houseView = null;
            try {
                houseView = new HouseViewBuilder(request).build();
            } catch (Exception e) {
                e.printStackTrace();
            }
            List<HouseView> houseEntityList = (List<HouseView>) apartmentService.getHouses(1000,0,houseView);
            String json = new Gson().toJson(houseEntityList);
            response.getWriter().write(json);
        }

        if(request.getServletPath().equals("/updApartment")) {
            if (apartmentService.updApartment(apartmentEntity)) {
                request.setAttribute("isApartmentUpd", "true");
            }
            else {
                request.setAttribute("isApartmentUpd", "false");
            }
            doGet(request,response);
        }
        if(request.getServletPath().equals("/delApartment")) {
            if (apartmentService.delApartment(apartmentEntity)) {
                request.setAttribute("isApartmentdel", "true");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
                requestDispatcher.forward(request, response);
            }
            else {
                request.setAttribute("isApartmentdel", "false");
                doGet(request, response);
            }
        }*/
        if(request.getServletPath().equals("/listApartmentSales")) {
            List<ApartmentSaleEntity> apartmentSaleEntityList = new ArrayList<ApartmentSaleEntity>(
                    apartmentSaleService.getApartmentSales(1000, 0,apartmentSaleEntity));
            request.setAttribute("apartmentSales",apartmentSaleEntityList);
            doGet(request, response);
        }
    }
}


