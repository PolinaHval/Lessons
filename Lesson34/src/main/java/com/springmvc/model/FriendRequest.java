package com.springmvc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@AllArgsConstructor
@Builder
public class FriendRequest {
  int senderRequest;
  int recipientRequest;
}
