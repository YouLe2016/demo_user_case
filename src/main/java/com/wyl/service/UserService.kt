package com.wyl.service

import com.base.utils.getSqlSession
import com.wyl.domain.PageBean
import com.wyl.domain.User
import com.wyl.mapper.UserMapper
import kotlin.math.max
import kotlin.math.min

/**
 * 用户管理的业务接口实现类
 */
class UserService {

    /**
     * 查询所有用户
     */
    fun findAll(): List<User> {
        return getSqlSession().use {
            val userMapper = it.getMapper(UserMapper::class.java)
            userMapper.findAll()
        }
    }

    /**
     * 根据Id查询用户
     */
    fun findUserById(id: Int): User {
        return getSqlSession().use {
            val userMapper = it.getMapper(UserMapper::class.java)
            userMapper.findUserById(id)
        }
    }

    /**
     * 添加用户
     */
    fun addUser(user: User) {
        getSqlSession().use {
            val userMapper = it.getMapper(UserMapper::class.java)
            userMapper.addUser(user)
            it.commit()
        }
    }

    /**
     * 根据Id删除用户
     */
    fun deleteUserById(id: Int) {
        getSqlSession().use {
            val userMapper = it.getMapper(UserMapper::class.java)
            userMapper.deleteUserById(id)
            it.commit()
        }
    }

    /**
     * 修改用户信息
     */
    fun updateUser(user: User) {
        getSqlSession().use {
            val userMapper = it.getMapper(UserMapper::class.java)
            userMapper.updateUser(user)
            it.commit()
        }
    }

    fun deleteUsers(ids: List<Int>) {
        if (ids.isNotEmpty()) {
            getSqlSession().use {
                val userMapper = it.getMapper(UserMapper::class.java)
                userMapper.deleteUsersById(ids)
                it.commit()
            }
        }
    }

    fun findUserByPage(curPage: Int, size: Int, condition: MutableMap<String, Array<String>>): PageBean<User> {
        return getSqlSession().use {
            val mapper = it.getMapper(UserMapper::class.java)
            val count = mapper.findUserCount()
            val totalPage = count / size + min(count % size, 1)

            val curPageFix = min(totalPage, max(curPage, 1))
            val map = mutableMapOf<String, Any>(
                "start" to max(curPageFix - 1, 0) * size,
                "size" to size
            )
            condition.forEach { (t, u) ->
                map[t] = u[0]
            }
            val list = mapper.findUserByLimit(map)
            PageBean(
                totalPage = totalPage,
                currentPage = curPageFix,
                pageSize = size,
                totalCount = count,
                dataList = list,
            )
        }
    }
}