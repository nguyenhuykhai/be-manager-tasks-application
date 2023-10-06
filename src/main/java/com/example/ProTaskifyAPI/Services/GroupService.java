package com.example.ProTaskifyAPI.Services;

import com.example.ProTaskifyAPI.DTO.GroupDTO;
import com.example.ProTaskifyAPI.DTO.MsgDTO;
import com.example.ProTaskifyAPI.Models.Group;

public interface GroupService {

    MsgDTO createGroup(GroupDTO g);

    MsgDTO chooseTopic(String topic);
}
