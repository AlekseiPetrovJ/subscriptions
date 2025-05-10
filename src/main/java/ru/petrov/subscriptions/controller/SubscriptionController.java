package ru.petrov.subscriptions.controller;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.petrov.subscriptions.model.Subscription;
import ru.petrov.subscriptions.service.SubscriptionService;

import java.util.List;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/users/{userId}/subscriptions")
public class SubscriptionController {
    private final SubscriptionService subscriptionService;

    @PostMapping
    public ResponseEntity<Subscription> addSubscription(@PathVariable Long userId, @RequestBody Subscription subscription) {
        return new ResponseEntity(subscriptionService.addSubscription(userId, subscription), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Subscription>> getSubscriptions(@PathVariable Long userId) {
        return new ResponseEntity(subscriptionService.getSubscriptionsByUser(userId), HttpStatus.OK);
    }

    @DeleteMapping("/{sub_id}")
    public ResponseEntity<Void> deleteSubscription(@PathVariable Long userId, @PathVariable Long sub_id) {
        subscriptionService.deleteSubscription(userId, sub_id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFound(EntityNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
