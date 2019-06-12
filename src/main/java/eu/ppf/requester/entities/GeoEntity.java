package eu.ppf.requester.entities;

import eu.ppf.requester.utils.Converter;

public class GeoEntity {
    private String lat;
    private String lng;

    public GeoEntity(String lat, String lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public GeoEntity() {
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }


    @Override
    public String toString() {
        return new Converter<GeoEntity>().convertToJson(this);
    }
}
