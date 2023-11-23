package com.example.demo.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 処理結果種別
 * 
 * @author yk
 *
 */
@Getter
@AllArgsConstructor
public enum ExecuteResult {
	
	/* エラーなし */
	SUCCEED(MsgConst.USERLIST_DELETE_SUCCEED),
	
	/* エラーあり */
	ERROR(MsgConst.USERLIST_NON_EXISTED_LOGIN_ID);
	
	/** メッセージID */
	private String messageId;
}
