package com.cmddotenter.WebLabProject.Service;

import com.cmddotenter.WebLabProject.Entity.User;
import com.cmddotenter.WebLabProject.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {



    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(int id) {
       Optional<User> result = userRepository.findById(id);
         User user = null;
            if (result.isPresent()) {
                user = result.get();
            } else {
                throw new RuntimeException("Did not find user id - " + id);
            }
        return user;
    }

    @Transactional
    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Transactional
    @Override
    public void delete(int id) {
        userRepository.deleteById(id);
    }
}
