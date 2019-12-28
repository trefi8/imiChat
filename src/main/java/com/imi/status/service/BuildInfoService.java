package com.imi.status.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.boot.info.BuildProperties;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnResource(resources = "${spring.info.build.location:classpath:META-INF/build-info.properties}")
public class BuildInfoService {

	@Autowired
	BuildProperties buildProperties;

	public String getBuilldVersion() {
		return buildProperties.get("versionNumber");
	}
}
