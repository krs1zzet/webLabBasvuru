package com.cmddotenter.WebLabProject.Service;

import com.cmddotenter.WebLabProject.Entity.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();
    public User getById(int id);
    public User save(User user);
    public void delete(int id);
}
