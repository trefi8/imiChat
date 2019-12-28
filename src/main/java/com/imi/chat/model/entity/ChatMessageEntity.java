package com.imi.chat.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.imi.chat.model.common.MessageType;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "Chatmessage")
public class ChatMessageEntity {

    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "Messagetype")
    private MessageType type;

    @Column(name = "Content")
    private String content;

    @Column(name = "Sender")
    private String sender;

}
