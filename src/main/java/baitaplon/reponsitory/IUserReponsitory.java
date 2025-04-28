package baitaplon.reponsitory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import baitaplon.model.user;

@Repository
public interface IUserReponsitory extends JpaRepository<user, Long> {
	boolean existsByUserName(String userName);
	 Optional<user> findByUserName(String username);

}
