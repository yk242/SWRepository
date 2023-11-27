package com.example.demo.service;

import java.util.Optional;

import com.example.demo.dto.UserEditResult;
import com.example.demo.dto.UserUpdateInfo;
import com.example.demo.entity.Users;

/**
 * ユーザー編集画面Serviceクラス
 * 
 * @author yk
 *
 */
public interface UserEditService {

	/**
	 * ログインIDを使ってユーザー情報テーブルを検索し、検索結果を返却する
	 * 
	 * @param loginId ログインID
	 * @return 該当のユーザー情報テーブル登録情報
	 */
	public Optional<Users> searchUsers(String loginId);
	
	/**
	 * ユーザー情報テーブルを更新する
	 * 
	 * @param UserUpdateInfo ユーザー更新情報
	 * @return 更新結果
	 */
	public UserEditResult updateUsers(UserUpdateInfo userUpdateInfo);
}
