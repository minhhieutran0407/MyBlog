package hust.hieutm.controller;

import hust.hieutm.dao.BlogDao;
import hust.hieutm.daoImpl.BlogDaoImpl;
import hust.hieutm.model.Blog;
import hust.hieutm.model.Skill;
import hust.hieutm.service.*;
import jdk.nashorn.internal.ir.Block;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class HomeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");

        req.setAttribute("blogList", new BlogService().getAllBlog());
        req.setAttribute("info", new InfoService().getInfo());
        req.setAttribute("overview", new OverviewSerivce().getOverview());
        req.setAttribute("productList", new ProductService().getAllProduct());
        req.setAttribute("serviceList", new ServiceExecute().getAllService());
        req.setAttribute("skillList", new SkillService().getAllSkill());

        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");

        Skill skill = new Skill("hello", "90%");
        req.setAttribute("skill", skill);

        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("test.jsp");
        dispatcher.forward(req, resp);
    }
}
