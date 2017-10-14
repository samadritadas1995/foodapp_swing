package com.stackroute.foodies.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.stackroute.foodies.App;
import com.stackroute.foodies.domain.Restaurant;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerTest extends TestCase {
	
	String restaurant1;
	
	@LocalServerPort
	private int port;
	
	TestRestTemplate restTemplate = new TestRestTemplate();
	
	HttpHeaders headers = new HttpHeaders();
	
	Restaurant restaurant;
	
	@Before
    public void setUp() throws Exception {
         restaurant = new Restaurant(4,"Pizza hut","Paul Dawson",25);
    }
	
	private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
	
	@After
    public void tearDown() throws Exception {
    }
    @Test
    public void testAddRestaurant() throws Exception {
        HttpEntity<Restaurant> entity = new HttpEntity<Restaurant>(restaurant, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/v1.0/restaurantservice/restaurant"),
                HttpMethod.POST, entity, String.class);
        assertNotNull(response);
        String actual = response.getBody();
        System.out.println(actual);
        assertEquals("Done bro",actual);
    }
    
    @Test
    public void testGetAllRestaurant() throws Exception {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("v1.0/restaurantservice/restaurant"),
                HttpMethod.GET, entity, String.class);
        assertNotNull(response);
    }
    
    @Test
    public void testgetRestaurantById() throws Exception{
        HttpEntity<Restaurant> entity = new HttpEntity<Restaurant>(restaurant, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("v1.0/restaurantservice/restaurant/1"),
                HttpMethod.GET, entity, String.class);
        assertNotNull(response);
//        String actual = response.getRestaurantById(1);
////        System.out.println(actual);
//        assertEquals("{"id":1,"name":"Social","urlPic":"www.social.com","cost_for_two":700}",actual);
    }
    
    @Test
    public void testdeleteRestaurantById() throws Exception{
        HttpEntity<Restaurant> entity = new HttpEntity<Restaurant>(restaurant, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("v1.0/restaurantservice/restaurant/1"),
                HttpMethod.DELETE, entity, String.class);
        assertNotNull(response);
        String actual = response.getBody();
        System.out.println(actual);
        assertEquals("Deleted bro",actual);
//        String actual = response.getRestaurantById(1);
////        System.out.println(actual);
//        assertEquals("{"id":1,"name":"Social","urlPic":"www.social.com","cost_for_two":700}",actual);
    }
    
    
	public void testGetAllRestaurants() {
		fail("Not yet implemented");
	}

	public void testAddTopic() {
		fail("Not yet implemented");
	}

	public void testObject() {
		fail("Not yet implemented");
	}

	public void testGetClass() {
		fail("Not yet implemented");
	}

	public void testHashCode() {
		fail("Not yet implemented");
	}

	public void testEquals() {
		fail("Not yet implemented");
	}

	public void testClone() {
		fail("Not yet implemented");
	}

	public void testToString() {
		fail("Not yet implemented");
	}

	public void testNotify() {
		fail("Not yet implemented");
	}

	public void testNotifyAll() {
		fail("Not yet implemented");
	}

	public void testWaitLong() {
		fail("Not yet implemented");
	}

	public void testWaitLongInt() {
		fail("Not yet implemented");
	}

	public void testWait() {
		fail("Not yet implemented");
	}

	public void testFinalize() {
		fail("Not yet implemented");
	}

}
