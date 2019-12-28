package com.imi.chat.service;

import java.util.List;
import java.util.stream.Collectors;

import com.imi.chat.model.dto.ChatMessage;
import com.imi.chat.model.entity.ChatMessageEntity;
import com.imi.chat.repo.ChatRepository;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

		private final ChatRepository chatRepository;

	public ChatService(ChatRepository chatRepository) {
		this.chatRepository = chatRepository;
	}

	public void saveMessage(ChatMessage chatMessage) {
		final ChatMessageEntity entity = new ChatMessageEntity();
		entity.setContent(chatMessage.getContent());
		entity.setType(chatMessage.getType());
		entity.setContent(chatMessage.getContent());
		entity.setSender(chatMessage.getSender());

		chatRepository.save(entity);
	}

	public List<ChatMessage> getMessagesBySender(String sender) {
		List<ChatMessageEntity> chatMessageEntities = chatRepository.findAllBySender(sender);
		return chatMessageEntities.stream().map(chatMessageEntity -> {
			ChatMessage chatMessage = new ChatMessage();
			chatMessage.setSender(chatMessageEntity.getSender());
			chatMessage.setContent(chatMessageEntity.getContent());
			chatMessage.setType(chatMessageEntity.getType());
			return chatMessage;
		}).collect(Collectors.toList());
	}
}
