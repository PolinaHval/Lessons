package com.springmvc.controller;

import com.springmvc.service.FriendRequestService;
import com.springmvc.session.AuthContext;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@AllArgsConstructor
@RequestMapping("/addFriend")
public class FriendRequestController {

  private final AuthContext authContext;
  private final FriendRequestService friendRequestService;

  @PostMapping(path = "/{friendId}", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
  protected RedirectView sendFriendRequest(@PathVariable("friendId") int friendId) {
    final int senderId = authContext.getLoggedInUserId();
    friendRequestService.createFriendRequest(senderId, friendId);
    return new RedirectView("/users");
  }
}
