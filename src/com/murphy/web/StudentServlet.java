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
@WebServlet("/Educational/student/studentServlet")
public class StudentServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if ("insert".equals(method)){
            insert(req, resp);
        } else if ("update".equals(method)){
            update(req, resp);
        } else if ("findById".equals(method)){
            findById(req, resp);
        } else if ("delete".equals(method)){
            deleteStu(req, resp);
        } else {
            findList(req, resp);
        }
    }

    /**
     * 删除学员
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteStu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sid = req.getParameter("sid");
        // 根据主键查询学生信息
        StudentService studentService = new StudentServiceImpl();
        int i = studentService.deleteStu(sid);

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        if (i>0){
            writer.println("<script>alert('删除成功');location.href='/Educational/student/studentServlet'</script>");
        } else {
            writer.println("<script>alert('删除失败');location.href='/Educational/student/studentServlet'</script>");
        }
    }

    /**
     * 新增学员
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void insert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
            writer.println("<script>alert('新增成功');location.href='/Educational/student/studentServlet'</script>");
        } else {
            writer.println("<script>alert('新增失败');location.href='/Educational/student/getGradeList'</script>");
        }
    }

    /**
     * 主键查询
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void findById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

    /**
     * 查询列表
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void findList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

    /**
     * 修改学员
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sid = req.getParameter("sid");
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

        // 步骤二
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
        student.setStuId(Integer.parseInt(sid));

        StudentService studentService = new StudentServiceImpl();
        int i = studentService.updateStu(student);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        if (i>0){
            writer.println("<script>alert('更新成功');location.href='/Educational/student/studentServlet'</script>");
        } else {
            writer.println("<script>alert('更新失败');" +
                    "location.href='/Educational/student/studentServlet?method=findById&sid="+sid+"'</script>");
        }
    }
}
