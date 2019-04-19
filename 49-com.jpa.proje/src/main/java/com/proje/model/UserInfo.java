package com.proje.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {

	private String userName;

	private String firstName;

	private String lastName;

	private Date birthOfDate;

}
