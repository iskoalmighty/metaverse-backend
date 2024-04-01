package com.example.metaversebackend.repository;

import com.example.metaversebackend.model.thread.Thread;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThreadRepository extends JpaRepository<Thread, String> {
}
