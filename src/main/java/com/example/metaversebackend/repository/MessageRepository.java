package com.example.metaversebackend.repository;

import com.example.metaversebackend.model.message.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, String> {
}
