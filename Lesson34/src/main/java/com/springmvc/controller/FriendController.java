package com.springmvc.controller;

import com.springmvc.model.Friend;
import com.springmvc.service.FriendService;
import com.springmvc.session.AuthContext;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/friends")
@AllArgsConstructor
public class FriendController {
  private final AuthContext authContext;
  private final FriendService friendService;

  @GetMapping
  protected String getFriendsList(final Model model) {
    final int userId = authContext.getLoggedInUserId();
    final List<Friend> friends = friendService.getListFriends(userId);
    model.addAttribute("friends", friends);
    return "friendList";
  }

  @PostMapping("/{friendId}")
  protected void addFriend(@PathVariable("friendId") int friendId) {
    final int userId = authContext.getLoggedInUserId();
    friendService.addFriend(userId, friendId);
  }
}
