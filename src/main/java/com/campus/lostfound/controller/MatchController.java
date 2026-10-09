package com.campus.lostfound.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campus.lostfound.service.MatchService;

@RestController
@RequestMapping("/api/matches")
@CrossOrigin(origins = {
        "http://localhost:5173",
        "http://localhost:5174",
        "http://localhost:5175",
        "http://localhost:5176"
})
public class MatchController {

    @Autowired
    private MatchService matchService;

    @GetMapping("/{lostItemId}")
    public List<Map<String, Object>> findMatches(
            @PathVariable Long lostItemId) {

        return matchService.findMatches(lostItemId);
    }
}