package com.tts.finalproject.repository;

import org.springframework.data.repository.CrudRepository;

import com.tts.finalproject.model.User;

public interface UserRepo extends CrudRepository <User, Long> 
{
	User findByUsername(String username);
}
