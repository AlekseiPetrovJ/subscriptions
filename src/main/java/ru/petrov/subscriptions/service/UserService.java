package ru.petrov.subscriptions.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.petrov.subscriptions.model.User;
import ru.petrov.subscriptions.repository.UserRepository;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Пользователь не найден."));
    }

    @Transactional
    public User updateUser(Long id, User userUpdate) {
        User user = getUser(id);
        user.setUsername(userUpdate.getUsername());
        return userRepository.save(user);
    }

    @Transactional
    public void deleteUser(Long id) {
        if (!existsById(id)) {
            throw new EntityNotFoundException("Пользователь не найден.");
        }
        userRepository.deleteById(id);
    }

    public Page<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public boolean existsById(Long id) {
        return userRepository.existsById(id);
    }
}
