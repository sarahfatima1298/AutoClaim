package com.example.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.Application;
import com.example.entity.AutoClaim;
import com.example.service.DemoService;

@RunWith(PowerMockRunner.class)
@PrepareForTest({DemoService.class})
@SpringBootTest(classes = Application.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class DemoControllerTest {

	@InjectMocks
	DemoController demoController;

	@Mock
	DemoService demoService;

	public DemoService getDemoService() {
		return demoService;
	}

	public void setDemoService(DemoService demoService) {
		this.demoService = demoService;
	}


	@Test
	public void getdetailsTest() throws Exception {
		MockitoAnnotations.initMocks(this);

		//DemoService spy = PowerMockito.spy(getDemoService());

		AutoClaim mockedItem= new AutoClaim();
		mockedItem.setClaimstatus("success");
		mockedItem.setContactnumber("123456");
		//PowerMockito.doReturn(mockedItem).when(spy).getlist();
		given(getDemoService().getlist()).willReturn(mockedItem);

		ResponseEntity<AutoClaim> response = demoController.getdetails();
		assertThat(response.getBody()).isEqualTo(mockedItem);


	}
	@Test
	public void addTest(){
		MockitoAnnotations.initMocks(this);

		AutoClaim mockedItem= new AutoClaim();
		mockedItem.setClaimstatus("success");
		mockedItem.setContactnumber("123456");
		ResponseEntity<Void> entity = new ResponseEntity<Void>(HttpStatus.OK);
		ResponseEntity<Void> response = demoController.add(mockedItem);
		assertThat(response).isEqualTo(entity);

	}
	@Test
	public void ModifyTest(){
		MockitoAnnotations.initMocks(this);

		AutoClaim mockedItem= new AutoClaim();
		mockedItem.setClaimstatus("success");
		mockedItem.setContactnumber("123456");
		Long id=123L;
		given(getDemoService().delete(id)).willReturn(true);

		boolean status = demoController.modify(id);
		assertThat(status).isEqualTo(true);

	}
}
