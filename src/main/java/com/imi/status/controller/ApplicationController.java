package com.imi.status.controller;

import com.imi.status.service.ApplicationService;
import com.imi.status.service.BuildInfoService;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@BasePathAwareController
@RequestMapping(value = "/application")
public class ApplicationController {

	private final ApplicationService applicationService;

	private final BuildInfoService buildInfoService;

	public ApplicationController(ApplicationService applicationService, BuildInfoService buildInfoService) {
		this.applicationService = applicationService;
		this.buildInfoService = buildInfoService;
	}

	@GetMapping(path = "/status")
	@ResponseBody
	public ResponseEntity getApplicationStatus() {
		String appStatus = applicationService.getApplicationStatus();
		return ResponseEntity.ok(appStatus);
	}

	@GetMapping(path = "/version")
	@ResponseBody
	public ResponseEntity getBuildVersion() {
		String buildVersion = buildInfoService.getBuilldVersion();
		return ResponseEntity.ok(buildVersion);
	}

}
