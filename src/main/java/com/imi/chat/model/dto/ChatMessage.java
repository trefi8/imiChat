package com.imi.chat.model.dto;

import com.imi.chat.model.common.MessageType;
import lombok.Data;

@Data
public class ChatMessage {
    private MessageType type;
    private String content;
    private String sender;

}
