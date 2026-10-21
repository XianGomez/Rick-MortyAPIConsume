package org.iesteis.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Response{

	@JsonProperty("results")
	private List<Personaje> characters;

	@JsonProperty("info")
	private Info info;

	public List<Personaje> getCharacters(){
		return characters;
	}

	public Info getInfo(){
		return info;
	}
}