package com.fitness.aiservice.service;

import com.fitness.aiservice.model.Recommendation;
import com.fitness.aiservice.repository.RecommRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecommService {
    private final RecommRepo recommRepo;

    public List<Recommendation> getUserRecommendation(String userId) {
        return recommRepo.findByUserId(userId);
    }

    public Recommendation getActivityRecommendation(String activityId) {
        return recommRepo.findByActivityId(activityId)
                .orElseThrow(()-> new RuntimeException("No Recommendation Found For This Activity: " + activityId));
    }
}
