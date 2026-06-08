package com.example.orbitguardplatform.controller;

import com.example.orbitguardplatform.dto.NotificationDTO;
import com.example.orbitguardplatform.service.NasaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nasa")
@CrossOrigin(origins = "*")
public class NasaController {

    private final NasaService nasaService;

    public NasaController(NasaService nasaService) {
        this.nasaService = nasaService;
    }

    @GetMapping("/notifications")
    public ResponseEntity<List<NotificationDTO>> getNotifications(
            @RequestParam(defaultValue = "2014-05-01") String startDate,
            @RequestParam(defaultValue = "2014-05-08") String endDate,
            @RequestParam(defaultValue = "all") String type) {
        
        List<NotificationDTO> notifications = nasaService.getSpaceNotifications(startDate, endDate, type);
        return ResponseEntity.ok(notifications);
    }
}
