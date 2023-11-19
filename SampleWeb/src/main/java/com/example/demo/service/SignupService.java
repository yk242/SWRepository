package com.example.demo.service;

import java.util.Optional;

import com.example.demo.entity.Users;
import com.example.demo.form.SignupForm;

/**
 * ユーザー登録画面インターフェース
 * 
 * @author yk
 *
 */
public interface SignupService {
	
	/**
	 * ユーザー情報テーブル 新規登録
	 * @param form 入力情報
	 * @return 登録情報(ユーザー情報Entity)、既に同じユーザーIDで登録がある場合はEmpty
	 */
	public Optional<Users> resistUsers(SignupForm form);
}
