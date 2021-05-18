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
        final int PAGE_SIZE = 5;
        // 1. 获取参数
        // 1.1 模糊查询条件
        String stuName = req.getParameter("stuName");
        String stuNo = req.getParameter("stuNo");
        String sex = req.getParameter("sex");
        // 1.2 分页数据 limit 开始位置,显示条数
        // 页码值(当前页码值)
        String pageIndex = req.getParameter("pageIndex");
        // 如果页面没有传入pageIndex的值,则认为默认查询第一页
        int index = pageIndex == null?1:Integer.parseInt(pageIndex);
        int uSex = (sex==null||sex.length()==0?-1:Integer.parseInt(sex));

        // 2. 调取Service方法
        StudentService service = new StudentServiceImpl();
        List<Student> students = service.getStudents(stuName,stuNo,uSex,index,PAGE_SIZE);
        // 获取总页数 = 总条数 % 每页显示的条数 > 0 ? 总条数 / 每页显示条数 + 1 : 总条数 / 每页显示条数
        // 总条数
        int total = service.total(stuName, stuNo, uSex);
        // 总页数
        int totalPages = total%PAGE_SIZE>0?(total/PAGE_SIZE+1):(total/PAGE_SIZE);

        // 3. 跳转页面
        // 若后台想给前台传数据，需要在后台存值
        req.setAttribute("stuList",students);

        // 存储模糊查询条件
        req.setAttribute("stuname",stuName);
        req.setAttribute("stuno",stuNo);
        req.setAttribute("sex",sex);

        // 存储分页数据
        req.setAttribute("index",index);
        req.setAttribute("size",PAGE_SIZE);
        req.setAttribute("total",total);
        req.setAttribute("totalPages",totalPages);


        req.getRequestDispatcher("list.jsp").forward(req,resp);
    }
}
