package com.example.ProTaskifyAPI.DTO;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class MsgDTO {
    private String status, msgBody;
}
