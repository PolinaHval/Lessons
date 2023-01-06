package com.springmvc.repository;


public interface FriendRepository {

  void addFriend(int senderId, int recipientId);

  void deleteFriend(int senderId, int recipient);
}
