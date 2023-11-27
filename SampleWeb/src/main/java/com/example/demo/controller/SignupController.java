package com.example.demo.controller;

import java.util.Optional;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.constant.MessageConst;
import com.example.demo.constant.SignupMessage;
import com.example.demo.constant.UrlConst;
import com.example.demo.constant.ViewNameConst;
import com.example.demo.entity.Users;
import com.example.demo.form.SignupForm;
import com.example.demo.service.SignupService;
import com.example.demo.util.AppUtil;

import lombok.RequiredArgsConstructor;

/** ユーザー登録画面　ControllerでServiceクラスを呼び出したり画面の入力値を受け取ったり、遷移先の画面を呼び出している
 * 
 * @author yk
 *
 */

@Controller
@RequiredArgsConstructor
public class SignupController {
	
	/** ユーザー登録画面Serviceクラス */
	private final SignupService service;
	
	/** メッセージソース */
	private final MessageSource messageSource;
	
	/** 初期表示
	 * 
	 * @param model モデル
	 * @param form 入力情報
	 * @return 表示画面
	 */
	@GetMapping(UrlConst.SIGNUP)
	public String view(Model model, SignupForm form) {
		return ViewNameConst.SIGNUP;
	}
	
	/** ユーザー登録
	 * 
	 * @param model モデル
	 * @param form 入力情報
	 * @param bdResult 入力チェック結果
	 * @return 表示画面
	 */
	@PostMapping(UrlConst.SIGNUP)
	public void signup(Model model, @Validated SignupForm form, BindingResult bdResult) {
		if(bdResult.hasErrors()) {
			editGuideMessage(model, MessageConst.FORM_ERROR, true);
			return;
		}
		
		var usersOpt = service.resistUsers(form);
		var signupMessage =  judgeMessageKey(usersOpt);
		editGuideMessage(model, signupMessage.getMessageId(), signupMessage.isError());
	}
	
	/**
	 * 画面に表示するガイドメッセージを設定する
	 * @param model モデル
	 * @param messages メッセージID
	 * @param isError エラー有無
	 */
	private void editGuideMessage(Model model, String messages, boolean isError) {
		var messageId = AppUtil.getMessage(messageSource, messages);
		model.addAttribute("message", messageId);
		model.addAttribute("isError", isError);
	}
	/**
	 * ユーザー情報登録の結果メッセージキーを判断する
	 * 
	 * @param usersOpt ユーザー登録結果(登録済みだった場合はEmpty)
	 * @return メッセージキー
	 */
	public SignupMessage judgeMessageKey(Optional<Users> usersOpt) {
		if(usersOpt.isEmpty()) {
			return SignupMessage.EXISTED_LOGIN_ID;
		}else {
			return SignupMessage.SUCCEED;
		}
	}
}
	

