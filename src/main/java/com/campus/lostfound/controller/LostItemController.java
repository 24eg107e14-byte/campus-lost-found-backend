package com.campus.lostfound.controller;

import com.campus.lostfound.model.LostItem;
import com.campus.lostfound.repository.LostItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/lost-items")

@CrossOrigin(origins = {
        "http://localhost:5173",
        "http://localhost:5174",
        "http://localhost:5175",
        "http://localhost:5176"
})

public class LostItemController {

    @Autowired
    private LostItemRepository lostItemRepository;


    // ADD LOST ITEM
    @PostMapping
    public LostItem addLostItem(@RequestBody LostItem lostItem) {

        return lostItemRepository.save(lostItem);
    }


    // GET ALL LOST ITEMS
    @GetMapping
    public List<LostItem> getAllLostItems() {

        return lostItemRepository.findAll();
    }
}