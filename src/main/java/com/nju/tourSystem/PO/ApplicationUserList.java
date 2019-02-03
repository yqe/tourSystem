package com.nju.tourSystem.PO;

import com.nju.tourSystem.entity.Participant;
import com.nju.tourSystem.entity.User;

import java.util.List;

public class ApplicationUserList {
    private List<Participant> participantList;
    private List<User> userList;

    public ApplicationUserList() {
    }

    public ApplicationUserList(List<Participant> participantList, List<User> userList) {
        this.participantList = participantList;
        this.userList = userList;
    }

    public List<Participant> getParticipantList() {
        return participantList;
    }

    public void setParticipantList(List<Participant> participantList) {
        this.participantList = participantList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
