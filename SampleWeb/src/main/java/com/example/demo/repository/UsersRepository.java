package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Users;

/**
 * ユーザー情報テーブル DAO
 * @author yk
 *
 */
public interface UsersRepository extends JpaRepository<Users, String> {
}
