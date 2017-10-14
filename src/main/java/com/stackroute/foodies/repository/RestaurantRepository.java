package com.stackroute.foodies.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.stackroute.foodies.domain.Restaurant;

@Component
public interface RestaurantRepository extends CrudRepository<Restaurant, Integer>{

}
