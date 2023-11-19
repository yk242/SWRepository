package com.example.demo.entity;

import java.time.LocalDateTime;

import com.example.demo.constant.AuthorityKind;
import com.example.demo.constant.UserStatusKind;
import com.example.demo.entity.converter.UserAuthorityConverter;
import com.example.demo.entity.converter.UserStatusConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * ユーザー情報テーブルentity(DTO)
 * 
 * @author yk
 *
 */

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
public class Users {

	/** ログインID */
	@Id
	@Column(name = "login_id")
	private String loginId;
	
	/** パスワード */
	private String password;
	
	/** ログイン失敗回数 */
	@Column(name = "login_failure_count")
	private int loginFailureCount = 0;
	
	/** アカウントロック日時 */
	@Column(name = "account_locked_time")
	private LocalDateTime accountLockedTime;
	
	/** ユーザー状態種別 */
	@Column(name = "is_disabled")
	@Convert(converter = UserStatusConverter.class)
	private UserStatusKind status;
	
	/** ユーザー権限種別 */
	@Convert(converter = UserAuthorityConverter.class)
	private AuthorityKind authority;
	
	/**
	 * デフォルトコンストラクタ
	 */
	public Users() {
	}
	
	/**
	 * ログイン失敗回数をインクリメントする
	 * 
	 * @return ログイン失敗回数がインクリメントされたUsers
	 */
	public Users incrementLoginFailureCount() {
		return new Users(loginId, password, ++loginFailureCount, accountLockedTime, status, authority);
	}
	
	/**
	 * ログイン失敗情報をリセットする
	 * 
	 * @return ログイン失敗情報がリセットされたUsers
	 */
	public Users resetLoginFailureInfo() {
		return new Users(loginId, password, 0, null, status, authority);
	}
	
	/**
	 * アカウントロック状態にする
	 * 
	 * @return ログイン失敗階位数、アカウントロック日時が更新されたUsers
	 */
	public Users updateAccountLocked() {
		return new Users(loginId, password, 0, LocalDateTime.now(), status, authority);
	}
	
	
}
