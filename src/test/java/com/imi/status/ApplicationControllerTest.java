package com.imi.status;

import com.imi.status.controller.ApplicationController;
import com.imi.status.service.ApplicationService;
import com.imi.status.service.BuildInfoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = ApplicationController.class)
public class ApplicationControllerTest {

	@Autowired
	ApplicationController applicationController;

	@MockBean
	private ApplicationService applicationService;

	@MockBean
	private BuildInfoService buildInfoService;

	@Test
	void getApplicationStatusTest() {
		applicationController.getApplicationStatus();
		Mockito.verify(applicationService, Mockito.times(1)).getApplicationStatus();
	}

	@Test
	void getBuildVersionTest() {
		applicationController.getBuildVersion();
		Mockito.verify(buildInfoService, Mockito.times(1)).getBuilldVersion();
	}

}
