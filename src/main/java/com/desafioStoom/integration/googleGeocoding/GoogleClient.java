package com.desafioStoom.integration.googleGeocoding;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "googleApi", url = "${google.api}")
public interface GoogleClient {

    @GetMapping()
    ResponseEntity<SaidaGeoCoding> getGeoCoding(@RequestParam("address") String endereco, @RequestParam("key") String key);

    //https://maps.googleapis.com/maps/api/geocode/json?address=Washington+Luis+114,+Centro,+Amparo,+SP&key=AIzaSyCj0cY2yEvVfYhAaTz3-P2MW-YRKmhz5Uw

}
