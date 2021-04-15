package com.tts.finalproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.finalproject.model.Suggestion;

@Repository
public interface SuggestionRepo extends CrudRepository<Suggestion, Long>
{
	Suggestion findByContent(String content); 
}
