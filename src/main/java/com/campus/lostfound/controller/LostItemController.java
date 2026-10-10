package com.campus.lostfound.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campus.lostfound.model.LostItem;
import com.campus.lostfound.repository.LostItemRepository;

@RestController
@RequestMapping("/api/lost-items")

@CrossOrigin(origins = {
        "http://localhost:5173",
        "https://24eg107e14.netlify.app"
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