package ru.petrov.subscriptions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.petrov.subscriptions.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
