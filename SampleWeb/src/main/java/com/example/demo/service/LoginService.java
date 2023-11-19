package com.example.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Users;
import com.example.demo.repository.UsersRepository;

import lombok.RequiredArgsConstructor;

/**
 *  ログイン画面Service(BusinesLogic)
 * @author yk
 *
 */
@Service
@RequiredArgsConstructor
public class LoginService {
	
	/** ユーザー情報テーブルDAO */
	private final UsersRepository repository;
	
	/**
	 * ユーザー情報テーブル 主キー検索
	 * @param loginId ログインID
	 * @return 検索結果(1件)
	 */
	public Optional<Users> searchUserById(String loginId){
		return repository.findById(loginId);
	}
}
