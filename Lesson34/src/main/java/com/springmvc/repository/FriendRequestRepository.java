package com.springmvc.repository;

import org.springframework.stereotype.Repository;


@Repository
public interface FriendRequestRepository {

  void createFriendRequest(int senderRequest, int recipientRequest);

  void deleteFriendRequest(int senderRequest, int recipientRequest);

  boolean getFriendRequest(int senderRequest, int recipientRequest);

  
}
