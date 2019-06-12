package eu.ppf.requester.mapper;

import eu.ppf.requester.dto.Post;
import eu.ppf.requester.dto.User;
import eu.ppf.requester.entities.PostEntity;
import eu.ppf.requester.entities.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class MapperDTO {
    public static User mappingUserEntityToUser(UserEntity entity) {
        User user = new User();

        user.setName(entity.getName());
        user.setUsername(entity.getUsername());
        user.setEmail(entity.getEmail());

        return user;
    }

    public static List<Post> mappingPostEntitiesToPost(List<PostEntity> postEntities) {
        List<Post> mappedPosts = new ArrayList<>();

        for (PostEntity entity : postEntities) {

            Post post = new Post();

            post.setId(entity.getId());
            post.setTitle(entity.getTitle());

            mappedPosts.add(post);
        }

        return mappedPosts;
    }
}
