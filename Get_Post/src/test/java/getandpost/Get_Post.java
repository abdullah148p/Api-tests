package getandpost;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Get_Post 
{
	@Test
	public void test1()
	{
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type","application/json");
        JSONObject json= new JSONObject();
        json.put("id",Math.random()*10+5);
        json.put("title","Abdullah the Tester");
        json.put("author","Abdullah");
        request.body(json.toString());
       Response response= request.post("http://localhost:3000/posts");
       int code= response.getStatusCode();
       Assert.assertEquals(code,201);
       System.out.println("code is"+code);
	}
	}
