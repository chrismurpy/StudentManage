<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>
        学生信息管理平台
    </title>
    <link href="../../Style/StudentStyle.css" rel="stylesheet" type="text/css"/>
    <link href="../../Script/jBox/Skins/Blue/jbox.css" rel="stylesheet" type="text/css"/>
    <link href="../../Style/ks.css" rel="stylesheet" type="text/css"/>
    <link href="../../css/mine.css" type="text/css" rel="stylesheet">
    <script src="../../Script/jBox/jquery-1.4.2.min.js" type="text/javascript"></script>
    <script src="../../Script/jBox/jquery.jBox-2.3.min.js" type="text/javascript"></script>
    <script src="../../Script/jBox/i18n/jquery.jBox-zh-CN.js" type="text/javascript"></script>
    <script src="../../Script/Common.js" type="text/javascript"></script>
    <script src="../../Script/Data.js" type="text/javascript"></script>


</head>
<body>

<div class="div_head">
            <span>
                <span style="float:left">当前位置是：权限管理 -> 人员管理 -> 新增</span>
                <span style="float:right;margin-right: 8px;font-weight: bold">
                    <a style="text-decoration: none" href="javascript:history.back();">【返回】</a>
                </span>
            </span>
</div>
</div>
<div class="cztable">
    <form action="/power/user/users?method=insertUser" method="post">
        <table border="1" width="100%" class="table_a">
            <tr width="120px;">
                <td width="120px">用户名<span style="color:red">*</span>：</td>
                <td>
                    <input type="text" name="loginName" placeholder="请输入用户名"/>
                </td>
            </tr>

            <tr width="120px;">
                <td>密码<span style="color:red">*</span>：</td>
                <td>
                    <input type="password" name="password" placeholder="请输入密码" />
                </td>
            </tr>

            <tr width="120px;">
                <td>姓名<span style="color:red">*</span>：</td>
                <td>
                    <input type="text" name="realName" placeholder="请输入真实姓名" />
                </td>
            </tr>
            <tr>
                <td>性别<span style="color:red">*</span>：</td>
                <td>
                    <input type="radio" name="sex" checked value="1"/>男
                    <input type="radio" name="sex" value="0"/>女
                </td>
            </tr>

            <tr>
                <td>角色<span style="color:red">*</span>：</td>
                <td>
                    <select name="roleId">
                        <c:forEach items="${rlist}" var="r">
                            <option value="${r.roleId}">${r.roleName}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>

            <tr>
                <td>EMAIL：</td>
                <td>
                    <input type="text" name="email" placeholder="请输入您的邮箱"/>
                </td>
            </tr>

            <tr>
                <td>联系电话：</td>
                <td>
                    <input type="text" name="phone" placeholder="请输入您的电话"/>
                </td>
            </tr>

            <tr>
                <td>住址：</td>
                <td>
                    <input type="text" name="address" placeholder="请输入您的地址"/>
                </td>
            </tr>

            <tr>
                <td>身份证号：</td>
                <td>
                    <input type="text" name="cardId" placeholder="请输入您的证件号"/>
                </td>
            </tr>


            <tr>
                <td>简介<span style="color:red">*</span>：</td>
                <td>
                    <textarea name="desc">一个新开辟领域的探讨，探讨摸索</textarea>
                </td>
            </tr>
            <tr>
                <td colspan=2 align="center">
                    <input type="submit" value="添加"/>
                </td>
            </tr>
        </table>
    </form>
</div>

</div>
</div>

</div>
</body>
</html>
