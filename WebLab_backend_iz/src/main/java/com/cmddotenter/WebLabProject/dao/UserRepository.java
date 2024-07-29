package com.cmddotenter.WebLabProject.dao;

import com.cmddotenter.WebLabProject.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}
