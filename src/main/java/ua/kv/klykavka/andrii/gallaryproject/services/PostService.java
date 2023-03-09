package ua.kv.klykavka.andrii.gallaryproject.services;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import ua.kv.klykavka.andrii.gallaryproject.models.Post;
import ua.kv.klykavka.andrii.gallaryproject.repositories.PostRepository;

import java.util.List;

@Service
public class PostService {

    private final PostRepository repository;
    private final MongoTemplate mongoTemplate;

    @Autowired
    public PostService(PostRepository repository, MongoTemplate mongoTemplate) {
        this.repository = repository;
        this.mongoTemplate = mongoTemplate;
    }

    public List<Post> getPosts() {
        return repository.findAll();
    }

    public Post getPostById(ObjectId id) {
        Post post = mongoTemplate.findById(id, Post.class);
        return post;
    }
}
