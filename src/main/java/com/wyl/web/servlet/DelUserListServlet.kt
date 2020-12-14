package com.wyl.web.servlet

import com.wyl.service.UserService
import java.util.*
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet("/delusers")
class DelUserListServlet : HttpServlet() {
    private val userService = UserService()

    override fun doPost(req: HttpServletRequest, resp: HttpServletResponse) {
        req.characterEncoding = "utf-8"
        resp.contentType = "text/html; charset=utf-8"

        req.apply {
            val values = getParameterValues("id")
            println(Arrays.toString(values))
            userService.deleteUsers(values.map { it.toInt() })
            resp.sendRedirect("$contextPath/userlist")
        }
    }

    override fun doGet(req: HttpServletRequest, resp: HttpServletResponse) {
        this.doPost(req, resp)
    }
}