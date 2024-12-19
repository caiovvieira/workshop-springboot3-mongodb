package com.caiovieira.workshop.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.caiovieira.workshop.entities.User;



public interface UserRepository extends MongoRepository<User, String>{

}
