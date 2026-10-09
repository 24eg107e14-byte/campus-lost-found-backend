package com.campus.lostfound.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campus.lostfound.model.FoundItem;
import com.campus.lostfound.model.LostItem;
import com.campus.lostfound.repository.FoundItemRepository;
import com.campus.lostfound.repository.LostItemRepository;

@Service
public class MatchService {

    @Autowired
    private LostItemRepository lostItemRepository;

    @Autowired
    private FoundItemRepository foundItemRepository;

    public List<Map<String, Object>> findMatches(Long lostItemId) {

        LostItem lostItem = lostItemRepository.findById(lostItemId)
                .orElseThrow(() -> new RuntimeException("Lost item not found"));

        List<FoundItem> foundItems = foundItemRepository.findAll();

        List<Map<String, Object>> matches = new ArrayList<>();

        for (FoundItem foundItem : foundItems) {

            int score = 0;

            if (same(lostItem.getItemName(), foundItem.getItemName())) {
                score += 30;
            }

            if (same(lostItem.getCategory(), foundItem.getCategory())) {
                score += 20;
            }

            if (same(lostItem.getColor(), foundItem.getColor())) {
                score += 20;
            }

            if (same(lostItem.getLocation(), foundItem.getLocation())) {
                score += 20;
            }

            if (sameDescription(
                    lostItem.getDescription(),
                    foundItem.getDescription())) {
                score += 10;
            }

            if (score >= 50) {

                Map<String, Object> result = new HashMap<>();

                result.put("foundItem", foundItem);
                result.put("matchScore", score);
                result.put("message", "Possible match found");

                matches.add(result);
            }
        }

        return matches;
    }

    private boolean same(String first, String second) {

        if (first == null || second == null) {
            return false;
        }

        return first.trim().equalsIgnoreCase(second.trim());
    }

    private boolean sameDescription(String first, String second) {

        if (first == null || second == null) {
            return false;
        }

        String firstText = first.toLowerCase();
        String secondText = second.toLowerCase();

        return firstText.contains(secondText)
                || secondText.contains(firstText);
    }
}
