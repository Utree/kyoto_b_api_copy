package com.kyotob.api.controller

import com.kyotob.api.service.RoomService
import com.kyotob.api.service.TokenService
import com.kyotob.api.model.Room
import com.kyotob.api.model.Token
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
class RoomController(private val roomService: RoomService, private val tokenService: TokenService) {

    //部屋一覧(デバッグ用)
    @GetMapping(
            value = ["/room/all"],
            produces = [(MediaType.APPLICATION_JSON_UTF8_VALUE)]
    )
    fun getAllRoom(): ArrayList<Room> {
        return roomService.getAllRoomList()
    }

    //所属ルーム一覧
    @GetMapping(
            value = ["/room"],
            produces = [(MediaType.APPLICATION_JSON_UTF8_VALUE)]
    )
    fun getAffiliatedRoom(@RequestParam("access_token") token: String): List<Room> {
        val uId = tokenService.verifyAccessToken(token)
        return roomService.getRoomListFromUserId(uId)
    }


    //一対一ルーム取得
    @PostMapping(
            value = ["/room/pair"],
            produces = [(MediaType.APPLICATION_JSON_UTF8_VALUE)]
    )
    fun getPairRoom(@RequestParam("access_token") token: String,
                     @RequestBody): List<Room> {
        val uId = tokenService.verifyAccessToken(token)
        return roomService.getRoomListFromUserId(uId)
    }
}