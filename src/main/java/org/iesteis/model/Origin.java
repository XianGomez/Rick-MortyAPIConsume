package org.iesteis.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Origin{

	@Override
	public String toString() {
		return "Origin{" +
				"name='" + name + '\'' +
				", url='" + url + '\'' +
				'}';
	}

	@JsonProperty("name")
	private String name;

	@JsonProperty("url")
	private String url;

	public String getName(){
		return name;
	}

	public String getUrl(){
		return url;
	}
}