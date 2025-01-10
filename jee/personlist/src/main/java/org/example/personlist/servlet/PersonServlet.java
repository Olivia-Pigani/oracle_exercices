package org.example.personlist.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.personlist.model.Person;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "person", urlPatterns = "/personlist")
public class PersonServlet extends HttpServlet {

    List<Person> personList = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        LocalDate birthDate = LocalDate.parse(req.getParameter("birthDate"));

        Person newPerson = new Person(firstName,lastName,birthDate);

        personList.add(newPerson);

        resp.sendRedirect(req.getContextPath() + "/personList");

    }

    private void personsList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("personsList", personList);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }


}
