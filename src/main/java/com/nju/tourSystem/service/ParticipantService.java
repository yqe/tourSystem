package com.nju.tourSystem.service;

import com.nju.tourSystem.entity.Participant;

import java.util.List;

public interface ParticipantService {
    boolean addParticipant(Participant participant);
    boolean updateParticipant(Participant participant);
    Participant getParticipantById(int id);
    List<Participant> getActivityListByUid(int uid);
    List<Participant> getApplicationListByUid(int uid);
    List<Participant> getParticipantList(int aid);
    List<Participant> getApplicationList(int aid);
    Boolean delete(int id);
}
