package com.tts.finalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavigationController 
{
	@GetMapping(value="/home")
    public String home()
    {
    	return "home.html"; 
    }
	
	@GetMapping(value="/movie")
	public String movie()
	{
		return "movie.html"; 
	}
	
	@GetMapping(value="/tv")
	public String tv()
	{
		return "tv.html"; 
	}
	
	@GetMapping(value="/rating")
    public String rating()
    {
    	return "rating.html"; 
    }
	 
	@GetMapping(value="/actor")
    public String actor()
    {
    	return "actor.html"; 
    }
	
	

}
