package com.herokuapp.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.herokuapp.entity.Donhang;


@Repository
@Transactional(rollbackFor = Exception.class)
public interface DonHangReponsitory extends JpaRepository<Donhang, String> {

}
