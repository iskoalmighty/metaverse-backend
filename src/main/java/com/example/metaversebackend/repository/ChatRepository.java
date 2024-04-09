package com.example.metaversebackend.repository;

import com.example.metaversebackend.model.chat.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, String> {}
