package com.wbl.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wbl.base.BaseTest;
import com.wbl.basetimp.RequestImp;

public class Runner {

	private BaseTest baseTest;

	@BeforeClass
	public void initialize() {
		baseTest = new RequestImp();
	}

	// @Test
	public void getTest() {
		baseTest = new RequestImp();
		baseTest.get("/users?page=2");
	}

	// @Test
	public void postTest() {
		baseTest.post("/users");
	}

	@Test
	public void deleteTest() {
		baseTest.delete("/users/2");
	}

}
