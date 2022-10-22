package com.microserverchuyenbay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.microserverchuyenbay.entity.ChuyenBay;

@Repository
public interface ChuyenBayRepository extends JpaRepository<ChuyenBay, String> {

	List<ChuyenBay> findChuyenBayByGaDen(String gaden);

	@Query(value = "select * from chuyenbay where DoDai < 10000 and DoDai > 8000", nativeQuery = true)
	List<ChuyenBay> findChuyenBayCoDuongBayNhoHon10000VaLonHon8000();

	@Query(value = "select * from chuyenbay where GaDi = 'SGN' and GaDen = 'BMV'", nativeQuery = true)
	List<ChuyenBay> findChuyenBayCoGaDiSaiGonGaDenBuonMaThuoc();

	@Query(value = "select count(*) from chuyenbay where GaDi = 'SGN'", nativeQuery = true)
	Integer findChuyenBayCoGaDiSaiGon();

	@Query(value = "select * from chuyenbay c where DoDai <= 4168", nativeQuery = true)
	List<ChuyenBay> chuyenBayDuocThucHienBoiAirbusA320();

	@Query(value = "select * from chuyenbay where GaDi in ( select GaDen from chuyenbay) and GaDen in (select GaDi from chuyenbay)", nativeQuery = true)
	List<ChuyenBay> getDuongBayDiRoiTroVe();

	@Query(value = "select GaDi, count(MaCB) as 'SoChuyen' from  chuyenbay group by GaDi ", nativeQuery = true)
	List<Object> getChuyenBayKhoiHanhTuGa();

	@Query(value = "select  GaDi, sum(ChiPhi) as TongChiPhi from chuyenbay group by GaDi", nativeQuery = true)
	List<Object> tongChiPhi();

	@Query(value = "select * from chuyenbay where Hour(GioDi) < 12", nativeQuery = true)
	List<ChuyenBay> chuyenBayKhoiHanhTruoc12Gio();

	@Query(value = "select GaDi, count(MaCB) as 'SoChuyen' from  chuyenbay where Hour(GioDi) < 12 group by GaDi ", nativeQuery = true)
	List<Object> soChuyenBayXuatPhatTruoc12GioTaiMoiGa();

	@Query(value = "select * from chuyenbay where dodai < all (select tambay from maybay where loai like '%boeing%')", nativeQuery = true)
	List<ChuyenBay> chuyenBayCoTheThucHienBoeing();
}
