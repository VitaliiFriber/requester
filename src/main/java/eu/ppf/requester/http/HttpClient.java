package eu.ppf.requester.http;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class HttpClient {
    private OkHttpClient client;

    public HttpClient() {
        this.client = new OkHttpClient();
    }

    public String makeGetRequest(String url) throws IOException {

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.body() != null) {
                return response.body().string();
            } else {
                return "{ error: Request Error data not found!}";
            }
        }
    }

}
