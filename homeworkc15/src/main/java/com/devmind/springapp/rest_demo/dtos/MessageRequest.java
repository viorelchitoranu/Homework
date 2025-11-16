package com.devmind.springapp.rest_demo.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
public class MessageRequest {
    private  String sender;
    private String receiver;
    private String text;
    private boolean seen;
    private Date sentDate;
}
