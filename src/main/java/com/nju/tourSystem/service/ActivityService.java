package com.nju.tourSystem.service;

import com.nju.tourSystem.entity.Activity;

import java.util.List;

public interface ActivityService {
    Activity getActivityById(int id);
    List<Activity> getAllActivity();
    List<Activity> getOngoingActivity(String date);
    List<Activity> searchActivity(String keyword);
    List<Activity> getActivityByOrganizerId(int organizerId);
    List<Activity> getnewActivity(String startdate, String enddate);
    Boolean addAcitvity(Activity activity);
    Boolean updateAcitvity(Activity activity);
}

