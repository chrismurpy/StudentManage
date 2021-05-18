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
import java.io.PrintWriter;
import java.util.List;

/**
 * @author murphy
 */
@WebServlet("/Educational/student/deleteById")
public class DeleteByIdServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String sid = req.getParameter("sid");
        // 根据主键查询学生信息
        StudentService studentService = new StudentServiceImpl();
        int i = studentService.deleteStu(sid);

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        if (i>0){
            writer.println("<script>alert('删除成功');location.href='/Educational/student/getStudentList'</script>");
        } else {
            writer.println("<script>alert('删除失败');location.href='/Educational/student/getStudentList'</script>");
        }
    }
}
