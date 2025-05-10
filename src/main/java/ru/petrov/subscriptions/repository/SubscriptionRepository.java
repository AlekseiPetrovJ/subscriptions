package ru.petrov.subscriptions.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.petrov.subscriptions.model.Subscription;
import ru.petrov.subscriptions.model.TypeSubscription;

import java.util.List;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    List<Subscription> getSubscriptionsByUser_Id(Long id);

    @Query("SELECT t FROM Subscription s JOIN s.typeSubscription t GROUP BY t.id ORDER BY COUNT(s) DESC, t.id")
    List<TypeSubscription> getTopSubscriptions(Pageable pageable);
}
