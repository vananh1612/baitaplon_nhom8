package baitaplon.reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import baitaplon.model.nganh;

public interface INganhReponsitory extends JpaRepository<nganh, String>{
//	@Query("SELECT k.ten_nganh FROM nganh k")
//	 List<String> findAllTenNganh();
}