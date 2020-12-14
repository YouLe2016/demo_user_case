package com.wyl.web.servlet

import com.wyl.domain.User
import com.wyl.service.UserService
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@WebServlet("/updateuser")
class UpdateUserServlet : HttpServlet() {
    private val userService = UserService()

    override fun doPost(req: HttpServletRequest, resp: HttpServletResponse) {
        req.characterEncoding = "utf-8"
        resp.contentType = "text/html; charset=utf-8"

        req.apply {
            userService.updateUser(
                User(
                    id = getParameter("id").toInt(),
                    name = getParameter("name"),
                    gender = getParameter("sex"),
                    age = getParameter("age").toInt(),
                    address = getParameter("address"),
                    qq = getParameter("qq"),
                    email = getParameter("email"),
                )
            )
            resp.sendRedirect("$contextPath/userlist")
        }
    }

    override fun doGet(req: HttpServletRequest, resp: HttpServletResponse) {
        this.doPost(req, resp)
    }
}