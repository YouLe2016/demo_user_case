package com.wyl.domain

data class User(
    var id: Int = -1,
    var name: String = "",
    var gender: String = "",
    var age: Int = 0,
    var address: String = "",
    var qq: String = "",
    var email: String = "",
) {
    fun setMapData(map: Map<String, String>) {
        map["id"]?.let { id = it.toInt() }
        map["name"]?.let { name = it }
        map["gender"]?.let { gender = it }
        map["age"]?.let { age = it.toInt() }
        map["address"]?.let { address = it }
        map["qq"]?.let { qq = it }
        map["email"]?.let { email = it }
    }
}