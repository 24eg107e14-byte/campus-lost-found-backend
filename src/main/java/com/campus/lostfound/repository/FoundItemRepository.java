package com.campus.lostfound.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campus.lostfound.model.FoundItem;

public interface FoundItemRepository extends JpaRepository<FoundItem, Long> {
}
