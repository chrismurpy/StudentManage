package com.murphy.web;

import com.murphy.bean.Grade;
import com.murphy.bean.Student;
import com.murphy.service.GradeService;
import com.murphy.service.StudentService;
import com.murphy.service.impl.GradeServiceImpl;
import com.murphy.service.impl.StudentServiceImpl;

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
@WebServlet("/Educational/student/findById")
public class FindByIdServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sid = req.getParameter("sid");
        StudentService studentService = new StudentServiceImpl();
        Student student = studentService.findById(Integer.parseInt(sid));
        // 查询年级列表
        GradeService gradeService = new GradeServiceImpl();
        List<Grade> list = gradeService.getList();
        req.setAttribute("glist",list);
        req.setAttribute("stu",student);
        req.getRequestDispatcher("edit.jsp").forward(req,resp);
    }
}
