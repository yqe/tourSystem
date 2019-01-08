package com.nju.tourSystem.service;

import com.nju.tourSystem.entity.Activity;

import java.util.List;

public interface ActivityService {
    Activity getActivityById(int id);
    List<Activity> getAllActivity();
    List<Activity> getOngoingActivity(String date);
    List<Activity> searchActivity(String keyword);
    Boolean addAcitvity(Activity activity);
    Boolean updateAcitvity(Activity activity);
}

