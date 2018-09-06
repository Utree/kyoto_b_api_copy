package com.kyotob.api.controller

import com.kyotob.api.model.UserRegister //User登録用のモデル
import com.kyotob.api.model.UserLogin //User認証用のモデル
import com.kyotob.api.model.UserResponse //Userレスポンス用のモデル
import com.kyotob.api.model.UserSearch //User検索ようのモデル

import com.kyotob.api.service.UserService // User関連のサービス

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*


@RestController
class UserController(private val userService: UserService){
    //Userの登録
    @PostMapping(
            value = ["/user"],
            produces = [(MediaType.APPLICATION_JSON_UTF8_VALUE)]
    )
    fun createuser(@RequestBody request: UserRegister): UserResponse {
        return userService.createUser(request)
    }

    //Userのログイン
    @PostMapping(
            value = ["user/login"],
            produces = [(MediaType.APPLICATION_JSON_UTF8_VALUE)]
    )
    fun loginuser(@RequestBody request: UserLogin): UserResponse{
        return userService.login(request)
    }

    //User検索
    @GetMapping(
            value = ["user/search/{user_name}"],
            produces = [(MediaType.APPLICATION_JSON_UTF8_VALUE)]
    )
    fun searchuser(@PathVariable("user_name") userName: String, @RequestHeader("Token") token:String): UserSearch{
        return userService.searchUser(userName, token)
    }


}