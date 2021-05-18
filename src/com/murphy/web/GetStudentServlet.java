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
import java.util.List;

/**
 * @author murphy
 */
@WebServlet("/Educational/student/getStudentList")
public class GetStudentServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 获取参数
        String stuName = req.getParameter("stuName");
        System.out.println("1" + stuName);
        String stuNo = req.getParameter("stuNo");
        System.out.println("2" + stuNo);
        String sex = req.getParameter("sex");
        System.out.println("3" + sex);
        // 2. 调取Service方法
        StudentService service = new StudentServiceImpl();
        List<Student> students = service.getStudents(stuName,stuNo,Integer.parseInt(sex));
        // 3. 跳转页面
        // 若后台想给前台传数据，需要在后台存值
        req.setAttribute("stuList",students);
        // 存储模糊查询条件
        req.setAttribute("stuname",stuName);
        req.setAttribute("stuno",stuNo);
        req.setAttribute("sex",sex);
        req.getRequestDispatcher("list.jsp").forward(req,resp);
    }
}
