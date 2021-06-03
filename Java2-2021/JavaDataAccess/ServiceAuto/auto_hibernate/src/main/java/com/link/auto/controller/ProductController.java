package com.link.auto.controller;

import com.link.auto.dao.Product;
import com.link.auto.security.UserSession;
import com.link.auto.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    UserSession userSession;

    @GetMapping("/dashboard")
    public ModelAndView getDashboard(HttpServletRequest request) {
        ModelAndView dashboardView = new ModelAndView("dashboard.html");

        Object loggedIn = request.getSession().getAttribute("loggedIn");
        if (loggedIn == null || !(boolean)loggedIn) {
            return new ModelAndView("redirect:/login");
        }

//        int id = userSession.getId();
//        if (id == 0) {
//            return new ModelAndView("redirect:/login");
//        }

        List<Product> productList = productService.getAll();

        // setam addObject -> services
        dashboardView.addObject("services", productList);
        return dashboardView;
    }

    @GetMapping("/services/{id}")
    public ModelAndView getServiceById(@PathVariable Integer id, HttpServletRequest request) {
        Product dbProductElem = productService.getById(id);

        Object loggedIn = request.getSession().getAttribute("loggedIn");
        if (loggedIn == null || !(boolean)loggedIn) {
            return new ModelAndView("redirect:/login");
        }

//        int id = userSession.getId();
//        if (id == 0) {
//            return new ModelAndView("redirect:/login");
//        }

        // afisez intr-un template -> service.html
        // service.html -> div-uri cu titlu, descriere, pret
        ModelAndView serviceView = new ModelAndView("service.html");
        serviceView.addObject("serviceElem", dbProductElem);
        return serviceView;
    }
}
