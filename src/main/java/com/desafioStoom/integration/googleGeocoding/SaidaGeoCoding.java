package com.desafioStoom.integration.googleGeocoding;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SaidaGeoCoding {

    @JsonProperty("results")
    private List<Result> results;

    public SaidaGeoCoding() {}

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Result{

        @JsonProperty("geometry")
        public Geometry geometry;

        public Result() {
        }

        public Geometry getGeometry() {
            return geometry;
        }

        public void setGeometry(Geometry geometry) {
            this.geometry = geometry;
        }
    }


    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Geometry {

        @JsonProperty("location")
        public Location location;

        public Geometry() {

        }

        public Location getLocation() {
            return location;
        }

        public void setLocation(Location location) {
            this.location = location;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Location {

        public Double lat;
        public Double lng;

        public Location() {
        }

        public Double getLat() {
            return lat;
        }

        public void setLat(Double lat) {
            this.lat = lat;
        }

        public Double getLng() {
            return lng;
        }

        public void setLng(Double lng) {
            this.lng = lng;
        }
    }

}
