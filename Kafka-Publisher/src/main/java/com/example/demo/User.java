package com.example.demo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class User {

	

	private int id;
	private String name;
	private String[] address;

}
