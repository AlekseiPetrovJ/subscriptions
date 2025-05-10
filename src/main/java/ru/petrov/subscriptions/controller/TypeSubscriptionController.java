package ru.petrov.subscriptions.controller;

import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.petrov.subscriptions.model.TypeSubscription;
import ru.petrov.subscriptions.service.SubscriptionService;
import ru.petrov.subscriptions.service.TypeSubscriptionService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/subscriptions")
public class TypeSubscriptionController {
    private final TypeSubscriptionService typeSubscriptionService;
    private final SubscriptionService subscriptionService;

    @PostMapping
    public ResponseEntity<TypeSubscription> addSubscription(@RequestBody TypeSubscription typeSubscription) {
        return new ResponseEntity(typeSubscriptionService.createType(typeSubscription), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TypeSubscription>> getSubscriptions(@PathVariable Long typeId) {
        return new ResponseEntity(typeSubscriptionService.getType(typeId), HttpStatus.OK);
    }

    @GetMapping("/top")
    public ResponseEntity<List<TypeSubscription>> getTopSubscriptions(@ParameterObject Pageable pageable) {
        return new ResponseEntity(subscriptionService.getTopSubscriptions(pageable), HttpStatus.OK);
    }
}
