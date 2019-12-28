package com.imi.status.service;

import org.springframework.stereotype.Service;

@Service
public class ApplicationService {

	private final String applicationStatus = "RUNNING";

	public String getApplicationStatus() {
		return applicationStatus;
	}

}
