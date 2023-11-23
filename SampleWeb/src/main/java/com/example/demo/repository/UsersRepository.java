package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.constant.AuthorityKind;
import com.example.demo.constant.UserStatusKind;
import com.example.demo.entity.Users;

/**
 * ユーザー情報テーブルRepositoryクラス
 * 
 * @author yk
 *
 */
public interface UsersRepository extends JpaRepository<Users, String> {
	
	/**
	 * ログインID(部分一致）使って検索
	 * 
	 * @param loginId ログインID
	 * @return 検索でヒットしたユーザーの情報のリスト
	 */
	List<Users> findByLoginIdLike(String loginId);
	
	/**
	 * ログインID(部分一致)、アカウント状態(完全一致)の項目を使って検索する
	 * 
	 * @param loginId ログインID
	 * @param userStatusKind アカウント状態
	 * @return 検索でヒットしたユーザーの情報のリスト
	 */
	List<Users> findByLoginIdLikeAndUserStatusKind(String loginId, UserStatusKind userStatusKind);
	
	/**
	 * ログインID(部分一致)、権限(完全一致)の項目を使って検索する
	 * 
	 * @param loginId ログインID
	 * @param authorityKind 権限
	 * @return 検索でヒットしたユーザーの情報のリスト
	 */
	List<Users> findByLoginIdLikeAndAuthorityKind(String loginId, AuthorityKind authorityKind);
	
	/**
	 * ログインID(部分一致)、アカウント状態(完全一致)、権限(完全一致)の項目を使って検索する
	 * 
	 * @param loginId ログインID
	 * @param userStatusKind アカウント状態
	 * @param authorityKind 権限
	 * @return 検索でヒットしたユーザーの情報のリスト
	 */
	List<Users> findByLoginIdLikeAndUserStatusKindAndAuthorityKind(String loginId, UserStatusKind userStatusKind,
			AuthorityKind authorityKind);

}
