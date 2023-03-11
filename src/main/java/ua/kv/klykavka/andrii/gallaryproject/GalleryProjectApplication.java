package ua.kv.klykavka.andrii.gallaryproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ua.kv.klykavka.andrii.gallaryproject.models.Post;
import ua.kv.klykavka.andrii.gallaryproject.repositories.PostRepository;

import java.util.Date;

@SpringBootApplication
public class GalleryProjectApplication implements CommandLineRunner {

	private final PostRepository postRepository;

	@Autowired
	public GalleryProjectApplication(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(GalleryProjectApplication.class, args);
	}




	@Override
	public void run(String... args) throws Exception {
		if(postRepository.findAll().isEmpty()){
			postRepository.save(new Post("River Run", "Once upon a time...", "Andrew Kl"));
			postRepository.save(new Post("John Story", "It was a dark dark night...", "Roger Fe"));
			postRepository.save(new Post("Bash Run", "Once upon a time...", "Andrew Kl"));
			postRepository.save(new Post("Cira Story", "Seemed so good...", "David Fera"));
			postRepository.save(new Post("Woe Story", "Happy to find you...", "New Ostin"));
			postRepository.save(new Post("Gruelling Story", "3 days a week...", "Lloyd Gar"));
		}
	}
}
