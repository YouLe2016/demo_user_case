package com.wyl.web.servlet

import com.wyl.domain.User
import com.wyl.service.UserService
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@WebServlet("/findUser")
class FindUserServlet : HttpServlet() {
    private val userService = UserService()

    override fun doPost(req: HttpServletRequest, resp: HttpServletResponse) {
        req.characterEncoding = "utf-8"
        resp.contentType = "text/html; charset=utf-8"

        req.apply {
            val user = userService.findUserById(getParameter("id").toInt())
            setAttribute("user", user)
            getRequestDispatcher("/update.jsp").forward(req, resp)
        }
    }

    override fun doGet(req: HttpServletRequest, resp: HttpServletResponse) {
        this.doPost(req, resp)
    }
}