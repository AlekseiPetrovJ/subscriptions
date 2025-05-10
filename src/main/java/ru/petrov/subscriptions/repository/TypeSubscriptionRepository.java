package ru.petrov.subscriptions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.petrov.subscriptions.model.TypeSubscription;

import java.util.Optional;

@Repository
public interface TypeSubscriptionRepository extends JpaRepository<TypeSubscription, Long> {
    Optional<TypeSubscription> findByName(String name);
}
