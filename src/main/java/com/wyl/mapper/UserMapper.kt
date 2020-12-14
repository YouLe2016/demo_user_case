package com.wyl.mapper

import com.wyl.domain.User

interface UserMapper {
    /**
     * 查询所有用户
     */
    fun findAll(): List<User>

    /**
     * 根据Id查询用户
     */
    fun findUserById(id: Int): User

    /**
     * 分页查询数据
     */
    fun findUserByLimit(map: MutableMap<String, Any>): List<User>

    /**
     * 查询用户总数
     */
    fun findUserCount(): Int

    /**
     * 添加用户
     */
    fun addUser(user: User): Int

    /**
     * 根据Id删除用户
     */
    fun deleteUserById(id: Int): Int

    /**
     * 根据Id批量删除用户
     */
    fun deleteUsersById(id: List<Int>): Int

    /**
     * 修改用户信息
     */
    fun updateUser(user: User): Int

}