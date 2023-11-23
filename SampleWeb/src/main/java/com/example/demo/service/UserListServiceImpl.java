package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.constant.ExecuteResult;
import com.example.demo.dto.UserListInfo;
import com.example.demo.dto.UserSearchInfo;
import com.example.demo.entity.Users;
import com.example.demo.repository.UsersRepository;
import com.example.demo.util.AppUtil;
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
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UserListInfo> editUserListByParam(UserSearchInfo dto){
		return toUserListInfos(findUsersByParam(dto));
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ExecuteResult deleteUsersById(String loginId) {
		var users = repository.findById(loginId);
		if(users.isEmpty()) {
			return ExecuteResult.ERROR;
		}
		
		repository.deleteById(loginId);
		
		return ExecuteResult.SUCCEED;
	}
	
	/**
	 * ユーザー情報の条件検索を行い、検索結果を返却する
	 * 
	 * @param dto 入力情報
	 * @return 検索結果
	 */
	private List<Users> findUsersByParam(UserSearchInfo dto){
		var loginIdParam = AppUtil.addWildcard(dto.getLoginId());
		
		if(dto.getUserStatusKind() != null && dto.getAuthorityKind() != null) {
			return repository.findByLoginIdLikeAndUserStatusKindAndAuthorityKind(loginIdParam,
					dto.getUserStatusKind(), dto.getAuthorityKind());
		} else if(dto.getUserStatusKind() != null) {
			return repository.findByLoginIdLikeAndUserStatusKind(loginIdParam, dto.getUserStatusKind());
		} else if(dto.getAuthorityKind() != null) {
			return repository.findByLoginIdLikeAndAuthorityKind(loginIdParam, dto.getAuthorityKind());
		} else {
			return repository.findByLoginIdLike(loginIdParam);
		}
	}
	
	/**
	 * ユーザー情報EntityのListをユーザー一覧情報DTOのListに変換
	 * 
	 * @param userInfos ユーザー情報EntityのList
	 * @return ユーザ一覧情報DTOのList
	 */
	private List<UserListInfo> toUserListInfos(List<Users> userInfos){
		var userListInfos = new ArrayList<UserListInfo>();
		for (Users users : userInfos) {
			var userListInfo = mapper.map(users, UserListInfo.class);
			userListInfo.setStatus(users.getUserStatusKind().getDisplayValue());
			userListInfo.setAuthority(users.getAuthorityKind().getDisplayValue());
			userListInfos.add(userListInfo);
		}
		
		return userListInfos;
	}

}
