package baitaplon.reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import baitaplon.model.lop;

public interface ILopReponsitory extends JpaRepository<lop, String> {

}
