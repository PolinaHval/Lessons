package com.springmvc.repository;

import com.springmvc.model.FriendRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FriendRequestRepository {

  void createFriendRequest(int senderRequest, int recipientRequest);

  void deleteFriendRequest(int senderRequest, int recipientRequest);

  boolean getFriendRequest(int senderRequest, int recipientRequest);
}
