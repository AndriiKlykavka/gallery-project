package ua.kv.klykavka.andrii.gallaryproject.services;

import com.mongodb.client.model.Filters;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kv.klykavka.andrii.gallaryproject.models.Post;
import ua.kv.klykavka.andrii.gallaryproject.repositories.PostRepository;

import javax.management.Query;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository repository;

    @Autowired
    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public List<Post> getPosts() {
        return repository.findAll();
    }

    public Post getPostById(String id) {
        Bson filter = Filters.gt("id", id);
        repository.findById(id).ifPresent(System.out::println);
            return null;
    }
}
