package com.nju.tourSystem.service;

import com.nju.tourSystem.entity.Friendship;

import java.util.List;

public interface FriendshipService {
    boolean addFriend(Friendship friendship);
    boolean updateFriend(Friendship friendship);
    Friendship getFriendshipById(int id);
    List<Friendship> getFriendshipListByUid(int uid);
    List<Friendship> getApplicationListByUid(int uid);
    Boolean delete(int id);
}
