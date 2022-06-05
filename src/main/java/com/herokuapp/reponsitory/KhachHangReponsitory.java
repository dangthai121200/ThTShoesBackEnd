package com.herokuapp.reponsitory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.herokuapp.entity.Khachhang;


@Repository
public interface KhachHangReponsitory extends CrudRepository<Khachhang, String> {

}
