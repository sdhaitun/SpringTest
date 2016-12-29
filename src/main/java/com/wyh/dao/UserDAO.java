package com.wyh.dao;

import com.wyh.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by root on 2016/12/29.
 */
public interface UserDAO extends JpaRepository<User, Integer> {
}
