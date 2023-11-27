package com.example.demo.dto;

import com.example.demo.constant.UserEditMessage;
import com.example.demo.entity.Users;

import lombok.Data;

/**
 * ユーザー編集結果DTOクラス
 * 
 * @author yk
 *
 */
@Data
public class UserEditResult {

	/** ユーザー更新結果 */
	private Users updateUsers;
	
	/** ユーザー更新結果メッセージEnum */
	private UserEditMessage updateMessage;
}
