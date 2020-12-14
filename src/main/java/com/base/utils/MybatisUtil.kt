package com.base.utils

import org.apache.ibatis.io.Resources
import org.apache.ibatis.session.SqlSession
import org.apache.ibatis.session.SqlSessionFactoryBuilder

const val resource = "mybatis-config.xml"
private val inputStream = Resources.getResourceAsStream(resource)
private val sqlSessionFactory = inputStream.use {
    SqlSessionFactoryBuilder().build(it)
}

fun getSqlSession(): SqlSession = sqlSessionFactory.openSession()
