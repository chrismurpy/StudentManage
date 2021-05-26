package com.murphy.web;

import com.murphy.bean.Role;
import com.murphy.bean.Users;
import com.murphy.service.RoleService;
import com.murphy.service.UsersService;
import com.murphy.service.impl.RoleServiceImpl;
import com.murphy.service.impl.UsersServiceImpl;
import com.murphy.util.PageUtil;

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

@WebServlet("/power/user/users")
public class UsersServlet extends HttpServlet {

    private UsersService usersService = new UsersServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if ("insertUser".equals(method)){
            insertUser(req, resp);
        } else if ("findById".equals(method)){
            findById(req,resp);
        } else if ("update".equals(method)){
            update(req,resp);
        } else {
            select(req,resp);
        }
    }

    /**
     * 查询分页
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void select(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 接收参数 - 分页参数 + 模糊查询参数
        String index = req.getParameter("index");
        int pageIndex = ( index == null || index.length() == 0)? 1 : Integer.parseInt(index);
        // 2. 调取 service 方法 - 1.查询数据列表的方法 / 2. 查询总条数的方法
        PageUtil pageUtil = new PageUtil();
        List<Users> usersList = usersService.getUsersList(pageIndex, pageUtil.getPageSize());
        int total = usersService.total();
        pageUtil.setTotal(total);
        pageUtil.setPageIndex(pageIndex);
        pageUtil.setDataList(usersList);

        // 3. 存值跳页面
        req.setAttribute("pi",pageUtil);
        req.getRequestDispatcher("list.jsp").forward(req,resp);
    }

    /**
     * 新增用户
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void insertUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String loginName = req.getParameter("loginName");
        String password = req.getParameter("password");
        String realName = req.getParameter("realName");
        String sex = req.getParameter("sex");
        String roleId = req.getParameter("roleId");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        String cardId = req.getParameter("cardId");
        String desc = req.getParameter("desc");
        // 调取Service
        UsersService usersService = new UsersServiceImpl();
        Users user = new Users();
        user.setLoginName(loginName);
        user.setPassword(password);
        user.setRealName(realName);
        user.setSex(Integer.parseInt(sex));
        user.setRoleId(Integer.parseInt(roleId));
        user.setEmail(email);
        user.setPhone(phone);
        user.setAddress(address);
        user.setCardId(cardId);
        user.setDesc(desc);

        int i = usersService.insertUser(user);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        if (i > 0){
            writer.println("<script>alert('新增成功');location.href='/power/user/users'</script>");
        } else {
            writer.println("<script>alert('新增失败');location.href='/power/user/getRoleList'</script>");
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
        String uid = req.getParameter("uid");
        UsersService usersService = new UsersServiceImpl();
        Users user = usersService.findById(Integer.parseInt(uid));
        // 查询角色列表
        RoleService roleService = new RoleServiceImpl();
        List<Role> list = roleService.getLists();
        req.setAttribute("rlist",list);
        req.setAttribute("user",user);
        req.getRequestDispatcher("edit.jsp").forward(req,resp);
    }

    /**
     * 修改用户
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uid = req.getParameter("uid");
        String loginName = req.getParameter("loginName");
        String password = req.getParameter("password");
        String realName = req.getParameter("realName");
        String sex = req.getParameter("sex");
        String roleId = req.getParameter("roleId");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        String cardId = req.getParameter("cardId");

        Users user = new Users();
        user.setLoginName(loginName);
        user.setPassword(password);
        user.setRealName(realName);
        user.setSex(Integer.parseInt(sex));
        user.setRoleId(Integer.parseInt(roleId));
        user.setEmail(email);
        user.setPhone(phone);
        user.setAddress(address);
        user.setCardId(cardId);
        user.setUserId(Integer.parseInt(uid));

        UsersService usersService = new UsersServiceImpl();
        int i = usersService.updateUser(user);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        if (i > 0){
            writer.println("<script>alert('更新成功');location.href='/power/user/users'</script>");
        } else {
            writer.println("<script>alert('更新失败');" +
                    "location.href='/power/user/users?method=findById&uid="+uid+"'</script>");
        }
    }
}
