package sample.web.mongodb;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import sample.web.controller.UserData;

public interface UserDataRepository extends MongoRepository<UserData, String> {

//    public UserData findByName(String name);
//    public List<UserData> findBySurname(String surname);

}
