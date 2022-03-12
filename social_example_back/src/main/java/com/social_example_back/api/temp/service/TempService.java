package com.social_example_back.api.temp.service;

import java.util.List;

import com.social_example_back.api.temp.dto.TempDTO;

public interface TempService
{
	public List<TempDTO> getTempList(String email);
}
