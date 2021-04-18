package com.wbl.util;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class RequestSpecUtil {

	public RequestSpecification getRequestSpecificationUtil(String baseURI) {

		RestAssured.baseURI = baseURI;
		RequestSpecification httpRequest = RestAssured.given();
		return httpRequest;

	}
}
