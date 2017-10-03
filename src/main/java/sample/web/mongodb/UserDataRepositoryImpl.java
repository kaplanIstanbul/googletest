package sample.web.mongodb;

import sample.web.controller.UserData;

public abstract class UserDataRepositoryImpl implements UserDataRepository{

	@Override
	public <S extends UserData> S save(S entity) {
//		entity.setId(String.valueOf(count()+1));
		return save(entity);
	}

}
