package com.murphy.web;

import com.murphy.bean.Student;
import com.murphy.service.StudentService;
import com.murphy.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author murphy
 */
@WebServlet("/Educational/student/validateServlet")
public class ValidateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        StudentService studentService = new StudentServiceImpl();
        // 1. 接收参数
        String stuNo = req.getParameter("stuNo");
        Student student = studentService.findByStuNo(stuNo);
        PrintWriter writer = resp.getWriter();

        if (stuNo != null && stuNo != ""){
            if (student.getStuNo() != null){
                if (student.getStuNo().equals(stuNo)){
                    writer.println("该学号已被注册！");
                } else {
                    writer.println("恭喜！该学号可用");
                }
            }
            else {
                writer.println("恭喜！该学号可用");
            }
        }
        else {
            writer.println("学号不能为空！");
        }
    }
}
