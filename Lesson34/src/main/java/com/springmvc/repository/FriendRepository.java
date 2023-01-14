package com.springmvc.repository;


import com.springmvc.model.Friend;

import java.util.List;
import java.util.Optional;

public interface FriendRepository {

  void addFriend(int senderId, int recipientId);

  List<Friend> getListFriends(int userId);
}
