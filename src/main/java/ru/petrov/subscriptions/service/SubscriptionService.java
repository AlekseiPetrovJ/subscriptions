package ru.petrov.subscriptions.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.petrov.subscriptions.model.Subscription;
import ru.petrov.subscriptions.model.TypeSubscription;
import ru.petrov.subscriptions.repository.SubscriptionRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final  UserService userService;
    private final TypeSubscriptionService typeSubscriptionService;

    @Transactional
    public Subscription addSubscription(Long userId, Subscription subscription) {
        subscription.setUser(userService.getUser(userId));
        subscription.setTypeSubscription(typeSubscriptionService.getTypeByName(subscription.getTypeSubscription().getName()));
        return subscriptionRepository.save(subscription);
    }

    public List<Subscription> getSubscriptionsByUser(Long userId) {
        return subscriptionRepository.getSubscriptionsByUser_Id(userId);
    }

    public Subscription getSubscriptions(Long subId) {
        return subscriptionRepository.findById(subId).orElseThrow(() -> new EntityNotFoundException("Подписка не найдена."));
    }

    @Transactional
    public void deleteSubscription(Long userId, Long subId) {
        if (!existsById(subId) | getSubscriptions(subId).getUser().getId()!=userId) {
            throw new EntityNotFoundException("Подписка у пользователя не найдена.");
        }

        subscriptionRepository.deleteById(subId);
    }

    public boolean existsById(Long id) {
        return subscriptionRepository.existsById(id);
    }

    public List<TypeSubscription> getTopSubscriptions(Pageable pageable) {
        return subscriptionRepository.getTopSubscriptions(pageable);
    }
}
