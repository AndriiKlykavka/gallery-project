package ua.kv.klykavka.andrii.gallaryproject.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ua.kv.klykavka.andrii.gallaryproject.models.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
