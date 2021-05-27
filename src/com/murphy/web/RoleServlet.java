package com.murphy.web;

import com.murphy.bean.Menu;
import com.murphy.bean.Role;
import com.murphy.bean.Users;
import com.murphy.dao.MiddleDao;
import com.murphy.dao.impl.MiddleDaoImpl;
import com.murphy.service.MenuService;
import com.murphy.service.MiddleService;
import com.murphy.service.RoleService;
import com.murphy.service.UsersService;
import com.murphy.service.impl.MenuServiceImpl;
import com.murphy.service.impl.MiddleServiceImpl;
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

@WebServlet("/power/role/roles")
public class RoleServlet extends HttpServlet {

    private RoleService roleService = new RoleServiceImpl();
    private MenuService menuService = new MenuServiceImpl();
    private MiddleService middleService = new MiddleServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        switch (method){
            case "select":
                select(req, resp);
                break;
            case "selectMenus":
                selectMeuns(req, resp);
                break;
            case "insert":
                insert(req, resp);
                break;
            case "delete":
                delete(req,resp);
                break;
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

        List<Role> roleList = roleService.getRoleList(pageIndex, pageUtil.getPageSize());
        int total = roleService.total();

        pageUtil.setTotal(total);
        pageUtil.setPageIndex(pageIndex);
        pageUtil.setDataList(roleList);

        // 3. 存值跳页面
        req.setAttribute("pi",pageUtil);
        req.getRequestDispatcher("list.jsp").forward(req,resp);
    }

    /**
     * 查询菜单列表
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void selectMeuns(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 接收参数
        // 2. 调取Service方法
        List<Menu> menuList = menuService.getMenuList();
        req.setAttribute("menuList",menuList);
        // 3. 转发
        req.getRequestDispatcher("add.jsp").forward(req,resp);
    }

    /**
     * 新增角色
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void insert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String roleName = req.getParameter("roleName");
        String state = req.getParameter("state");
        String[] menuIds = req.getParameterValues("menuId");
        int i = roleService.insertRole(roleName, state, menuIds);
        if (i > 0){
            resp.sendRedirect("/power/role/roles?method=select");
        } else {
            resp.sendRedirect("/power/role/roles?method=selectMenus");
        }
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String roleid = req.getParameter("roleid");
        int flag1 = roleService.deleteRole(Integer.parseInt(roleid));
        int flag2 = middleService.deleteMiddle(Integer.parseInt(roleid));
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        if (flag1 > 0 && flag2 > 0){
            writer.println("<script>alert('删除成功');location.href='/power/role/roles?method=select'</script>");
        } else {
            writer.println("<script>alert('删除失败');location.href='javascript:history.back()'</script>");
        }
    }
}
