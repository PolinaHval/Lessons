package com.springmvc.service;

import com.springmvc.model.Friend;
import com.springmvc.repository.FriendRepository;
import com.springmvc.repository.FriendRequestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FriendService {

  private final FriendRepository friendRepository;
  private final FriendRequestRepository friendRequestRepository;


  public void addFriend(int senderId, int recipientId) {
    friendRequestRepository.deleteFriendRequest(senderId, recipientId);
    friendRepository.addFriend(senderId, recipientId);
  }

  public List<Friend> getListFriends(int userId) {
    return friendRepository.getListFriends(userId);
  }
}
