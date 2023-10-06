package com.example.ProTaskifyAPI.Services;

import com.example.ProTaskifyAPI.DTO.MsgDTO;

public class MsgService {

    public static MsgDTO generateMsg(String status, String msg){
        return new MsgDTO().builder()
                .status(status)
                .msgBody(msg)
                .build();
    }
}
