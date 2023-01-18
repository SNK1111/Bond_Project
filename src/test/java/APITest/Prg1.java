package APITest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

/* 
  given() 
         content type, set cookies, add auth, add params,  set headers info etc...
         
         when()
                get, post, put, delete
                
               then()
                     validate status code, extract response, extract header cookies and  response body... 
*/


public class Prg1 {
	int id;

	@Test(priority = 1)
	public void getUsers(){

		given()
         .when()
		.get("https://reqres.in/api/users?page=2")
		
		.then()
		.statusCode(201)
		.body("page", equalTo(2)) //Restassured Assertion
		.log().all(); //Print Response on consol window


	}
	@Test(priority = 2)
	public void CreteUser() {
		
		HashMap data=new HashMap<>(); //Collection of java Working on key and value
		data.put("name", "Ankit");
		data.put("job", "trainer");
		
		 id=given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("https://reqres.in/api/users")
		.jsonPath().getInt("id");
		
//		.then()
//		.statusCode(201)
//		.log().all();
		
	}
	@Test(priority = 3, dependsOnMethods = {"CreteUser"})
	public void updateUser() {
		
		HashMap data=new HashMap<>(); //Collection of java Working on key and value
		data.put("name", "john");
		data.put("job", "Master");
		
		 given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.put("https://reqres.in/api/users/"+id)
		
		.then()
		.statusCode(200)
		.log().all();
		
	}
	@Test(priority = 4)
	public void deleteUser() {
		
		given()
		
		.when()
		.delete("https://reqres.in/api/users/"+id)
		.then()
		.statusCode(204)
		.log().all();
		
	}
	

}
