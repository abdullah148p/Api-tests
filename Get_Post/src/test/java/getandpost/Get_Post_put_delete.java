package getandpost;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Get_Post_put_delete {
	@Test
	public void get()
	{
		Response get= RestAssured.get("http://localhost:3000/posts/13");
		int code= get.getStatusCode();
		Assert.assertEquals(code, 200);
		System.out.println("respose code is" + code);
		
	}
	@Test
	public void print1()
	{
		Response print= RestAssured.get("http://localhost:3000/posts/1");
		String code= print.asString();
		System.out.println("Data is" + code);
		System.out.println("Respnse time is"+ print.getTime());
	}
	
	@Test
	public void post()
	
	{
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type","application/json");
        JSONObject json= new JSONObject();
        json.put("id", (int) (Math.random()*10+5));
        json.put("title","Abdullah the Tester");
        json.put("author","Abdullah");
        request.body(json.toString());
       Response post= request.post("http://localhost:3000/posts");
       int code= post.getStatusCode();
       Assert.assertEquals(code,201);
       System.out.println("code is"+code);
	}
		@Test
	public void delete()
	{
			Response del=RestAssured.delete("http://localhost:3000/posts/8.174883571934775");
			int code= del.getStatusCode();
			Assert.assertEquals(code, 200);
			System.out.println("Delete code is" + del);
	}
		@Test
		public void put()
		{
			RequestSpecification reqput=RestAssured.given();
			reqput.header("Content-Type","application/json");
			JSONObject json= new JSONObject();
			json.put("id","10");
			json.put("title","Abdullah is a Good Tester");
			json.put("author","Abdullah Zahid1");
			reqput.body(json.toString());
			Response put=reqput.put("http://localhost:3000/posts/8.382041137202746");
			int code=put.getStatusCode();
			System.out.println("update code is"+code);
					}
}
