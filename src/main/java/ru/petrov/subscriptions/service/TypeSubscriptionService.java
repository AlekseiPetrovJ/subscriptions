package ru.petrov.subscriptions.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.petrov.subscriptions.model.TypeSubscription;
import ru.petrov.subscriptions.repository.TypeSubscriptionRepository;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class TypeSubscriptionService {
    private final TypeSubscriptionRepository typeSubscriptionRepository;

    @Transactional
    public TypeSubscription createType(TypeSubscription typeSubscription) {
        return typeSubscriptionRepository.save(typeSubscription);
    }

    public TypeSubscription getType(Long id) {
        return typeSubscriptionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Тип подписки не найден."));
    }

    public TypeSubscription getTypeByName(String name) {
        return typeSubscriptionRepository.findByName(name).orElseThrow(() -> new EntityNotFoundException("Тип подписки не найден."));
    }
}
