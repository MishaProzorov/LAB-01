package com.example.SunriseSunset.service;

import com.example.SunriseSunset.model.SunriseSunsetModel;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

    @Service
    public class SunriseSunsetService {
        private final String SUN_API_URL = "https://api.sunrise-sunset.org/json";
        private final RestTemplate restTemplate;

        public SunriseSunsetService(RestTemplate restTemplate) {
            this.restTemplate = restTemplate;
        }

        public SunriseSunsetModel getSunriseSunset(double lat, double lng, String date) {
            String url = String.format("%s?lat=%f&lng=%f&date=%s&formatted=0", SUN_API_URL, lat, lng, date);
            return restTemplate.getForObject(url, SunriseSunsetModel.class);
        }
    }

