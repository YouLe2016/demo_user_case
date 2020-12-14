package com.wyl.mapper

import com.base.utils.getSqlSession
import com.wyl.domain.User
import org.apache.ibatis.io.Resources
import org.apache.ibatis.session.SqlSession
import org.apache.ibatis.session.SqlSessionFactoryBuilder
import org.junit.After
import org.junit.Before
import org.junit.Test
import sun.swing.MenuItemLayoutHelper
import java.io.InputStream
import kotlin.math.max

class UserMapperTest {

    @Test
    fun addUsers() {
        repeat(30) {
            testAddUser()
        }
    }

    @Test
    fun testAddUser() {
        getSqlSession().use {
            val mapper = it.getMapper(UserMapper::class.java)
            println(mapper.addUser(
                User(
                    id = 3,
                    name = "小白",
                    gender = "男",
                    address = "河南",
                    age = 27,
                    qq = "270628297",
                    email = "270628297@qq.com"
                )
            ))
            it.commit()
        }
    }

    @Test
    fun testDeleteUserById() {
        getSqlSession().use {
            val mapper = it.getMapper(UserMapper::class.java)
            println(mapper.deleteUserById(16))
            it.commit()
        }
    }

    @Test
    fun testDeleteUsersById() {
        getSqlSession().use {
            val mapper = it.getMapper(UserMapper::class.java)
            println(mapper.deleteUsersById(listOf()))
            it.commit()
        }
    }

    @Test
    fun testFindAll() {
        getSqlSession().use {
            val mapper = it.getMapper(UserMapper::class.java)
            mapper.findAll()
            it.commit()
        }
    }

    @Test
    fun testFindCount() {
        getSqlSession().use {
            val mapper = it.getMapper(UserMapper::class.java)
            println(mapper.findUserCount())
            it.commit()
        }
    }

    @Test
    fun testFindUserById() {
        getSqlSession().use {
            val mapper = it.getMapper(UserMapper::class.java)
            println(mapper.findUserById(10))
        }
    }

    @Test
    fun testFindUserByLimit() {
        getSqlSession().use {
            val mapper = it.getMapper(UserMapper::class.java)
            val curPage = 1
            val size = 10
            mapper.findUserByLimit(
                mutableMapOf(
                    "start" to max(curPage - 1, 0) * size,
                    "size" to size,
                )
            ).forEach(::println)
        }
    }

    @Test
    fun testUpdateUser() {
        getSqlSession().use {
            val mapper = it.getMapper(UserMapper::class.java)
            println(mapper.updateUser(
                User(
                    id = 10,
                    name = "小红",
                    gender = "女",
                    address = "河南",
                    age = 27,
                    qq = "123456",
                    email = "123456@qq.com"
                )
            ))
            it.commit()
        }
    }
}