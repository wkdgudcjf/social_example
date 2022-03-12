package com.social_example_back.api.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.social_example_back.api.user.entity.MyUser;

@Repository
public interface UserRepository extends JpaRepository<MyUser, String> {
	//@Query(value = "SELECT * FROM GT_USER WHERE email = :email", nativeQuery = true) // 쿼리로도 쓸 수 있음
	//GwatopUser findByEmail(@Param("email")String email);
	MyUser findByEmail(String email);
}