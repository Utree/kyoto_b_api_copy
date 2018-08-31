package com.kyotob.api.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.sql.Timestamp

//User登録用のクラス
data class UserRegister(
        val name: String,
        val screenName: String,
        val password: String
)

//Userログインのクラス
data class UserLogin(
        val name: String,
        val password: String
)

//User登録のResponseでTokenを返すためのクラス
data class UserResponse(
        val token: String
)

data class Room(
        val id: Int,
        val name: String
)

data class User(
        val id: Int,
        val name: String,
        val screenName: String,
        val password: String
)

data class Pair(
        val roomId: Int,
        val userId1: Int,
        val userId2: Int
)

data class Token(
        val userId: Int,
        val token: String,
        @get:JsonProperty("created_at") var createdAt: Timestamp
)

data class Message(
        val messageId: Int,
        val senderId: Int,
        val roomId: Int,
        val content: String,
        @get:JsonProperty("created_at") val createdAt: Timestamp
)
