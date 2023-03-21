package ua.kv.klykavka.andrii.gallaryproject.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

@Document
public class Post {
    @Id
    private String id;
    @Field
    @NotNull(message = "Please provide a title")
    @Size(min = 3, max = 54, message = "Title size must be between 3 and 54 chars")
    private String title;
    @Field
    @NotNull(message = "Please provide a post content")
    @Size(min = 15  , message = "Post content must be at least 15 chars")
    private String description;
    @Field
    private Date date = new Date();
    @Field
    private String author;

    public Post() {
    }

    public Post(String title, String description, String author) {
        this.title = title;
        this.description = description;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", author='" + author + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(title, post.title) && Objects.equals(description, post.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
