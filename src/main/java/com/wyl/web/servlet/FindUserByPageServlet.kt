package com.wyl.web.servlet

import com.wyl.service.UserService
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet("/finduserpage")
class FindUserByPageServlet : HttpServlet() {
    private val userService = UserService()

    override fun doPost(req: HttpServletRequest, resp: HttpServletResponse) {
        req.characterEncoding = "utf-8"
        resp.contentType = "text/html; charset=utf-8"
        resp.contentType = "application/json; charset=utf-8"

        req.apply {
            // 获取分页信息的参数
            val curPage = getParameter("currentPage")?.toIntOrNull() ?: 1
            val size = getParameter("pageSize")?.toIntOrNull() ?: 5
            // 获取条件查询的参数
            val pageBean = userService.findUserByPage(curPage, size, parameterMap)
            setAttribute("pageBean", pageBean)
//            println("look---- $pageBean")
//            pageBean.dataList.forEach(::println)
            getRequestDispatcher("/list.jsp").forward(req, resp)
        }
    }

    override fun doGet(req: HttpServletRequest, resp: HttpServletResponse) {
        this.doPost(req, resp)
    }
}