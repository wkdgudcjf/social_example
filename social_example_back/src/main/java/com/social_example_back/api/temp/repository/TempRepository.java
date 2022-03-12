package com.social_example_back.api.temp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.social_example_back.api.temp.entity.Temp;

@Repository
public interface TempRepository extends JpaRepository<Temp, String> {
	List<Temp> findByEmail(String email);
}
