package com.wyl.web.servlet

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet("/loginServlet")
class LoginServlet : HttpServlet() {
    override fun doPost(req: HttpServletRequest, resp: HttpServletResponse) {
        req.characterEncoding = "utf-8"
        resp.contentType = "text/html; charset=utf-8"

        req.apply {
            val verifyCode = getParameter("verifycode")
            if (!verifyCode.equals(session.getAttribute("CHECKCODE_SERVER") as String?, true)) {
                setAttribute("login_msg", "验证码错误！")
                getRequestDispatcher("/login.jsp").forward(req, resp)
                return
            }
            val username = getParameter("username")
            val password = getParameter("password")
            if (username != "root" || password != "root") {
                setAttribute("login_msg", "用户名或密码错误！")
                getRequestDispatcher("/login.jsp").forward(req, resp)
                return
            }
            resp.sendRedirect("$contextPath/index.jsp")
        }
    }
}