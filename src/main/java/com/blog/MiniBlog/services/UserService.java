package com.blog.MiniBlog.services;

import com.blog.MiniBlog.models.User;

import java.util.List;

public interface UserService {
    User save(final User user);

    List<User> getAll();

    User get(Long id);

    User update(Long id, User user);

    void delete(Long id);
}
