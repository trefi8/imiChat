package com.imi.status.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.info.BuildProperties;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {

	@Autowired
	private BuildProperties buildProperties;

	@Value("${app.buildVersion}")
	private String buildVersion;

	private final String applicationStatus = "RUNNING";

	public String getBuilldVersion() {
		return buildProperties.getVersion();
	}

	public String getApplicationStatus() {
		return applicationStatus;
	}

}
