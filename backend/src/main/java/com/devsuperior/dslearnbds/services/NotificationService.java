package com.devsuperior.dslearnbds.services;

import com.devsuperior.dslearnbds.dto.NotificationDTO;
import com.devsuperior.dslearnbds.entities.Notification;
import com.devsuperior.dslearnbds.repositories.NotificationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NotificationService {

    private NotificationRepository repository;
    private AuthService authService;

    public NotificationService(NotificationRepository repository, AuthService authService) {
        this.repository = repository;
        this.authService = authService;
    }

    @Transactional(readOnly = true)
    public Page<NotificationDTO> notificationsForCurrentUser(boolean onreadOnly, Pageable pageable) {
        var user = authService.authenticated();
        Page<Notification> page = repository.find(user, onreadOnly, pageable);
        return page.map(NotificationDTO::new);
    }

}
