package com.nju.tourSystem.service;

import com.nju.tourSystem.entity.TourRecord;

import java.util.List;

public interface TourRecordService {
    boolean addTourRecord(TourRecord tourRecord);
    boolean updateTourRecord(TourRecord tourRecord);
    TourRecord getTourRecordById(int id);
    List<TourRecord> getTourRecordByUid(String uid);
    List<TourRecord> getTourRecordByContent(String content);
    List<TourRecord> getHotTourRecord();
}
