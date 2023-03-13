package ua.kv.klykavka.andrii.gallaryproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import ua.kv.klykavka.andrii.gallaryproject.models.User;
import ua.kv.klykavka.andrii.gallaryproject.repositories.UserRepository;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;
    private final MongoTemplate mongoTemplate;

    @Autowired
    public UserService(UserRepository repository, MongoTemplate mongoTemplate) {
        this.repository = repository;
        this.mongoTemplate = mongoTemplate;
    }

    public List<User> getUsers(){
        return mongoTemplate.findAll(User.class);
    }

    public void registerUser(User user){
        mongoTemplate.save(user);
    }

    public User getUserByEmail(String email, String password) {
        Query query = new Query(Criteria.where("email").is(email));
        return mongoTemplate.findOne(query, User.class);
    }
}
