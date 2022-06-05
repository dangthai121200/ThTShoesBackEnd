package com.herokuapp.reponsitory;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.herokuapp.entity.Taikhoan;

@Repository
public interface TaiKhoanReponsitory extends CrudRepository<Taikhoan, String> {

	@Query("Select tk from Taikhoan tk where tk.username = :username")
	Taikhoan getTaiKhoanByUsername(@Param("username") String username);

	@Query("Select tk from Taikhoan tk where tk.username = :username and tk.password = :password")
	Taikhoan getTaiKhoanByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
