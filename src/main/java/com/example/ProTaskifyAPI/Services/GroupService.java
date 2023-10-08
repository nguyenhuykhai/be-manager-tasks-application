package com.example.ProTaskifyAPI.Services;

import com.example.ProTaskifyAPI.DTO.GroupDTO;
import com.example.ProTaskifyAPI.DTO.ResponseObject;
import org.springframework.http.ResponseEntity;

public interface GroupService {

    ResponseEntity<ResponseObject> createGroup(GroupDTO g);

    ResponseEntity<ResponseObject> chooseTopic(String topic);
}
