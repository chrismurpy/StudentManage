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
@WebServlet("/Educational/student/addStu")
public class AddStuServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String stuNo = req.getParameter("stuNo");
        String stuName = req.getParameter("stuName");
        String gid = req.getParameter("gid");
        String sex = req.getParameter("sex");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String registered = req.getParameter("registered");
        String address = req.getParameter("address");
        String politics = req.getParameter("politics");
        String idNumber = req.getParameter("idNumber");
        String profession = req.getParameter("profession");
        String introduction = req.getParameter("introduction");
        // 调取Service
        StudentService studentService = new StudentServiceImpl();
        Student student = new Student();
        student.setStuNo(stuNo);
        student.setStuName(stuName);
        student.setGid(Integer.parseInt(gid));
        student.setSex(Integer.parseInt(sex));
        student.setEmail(email);
        student.setPhone(phone);
        student.setRegistered(registered);
        student.setAddress(address);
        student.setPolitics(politics);
        student.setIdNumber(idNumber);
        student.setProfession(profession);
        student.setIntroduction(introduction);

        // 将参数封装到学生对象中
        int i = studentService.insertStu(student);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        if (i>0){
            writer.println("<script>alert('新增成功');location.href='/Educational/student/getStudentList'</script>");
        } else {
            writer.println("<script>alert('新增失败');location.href='/Educational/student/getGradeList'</script>");
        }
    }
}
