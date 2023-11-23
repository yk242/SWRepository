package com.example.demo.util;

import java.util.Locale;

import org.springframework.context.MessageSource;

/**
 * アプリケーション共通クラス 
 * @author yk
 *
 */
public class AppUtil {
	/**
	 * メッセージIDからメッセージを取得する
	 * 
	 * @param messageSource メッセージソース
	 * @param messageId メッセージID
	 * @param params 置換文字群
	 * @return メッセージ
	 */
	public static String getMessage(MessageSource messageSource, String messageId, Object... params) {
		return messageSource.getMessage(messageId, params, Locale.JAPAN);
	}
	
	/**
	 * DBのLIKE検索用に、パラメーターにワイルドカードを付与する
	 * 
	 * @param param パラメーター
	 * @return 前後にワイルドカードが付いたパラメーター
	 */
	public static String addWildcard(String param) {
		return "%" + param + "%";
	}
}
