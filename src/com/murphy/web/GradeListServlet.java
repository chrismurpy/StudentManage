package com.murphy.web;

import com.murphy.bean.Grade;
import com.murphy.service.GradeService;
import com.murphy.service.impl.GradeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author murphy
 */
@WebServlet("/Educational/student/getGradeList")
public class GradeListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 查询年级列表
        GradeService gradeService = new GradeServiceImpl();
        List<Grade> list = gradeService.getList();
        req.setAttribute("glist",list);
        req.getRequestDispatcher("add.jsp").forward(req,resp);
    }
}
