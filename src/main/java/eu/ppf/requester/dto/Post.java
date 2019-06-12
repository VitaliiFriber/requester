package eu.ppf.requester.dto;

import eu.ppf.requester.utils.Converter;

public class Post {
    private String id;
    private String title;

    public Post(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public Post() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return new Converter<Post>().convertToJson(this);
    }
}
