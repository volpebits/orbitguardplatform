package com.example.orbitguardplatform.service;

import com.example.orbitguardplatform.dto.NotificationDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class NasaService {

    private final RestClient restClient;
    private final String API_KEY = "UesmQFR79VhqISH2Z4yh4BQL9U9HdRmggDIM7SaY";
    private final String NASA_BASE_URL = "https://api.nasa.gov/DONKI/notifications";

    public NasaService() {
        this.restClient = RestClient.create();
    }

    public List<NotificationDTO> getSpaceNotifications(String startDate, String endDate, String type) {
        String url = UriComponentsBuilder.fromHttpUrl(NASA_BASE_URL)
                .queryParam("startDate", startDate)
                .queryParam("endDate", endDate)
                .queryParam("type", type)
                .queryParam("api_key", API_KEY)
                .toUriString();

        return restClient.get()
                .uri(url)
                .retrieve()
                .body(new ParameterizedTypeReference<List<NotificationDTO>>() {});
    }
}
