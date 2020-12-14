package com.wyl.web.servlet

import com.wyl.service.UserService
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet("/userlist")
class UserListServlet : HttpServlet() {
    private val userService = UserService()

    override fun doGet(req: HttpServletRequest, resp: HttpServletResponse) {
        this.doPost(req, resp)
    }

    override fun doPost(req: HttpServletRequest, resp: HttpServletResponse) {
        val userList = userService.findAll()
//        userList.forEach(::println)
        req.apply {
            setAttribute("userList", userList)
            getRequestDispatcher("/list.jsp").forward(req, resp)
        }
    }
}