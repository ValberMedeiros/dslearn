package com.devsuperior.dslearnbds.resources;

import com.devsuperior.dslearnbds.dto.NotificationDTO;
import com.devsuperior.dslearnbds.services.NotificationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications")
public class NotificationResource {

    private NotificationService service;

    public NotificationResource(NotificationService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<NotificationDTO>> notificationForCurrentUser(
            @RequestParam(name = "onreadOnly", defaultValue = "false") Boolean onreadOnly,
            Pageable pageable
    ) {
        return ResponseEntity.ok(service.notificationsForCurrentUser(onreadOnly, pageable));
    }
}
