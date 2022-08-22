package kr.dong.spring.user.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kr.dong.spring.user.entity.Users;

@Repository
public interface UserRepository extends CrudRepository<Users, String>{

	List<Users> findAllByOrderByIdDesc();

//	void userInsert(Users users);
//
//	Users userDetail(int id);
//
//	void userUpdate(Users users);
//
//	void userDelete(int id);

	
	
}
