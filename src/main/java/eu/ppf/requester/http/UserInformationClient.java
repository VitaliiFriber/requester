package eu.ppf.requester.http;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import eu.ppf.requester.dto.Post;
import eu.ppf.requester.dto.User;
import eu.ppf.requester.entities.PostEntity;
import eu.ppf.requester.entities.UserEntity;
import eu.ppf.requester.exeptions.UserNotFoundException;
import eu.ppf.requester.mapper.MapperDTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserInformationClient {
    private HttpClient httpClient;

    public UserInformationClient() {
        this.httpClient = new HttpClient();
    }

    public User getUserInformation(String server, String userId) throws UserNotFoundException {
        User user = getUser(server, userId);

        if (!user.toString().equals("{}")) {
            List<Post> posts = getUserPost(server, userId);
            user.setPosts(posts);
        } else {
            throw new UserNotFoundException();
        }

        return user;
    }

    private User getUser(String server, String userId) {
        User user = new User();

        try {
            String response = httpClient.makeGetRequest(server + "/users/" + userId);


            UserEntity userEntity = new Gson().fromJson(response, UserEntity.class);

            user = MapperDTO.mappingUserEntityToUser(userEntity);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return user;
    }

    private List<Post> getUserPost(String server, String userId) {
        List<Post> resultPosts = new ArrayList<>();

        try {

            String requestURL = server + "/posts?userId=" + userId;

            String response = httpClient.makeGetRequest(requestURL);

            Gson gson = new Gson();

            ArrayList<PostEntity> posts = gson.fromJson(response, new TypeToken<ArrayList<PostEntity>>() {
            }.getType());

            resultPosts = MapperDTO.mappingPostEntitiesToPost(posts);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return resultPosts;
    }
}
