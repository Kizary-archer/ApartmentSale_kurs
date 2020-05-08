package app.controllers;

import app.builder.ClientBuilder;
import app.builder.DocumentBuilder;
import app.entities.ClientEntity;
import app.entities.DocumentTypeEntity;
import app.entities.DocumentsClientEntity;
import app.services.ClientService;
import app.services.DocumentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/addDocument","/delDocument","/updDocument","/viewDocument"})
public class DocumentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        RequestDispatcher requestDispatcher = null;
        DocumentService documentService = new DocumentService();
        if(request.getServletPath().equals("/addDocument")) {
            request.setAttribute("idClient", request.getParameter("idClient"));
            List<DocumentTypeEntity> documentTypeEntityList = (List<DocumentTypeEntity>) documentService.getDocumentType(0,0);
            request.setAttribute("documentTypeEntityList", documentTypeEntityList);
            requestDispatcher = request.getRequestDispatcher("view/addDocument.jsp");
        }else { //вывод отпеделённого док. или его обновление
            DocumentsClientEntity documentsClientEntity = documentService.getDocumentById(Integer.parseInt(request.getParameter("idDocument")));//получение определённого документа из бд
            request.setAttribute("documentClient", documentsClientEntity);
            List<DocumentTypeEntity> documentTypeEntityList = (List<DocumentTypeEntity>) documentService.getDocumentType(0,0);
            request.setAttribute("documentTypeEntityList", documentTypeEntityList);
            requestDispatcher = request.getRequestDispatcher("view/viewDocument.jsp");
        }
        assert requestDispatcher != null;
        requestDispatcher.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        DocumentService documentService = new DocumentService();
        DocumentsClientEntity documentsClientEntity = null;
        try {
            documentsClientEntity = new DocumentBuilder(request).build();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(request.getServletPath().equals("/addDocument")) {
            if (documentService.addDocument(documentsClientEntity)) {
                request.setAttribute("isDocumentAdded", "true");
            }
            else request.setAttribute("isDocumentAdded", "false");
            doGet(request, response);
        }

        if(request.getServletPath().equals("/updDocument")) {
            if (documentService.updDocument(documentsClientEntity)) {
                request.setAttribute("isDocumentUpd", "true");
            }
            else {
                request.setAttribute("isDocumentUpd", "false");
            }
            doGet(request,response);
        }
        if(request.getServletPath().equals("/delDocument")) {
            if (documentService.delDocument(documentsClientEntity)) {
                request.setAttribute("isDocumentdel", "true");
                request.setAttribute("idClient",request.getParameter("client"));
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/viewClient.jsp");
                requestDispatcher.forward(request, response);
            }
            else {
                request.setAttribute("isDocumentdel", "false");
                doGet(request, response);
            }
        }
       /* if(request.getServletPath().equals("/delClient")) {
            if (clientService.delClient(clientEntity)) {
                request.setAttribute("isClientdel", "true");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/listClients.jsp");
                requestDispatcher.forward(request, response);
            }
            else {
                request.setAttribute("isClientdel", "false");
                doGet(request, response);
            }
        }
        if(request.getServletPath().equals("/listClients")) {
            List<ClientEntity> clientData = new ArrayList<ClientEntity>(clientService.getClients(1000, 0,clientEntity));
            request.setAttribute("clients",clientData);
            doGet(request, response);
        }*/
    }
}


