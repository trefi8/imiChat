package com.imi.chat.repo;

import java.util.List;

import com.imi.chat.model.entity.ChatMessageEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends CrudRepository<ChatMessageEntity, Long> {

	List<ChatMessageEntity> findAllBySender(String sender);

}
