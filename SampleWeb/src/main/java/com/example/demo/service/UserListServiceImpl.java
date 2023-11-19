package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.UserListInfo;
import com.example.demo.entity.Users;
import com.example.demo.repository.UsersRepository;
import com.github.dozermapper.core.Mapper;

import lombok.RequiredArgsConstructor;

/**
 * ユーザー一覧画面Service実装クラス
 * 
 * @author yk
 *
 */
@Service
@RequiredArgsConstructor
public class UserListServiceImpl implements UserListService {
	
	/** ユーザー情報テーブルDAO */
	private final UsersRepository repository;
	
	/** Dozer Mapper */
	private final Mapper mapper;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UserListInfo> editUserList() {
		return toUserListInfos(repository.findAll());
	}
	
	private List<UserListInfo> toUserListInfos(List<Users> userInfos){
		var userListInfos = new ArrayList<UserListInfo>();
		for (Users users : userInfos) {
			var userListInfo = mapper.map(users, UserListInfo.class);
			userListInfo.setStatus(users.getStatus().getDisplayValue());
			userListInfo.setAuthority(users.getAuthority().getDisplayValue());
			userListInfos.add(userListInfo);
		}
		
		return userListInfos;
	}

}
