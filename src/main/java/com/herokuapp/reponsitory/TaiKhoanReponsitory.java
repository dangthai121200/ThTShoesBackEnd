package com.herokuapp.reponsitory;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.herokuapp.entity.Taikhoan;

@Repository
@Transactional(rollbackFor = Exception.class)
public interface TaiKhoanReponsitory extends CrudRepository<Taikhoan, String> {

	@Query("Select tk from Taikhoan tk where tk.username = :username")
	Taikhoan getTaiKhoanByUsername(@Param("username") String username);

	@Query("Select tk from Taikhoan tk where tk.email = :email")
	Taikhoan getTaiKhoanByEmail(@Param("email") String email);

	@Query("Select tk from Taikhoan tk where tk.username = :username and tk.password = :password")
	Taikhoan getTaiKhoanByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

	@Modifying(clearAutomatically = true)
	@Query("update Taikhoan tk set tk.password = :password where tk.manguoidung = :manguoidung")
	void changePassword(@Param("password") String newPassowrd, @Param("manguoidung") String manguoidung);

	@Modifying(clearAutomatically = true)
	@Query("update Taikhoan tk set tk.tinhtrang = :tinhtrang where tk.manguoidung = :manguoidung")
	void updateTinhTrang(@Param("manguoidung") String manguoidung, @Param("tinhtrang") Byte tinhtrang);

}
