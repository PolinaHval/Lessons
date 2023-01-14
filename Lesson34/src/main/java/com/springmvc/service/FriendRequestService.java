package com.springmvc.service;

import com.springmvc.repository.FriendRequestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FriendRequestService {
  private final FriendRequestRepository friendRequestRepository;

  public void createFriendRequest(int senderId, int recipient) {
    if (friendRequestRepository.getFriendRequest(senderId, recipient)) {
      throw new RuntimeException("Request already send");
    } else {
      friendRequestRepository.createFriendRequest(senderId, recipient);
    }
  }
}
