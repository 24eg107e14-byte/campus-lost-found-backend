package com.campus.lostfound.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campus.lostfound.model.FoundItem;
import com.campus.lostfound.repository.FoundItemRepository;

@RestController
@RequestMapping("/api/found-items")
@CrossOrigin(origins = {
        "http://localhost:5173",
        "https://24eg107e14.netlify.app"
})
public class FoundItemController {

    @Autowired
    private FoundItemRepository foundItemRepository;

    @PostMapping
    public FoundItem addFoundItem(@RequestBody FoundItem foundItem) {
        return foundItemRepository.save(foundItem);
    }

    @GetMapping
    public List<FoundItem> getAllFoundItems() {
        return foundItemRepository.findAll();
    }
}