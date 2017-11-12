package utilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import apiModels.CustomResponse;
import apiModels.RequestBody;

public class WebServiceRunner {

	private static CustomResponse resp;
	private static ObjectMapper mapper = new ObjectMapper();
	
	public static void runGetRequest(String resource){
		String url = Config.getProperty("apiURL") + resource;
		Response response = RestAssured.get(url);
//		System.out.println("Response String: " + response.asString());
		System.out.println("Service status: " + response.statusCode());
		try {
			resp = mapper.readValue(response.asString(), CustomResponse.class);
		} catch (Exception e) {
			System.out.println("conversion failed");
		} 
	}
	
	public static void runPostRequest(RequestBody body, String resource){
		String url = Config.getProperty("apiURL") + resource;
		Response response;
		if(Config.getProperty("headerCheck").equalsIgnoreCase("N")){
			response = RestAssured.given().contentType(ContentType.JSON).body(body).when()
					.post(url);
		}else{
			response = RestAssured.given().headers(HeaderManager.getHeaders()).contentType(ContentType.JSON).body(body).when()
					.post(url);
		}
		
		//System.out.println("Response String: " + response.asString());
		System.out.println("Service status: " + response.statusCode());
		try {
			resp = mapper.readValue(response.asString(), CustomResponse.class);
		} catch (Exception e) {
			System.out.println("conversion failed");
		} 
	}
	
	public static CustomResponse getResponse(){
		if(resp != null)
			return resp;
		System.out.println("request not ran yet");
		return null;
	}
}
