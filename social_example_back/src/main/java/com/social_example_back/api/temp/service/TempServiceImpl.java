package com.social_example_back.api.temp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.social_example_back.api.temp.dto.TempDTO;
import com.social_example_back.api.temp.mapper.TempMapper;
import com.social_example_back.api.temp.repository.TempRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TempServiceImpl implements TempService
{
	private final TempMapper tempMapper;
	private final TempRepository tempRepository;
	
	@Override
	public List<TempDTO> getTempList(String email) {
		return tempMapper.selectTempByEmail(email);
	}
}
