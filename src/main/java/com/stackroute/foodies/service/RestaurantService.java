package com.stackroute.foodies.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.foodies.domain.Restaurant;
import com.stackroute.foodies.repository.RestaurantRepository;

@Service
public class RestaurantService {
	
	@Autowired
	public RestaurantRepository restaurantRepository;
    
	static List<Restaurant> resultList = new ArrayList<Restaurant>();
// 		   new Restaurant(1, "social", "sddasc", 200),
//    			new Restaurant(21, "ascl", "sddefsc", 300),
//    			new Restaurant(311, "sacvha", "sac", 400)));
    
    public List<Restaurant> getAllRestaurant( )
    {
    	List<Restaurant> restaurantList = (List<Restaurant>) restaurantRepository.findAll();
        return restaurantList;
    }
    

    public void addRestaurant(Restaurant restaurant)
    {
    	restaurantRepository.save(restaurant);
   
    }
    public void deleteRestauranat(int id)
    {	
    	 for(Restaurant restaurant : restaurantRepository.findAll()){
             if(restaurant.getId() == id){
                 restaurantRepository.delete(id);;
             }
    	 }
    }
    public static Restaurant findById(int id) {
        for(Restaurant restaurant : resultList){
            if(restaurant.getId() == id){
                return restaurant;
            }
        }
        return null;
    }
    
   public static Restaurant  findByName(String name) {
        for(Restaurant restaurant : resultList){
            if(restaurant.getName().equalsIgnoreCase(name)){
                return restaurant;
            }
        }
        return null;
    }
   
   public static void updateRestaurant(Restaurant restaurant) {
       int index= resultList.indexOf(restaurant);
       resultList.set(index, restaurant);
   }

    
   
}
 