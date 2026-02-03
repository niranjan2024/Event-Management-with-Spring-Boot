package org.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.entity.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
}

