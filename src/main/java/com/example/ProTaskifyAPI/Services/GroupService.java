package com.example.ProTaskifyAPI.Services;

import com.example.ProTaskifyAPI.DTO.GroupDTO;
import com.example.ProTaskifyAPI.DTO.ResponseObject;
import org.springframework.http.ResponseEntity;

public interface GroupService {

    ResponseEntity<ResponseObject> createGroup(GroupDTO g);

    ResponseEntity<ResponseObject> findGroupDetails(Integer group_id, Integer class_id);
//    ResponseEntity<ResponseObject> chooseTopic(String topic);
}
