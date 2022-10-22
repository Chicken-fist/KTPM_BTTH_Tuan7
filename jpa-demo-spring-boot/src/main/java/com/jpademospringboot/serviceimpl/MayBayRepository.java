package com.jpademospringboot.serviceimpl;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jpademospringboot.entity.MayBay;

@Repository
public interface MayBayRepository extends JpaRepository<MayBay, Integer> {
	
	@Query(value = "select * from maybay where TamBay > 10000", nativeQuery = true)
	List<MayBay> getMayBayByTamBay();
	
	@Query(value = "select count(*) from maybay where loai like 'Boeing%'", nativeQuery = true)
	Integer getSoMayBayBoeing();
	
	@Query(value = "select Loai from maybay m join chungnhan c on c.MaMB = m.MaMB join nhanvien n "
			+ " on n.MaNV = c.MaNV where n.Ten  like 'Nguyen%' ", nativeQuery = true)
	List<String> getLoaiMayBayNhanVienHoNguyenLai();
	
	//cau 11
	@Query(value = "select m.MaMB from maybay m "
			+ " join chungnhan vn on vn.MaMB = m.MaMB  "
			+ " join nhanVien nv on nv.MaNV = vn.MaNV "
			+ " where Ten like '%Nguyen%'", nativeQuery = true)
	List<Integer> findMaMBNguyenLai();
	
	//Cau 13
	@Query(value = "select loai from MayBay "
			+ " where tambay >= "
			+ " (select dodai from chuyenbay "
			+ " where MaCB like 'VN280') ", nativeQuery = true)
	List<String> findLoaiMayBayVN280();
	
	//Cau 16
	@Query(value = "select m.MaMB,Loai, count(MaNV) as 'TongPhiCong' from maybay m left join chungnhan c on m.MaMB = c.MaMB where c.MaNV is not null \r\n"
			+ "	group by m.MaMB,Loai ", nativeQuery = true)
	List<Object> findMayBayVoiTongSoNguoi();

}
