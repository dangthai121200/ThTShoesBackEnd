package com.herokuapp.reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.herokuapp.entity.SoluongPhukien;

@Repository
@Transactional(rollbackFor = Exception.class)
public interface SoLuongPhuKienReponsitory extends JpaRepository<SoluongPhukien, Integer> {
}
