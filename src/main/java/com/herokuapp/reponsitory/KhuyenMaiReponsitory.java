package com.herokuapp.reponsitory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.herokuapp.entity.Dskhuyenmai;

@Repository
@Transactional(rollbackFor = Exception.class)
public interface KhuyenMaiReponsitory extends CrudRepository<Dskhuyenmai, String> {

}
