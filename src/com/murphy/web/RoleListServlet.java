package com.murphy.web;

import com.murphy.bean.Role;
import com.murphy.service.impl.RoleServiceImpl;

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
@WebServlet("/power/user/getRoleList")
public class RoleListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 查询角色列表
        RoleServiceImpl roleService = new RoleServiceImpl();
        List<Role> list = roleService.getLists();
        req.setAttribute("rlist",list);
        req.getRequestDispatcher("add.jsp").forward(req,resp);
    }
}
