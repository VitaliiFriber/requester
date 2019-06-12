package eu.ppf.requester.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Converter<T> {
    public String convertToJson(T obj) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(obj);
    }
}
