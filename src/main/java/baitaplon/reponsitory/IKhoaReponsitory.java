package baitaplon.reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import baitaplon.model.khoa;

public interface IKhoaReponsitory  extends JpaRepository<khoa, String>{


}
