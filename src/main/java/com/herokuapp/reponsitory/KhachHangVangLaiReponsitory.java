package com.herokuapp.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.herokuapp.entity.Khachvanglai;

public interface KhachHangVangLaiReponsitory extends JpaRepository<Khachvanglai, String> {

}
