package com.herokuapp.reponsitory;

import com.herokuapp.entity.NhanvienDonhang;
import com.herokuapp.entity.NhanvienDonhangPK;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(rollbackFor = Exception.class)
public interface NhanVienDonHangReponsitory extends JpaRepository<NhanvienDonhang, NhanvienDonhangPK> {

}
