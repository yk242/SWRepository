package com.example.demo.controller;

import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.constant.UrlConst;
import com.example.demo.constant.ViewNameConst;
import com.example.demo.form.LoginForm;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

/** このクラスはログイン画面　ControllerでServiceクラスを呼び出したり画面の入力値を受け取ったり、遷移先の画面を呼び出している
 * 
 * @author yk
 *
 */

@Controller
@RequiredArgsConstructor
public class LoginController {
	
	/** セッション情報 */
	private final HttpSession session;
	
	/** 初期表示
	 * 
	 * @param model モデル
	 * @param form 入力情報
	 * @return 表示画面
	 */
	@GetMapping(UrlConst.LOGIN)
	public String view(Model model, LoginForm form) {
		return ViewNameConst.LOGIN;
	}
	
	/** ログインエラー画面表示
	 * 
	 * @param model モデル
	 * @param form 入力情報
	 * @return 表示画面
	 */
	@GetMapping(value = UrlConst.LOGIN, params ="error")
	public String viewWithError(Model model, LoginForm form) {
		var errorInfo = (Exception)session.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		model.addAttribute("errorMsg", errorInfo.getMessage());
		return ViewNameConst.LOGIN;
	}
	
}
