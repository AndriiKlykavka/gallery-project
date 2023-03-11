package ua.kv.klykavka.andrii.gallaryproject.services;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import ua.kv.klykavka.andrii.gallaryproject.models.Post;
import ua.kv.klykavka.andrii.gallaryproject.repositories.PostRepository;

import java.util.Date;
import java.util.List;
import java.util.Objects;

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
        return mongoTemplate.findAll(Post.class);
    }

    public Post getPost(ObjectId id) {
        Post post = mongoTemplate.findById(id, Post.class);
        return post;
    }

    public void deletePost(String id) {
        mongoTemplate.remove(Objects.requireNonNull(mongoTemplate.findById(id, Post.class)));
    }

    public void addPost(Post post) {
        mongoTemplate.save(post);
    }

    public void editPost(Post post) {
        System.out.println("HERE 2");
        System.out.println(post);
        System.out.println("HERE 3");
        System.out.println(mongoTemplate.findById("640b84e55b65b873ab97bb5e", Post.class));

        System.out.println(mongoTemplate.findById(post.getId(), Post.class) == null);
        if(mongoTemplate.findById(post.getId(), Post.class) != null)
            mongoTemplate.save(post);
        else
            throw new RuntimeException("Post Id is invalid!");
    }
}
