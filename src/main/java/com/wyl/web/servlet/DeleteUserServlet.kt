package com.wyl.web.servlet

import com.wyl.service.UserService
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet("/deleteUser")
class DeleteUserServlet : HttpServlet() {
    private val userService = UserService()

    override fun doPost(req: HttpServletRequest, resp: HttpServletResponse) {
        req.characterEncoding = "utf-8"
        resp.contentType = "text/html; charset=utf-8"

        req.apply {
            userService.deleteUserById(getParameter("id").toInt())
            resp.sendRedirect("$contextPath/userlist")
        }
    }

    override fun doGet(req: HttpServletRequest, resp: HttpServletResponse) {
        this.doPost(req, resp)
    }
}