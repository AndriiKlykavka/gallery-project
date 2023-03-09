package ua.kv.klykavka.andrii.gallaryproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ua.kv.klykavka.andrii.gallaryproject.models.Post;
import ua.kv.klykavka.andrii.gallaryproject.repositories.PostRepository;
import java.time.ZonedDateTime;
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
			postRepository.save(new Post("River Run", "Once upon a time...", new Date(), "Andrew Kl"));
			postRepository.save(new Post("John Story", "It was a dark dark night...", new Date(), "Roger Fe"));
			postRepository.save(new Post("Bash Run", "Once upon a time...", new Date(), "Andrew Kl"));
			postRepository.save(new Post("Cira Story", "Seemed so good...", new Date(), "David Fera"));
			postRepository.save(new Post("Woe Story", "Happy to find you...", new Date(), "New Ostin"));
			postRepository.save(new Post("Dreadling Story", "3 weeks a day...", new Date(), "Lloyd Gar"));
		}

	}
}
