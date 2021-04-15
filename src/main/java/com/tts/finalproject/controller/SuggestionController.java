package com.tts.finalproject.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tts.finalproject.model.Suggestion;
import com.tts.finalproject.repository.SuggestionRepo;

@Controller
public class SuggestionController 
{
	@Autowired 
	SuggestionRepo suggestionRepo; 
	
	@GetMapping("/suggestion")
	public String suggestionForm(Model model)
	{
		model.addAttribute("suggestion", new Suggestion()); 
		return "suggestion.html";
	}
	
	@PostMapping("/suggestion")
	public String suggestionSubmit(@Valid @ModelAttribute Suggestion suggestion, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			System.out.println("A comment would be nice :)"); 
			return "suggestion.html";
		}
		suggestionRepo.save(suggestion); 
		model.addAttribute("suggestion", suggestion); 
		return "result.html"; 
	}
}
