package com.stackroute.foodies.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.stackroute.foodies.controller.*;
import com.stackroute.foodies.domain.Restaurant;
import com.stackroute.foodies.service.RestaurantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1.0/restaurantservice")
public class Controller {

	@Autowired
    private RestaurantService restaurantService;

	@RequestMapping("/restaurant")
    public ResponseEntity getAllRestaurant( )
    {
       List<Restaurant> resultList1 = restaurantService.getAllRestaurant();
        
        return new ResponseEntity<List<Restaurant>>(resultList1, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/restaurant/{id}", method = RequestMethod.GET)
    public ResponseEntity <Restaurant> getRestaurantById(@PathVariable("id") Integer id) {
        
        System.out.println("1");
      
       Restaurant restaurant = RestaurantService.findById(id);
        if (restaurant == null) {
            return new ResponseEntity<Restaurant>(HttpStatus.NOT_FOUND);
        }
            return new ResponseEntity<Restaurant>(restaurant, HttpStatus.OK);
    }
	
	@RequestMapping(method=RequestMethod.POST, value="/restaurant")
    public ResponseEntity addRestaurant(@RequestBody Restaurant restaurant)
    {
        /*Add validation code*/        
		restaurantService.addRestaurant(restaurant);
        return new ResponseEntity<String>("Done bro", HttpStatus.OK);
        
    }
	@RequestMapping(method=RequestMethod.DELETE , value="/restaurant/id/{id}")
    public ResponseEntity deleteRestaurant(@PathVariable("id") Integer id)
    {
        /*Add validation code*/        
		restaurantService.deleteRestauranat(id);
        return new ResponseEntity<String>("Deleted bro", HttpStatus.OK);
        
    }
	
	@RequestMapping(value = "/movies/id/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateRestaurant(@PathVariable("id") int id, @RequestBody Restaurant restaurant) {
        
 
        Restaurant currentRestaurant = RestaurantService.findById(id);
 
        if (currentRestaurant == null) {
            
            return new ResponseEntity<String>("id not found",HttpStatus.NOT_FOUND);
        }
 
        currentRestaurant.setId(restaurant.getId());
        currentRestaurant.setName(restaurant.getName());
        currentRestaurant.setUrlPic(restaurant.getUrlPic());
        currentRestaurant.setCost_for_two(restaurant.getCost_for_two());
 
        RestaurantService.updateRestaurant(currentRestaurant);
        return new ResponseEntity<Restaurant>(currentRestaurant, HttpStatus.OK);
    }
	

}