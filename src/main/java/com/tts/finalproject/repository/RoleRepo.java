package com.tts.finalproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.finalproject.model.Role;

@Repository
public interface RoleRepo extends CrudRepository<Role, Long> 
{
	Role findByRole(String role); 
}


