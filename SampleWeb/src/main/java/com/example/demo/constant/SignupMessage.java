package com.example.demo.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ユーザー登録結果メッセージEnumクラス
 * 
 * @author yk
 *
 */
@Getter
@AllArgsConstructor
public enum SignupMessage {
	
	/** 登録成功 */
	SUCCEED(MsgConst.SIGNUP_RESIST_SUCCEED, false),
	
	/** 既に登録されているログインID */
	EXISTED_LOGIN_ID(MsgConst.SIGNUP_EXISTED_LOGIN_ID, true);
	
	/** メッセージID */
	private String messageId;
	
	/** エラー有無 */
	private boolean isError;
	

}
