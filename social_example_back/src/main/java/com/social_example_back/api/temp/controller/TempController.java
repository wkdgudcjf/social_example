package com.social_example_back.api.temp.controller;

import java.util.List;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.social_example_back.api.temp.dto.TempDTO;
import com.social_example_back.api.temp.service.TempService;
import com.social_example_back.api.user.entity.MyUser;
import com.social_example_back.common.ApiResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/temp")
public class TempController {
	
	private final TempService tempService;
	
	@Secured({"ROLE_USER","ROLE_ADMIN"})
	@RequestMapping(value = "/list", method = {RequestMethod.GET})
	public ApiResponse<List<TempDTO>> selectTempList(MyUser myUser){
		List<TempDTO> tempList = tempService.getTempList(myUser.getEmail());
		return ApiResponse.success("tempList", tempList);
	}
}
