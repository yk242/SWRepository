package com.example.demo.service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.constant.AuthorityKind;
import com.example.demo.entity.Users;
import com.example.demo.form.SignupForm;
import com.example.demo.repository.UsersRepository;
import com.github.dozermapper.core.Mapper;

import lombok.RequiredArgsConstructor;

/**
 *  ユーザー登録画面Service実装クラス
 * @author yk
 *
 */
@Service
@RequiredArgsConstructor
public class SignupServiceImpl implements SignupService {
	
	/** ユーザー情報テーブルDAO */
	private final UsersRepository repository;
	
	/** Dozer Mapper */
	private final Mapper mapper;
	
	/** PasswordEncoder */
	private final PasswordEncoder passwordEncoder;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Optional<Users> resistUsers(SignupForm form){
		var usersExistedOpt = repository.findById(form.getLoginId());
		if(usersExistedOpt.isPresent()) {
			return Optional.empty();
		}

		var users = mapper.map(form, Users.class);
		var encodedPassword = passwordEncoder.encode(form.getPassword());
		users.setPassword(encodedPassword);
		users.setAuthority(AuthorityKind.ITEM_WATCHER);
		
		return Optional.of(repository.save(users));
	}
}
