package org.iesteis.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Response{
	@JsonProperty(value="results")
	private List<Character> characters;
	private Info info;

	public List<Character> getCharacters(){
		return characters;
	}

	public Info getInfo(){
		return info;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"results = '" + characters + '\'' +
			",info = '" + info + '\'' + 
			"}";
		}
}