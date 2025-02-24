package com.example.SunriseSunset.controller;

import com.example.SunriseSunset.model.SunriseSunsetModel;
import com.example.SunriseSunset.service.SunriseSunsetService;
import org.springframework.ui.Model;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SunriseSunsetController {

    private final SunriseSunsetService sunService;

    public SunriseSunsetController(SunriseSunsetService sunService) {
        this.sunService = sunService;
    }

    @GetMapping("/")//гет заросы по корневом каталогу
    public String home(Model model) {
        //выводит на экран//
        model.addAttribute("name", "Главная страница");
        return "Home";
    }

    @GetMapping("/sun/times")
    public ResponseEntity<SunriseSunsetModel> getSunriseSunset(
            @RequestParam double lat,
            @RequestParam double lng,
            @RequestParam String date) {

        SunriseSunsetModel sunResponse = sunService.getSunriseSunset(lat, lng, date);
        return ResponseEntity.ok(sunResponse);
    }
}
