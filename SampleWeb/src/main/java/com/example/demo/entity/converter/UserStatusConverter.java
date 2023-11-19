package com.example.demo.entity.converter;

import com.example.demo.constant.UserStatusKind;

import jakarta.persistence.AttributeConverter;

/**
 * ユーザー情報　ユーザー状態種別フィールドConverterクラス
 * 
 * @author yk
 *
 */
public class UserStatusConverter implements AttributeConverter<UserStatusKind, Boolean> {
	
	/**
	 * 引数で受け取ったユーザー状態種別Enumを、利用可否のbooleanに変換する
	 * 
	 * @param ユーザー状態種別Enum
	 * @return 引数で受け取ったユーザー状態種別Enumに保管されているboolean
	 */
	@Override
	public Boolean convertToDatabaseColumn(UserStatusKind userStatus) {
		return userStatus.isDisabled();
	}
	
	/**
	 * 引数で受け取った利用可否を、ユーザー状態種別Enumに変換する
	 * 
	 * @param 利用可否(利用不可ならtrue)
	 * @return 引数で受け取った利用可否から逆引きしたユーザー状態種別Enum
	 */
	@Override
	public UserStatusKind convertToEntityAttribute(Boolean isDisabled) {
		return isDisabled ? UserStatusKind.DISABLED : UserStatusKind.ENABLED;
	}

	
	

}
