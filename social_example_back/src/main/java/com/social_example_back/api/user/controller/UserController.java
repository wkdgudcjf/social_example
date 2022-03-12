package com.social_example_back.api.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.social_example_back.api.user.dto.UserDTO;
import com.social_example_back.api.user.entity.MyUser;
import com.social_example_back.api.user.service.UserService;
import com.social_example_back.common.ApiResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
	
	private final UserService userService;
	@GetMapping("/me")
    public ApiResponse<UserDTO> getUser(MyUser myUser) {
		UserDTO user = userService.getUser(myUser.getEmail());
        return ApiResponse.success("user", user);
    }
}
