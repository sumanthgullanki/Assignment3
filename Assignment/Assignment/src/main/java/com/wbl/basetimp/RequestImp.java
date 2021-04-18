package com.wbl.basetimp;

import java.util.Properties;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;

import com.wbl.base.BaseTest;
import com.wbl.dataproviders.ConfigFileReader;
import com.wbl.util.RequestSpecUtil;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestImp implements BaseTest {

	private RequestSpecUtil reqSpe;
	private ConfigFileReader con;

	public void call() {
		con = new ConfigFileReader();
	}

	public RequestImp() {
		call();
		reqSpe = new RequestSpecUtil();
	}

	public void get(String endURL) {
		Properties pro = con.getProperties();
		int getStatusCode = Integer.parseInt(pro.getProperty("getstatuscode"));
		RequestSpecification httpRequest = reqSpe.getRequestSpecificationUtil(pro.getProperty("baseURI"));
		Response response = httpRequest.request(Method.GET, endURL);

		int statsCode = response.getStatusCode();
		Assert.assertEquals(statsCode, getStatusCode);
		System.out.println("Response status code :" + statsCode);

		System.out.println("Response payload :" + response.getBody().asString());
		System.out.println("Response header :" + response.headers());

	}

	public void post(String endURL) {
		Properties pro = con.getProperties();
		int postStatusCode = Integer.parseInt(pro.getProperty("poststatuscode"));
		RequestSpecification request = reqSpe.getRequestSpecificationUtil(pro.getProperty("baseURI"));
		request.header("Content-Type", "application/json");

		JSONObject json = new JSONObject();
		try {
			json.put("id", "4");
			json.put("email", "george.bluth@reqres.in");
			json.put("first_name", "Geo");
			json.put("last_name", "Berge");
			json.put("url", "https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		request.body(json.toString());

		Response response = request.request(Method.POST, endURL);
		int statsCode = response.getStatusCode();
		Assert.assertEquals(statsCode, postStatusCode);
		System.out.println("Response status code :" + statsCode);

		System.out.println("Response payload :" + response.getBody().asString());
		System.out.println("Response header :" + response.headers());
	}

		public void delete(String endURL) {
		Properties pro = con.getProperties();
		int deleteStatusCode = Integer.parseInt(pro.getProperty("deletestatuscode"));
		RequestSpecification request = reqSpe.getRequestSpecificationUtil(pro.getProperty("baseURI"));

		Response response = request.request(Method.DELETE, endURL);
		int statsCode = response.getStatusCode();
		Assert.assertEquals(statsCode, deleteStatusCode);
		System.out.println("Response status code :" + statsCode);

		System.out.println("Response payload :" + response.getBody().asString());
		System.out.println("Response header :" + response.headers());
	}

}
