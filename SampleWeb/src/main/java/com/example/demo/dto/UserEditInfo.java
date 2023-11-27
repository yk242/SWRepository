package com.example.demo.dto;

import java.time.LocalDateTime;

import lombok.Data;

/**
 * ユーザー情報DTOクラス
 * 
 * @author yk
 *
 */
@Data
public class UserEditInfo {

	/** ログインID */
	private String loginId;
	
	/** ログイン失敗回数 */
	private int loginFailureCount;
	
	/** アカウントロック日時 */
	private LocalDateTime accountLockedTime;
}
