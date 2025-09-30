package com.blog.MiniBlog.services.impl;

import com.blog.MiniBlog.enums.RoleEnum;
import com.blog.MiniBlog.models.User;
import com.blog.MiniBlog.repositories.UserRepository;
import com.blog.MiniBlog.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(final User user) {
        User existingUser = userRepository.findByName(user.getUsername());
        if (Objects.nonNull(existingUser)) {
            throw new RuntimeException(("Existing User"));
        }
        User entity = new User(user.getUserId(), user.getName(), user.getEmail(), user.getUsername(), user.getPassword(), user.getRole());
        return userRepository.save(entity);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User get(final Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("User not found")
        );
    }

    @Override
    public User update(Long id, User user) {
        return null;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
