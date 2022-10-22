package com.jpademospringboot.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jpademospringboot.entity.ChuyenBay;
import com.jpademospringboot.service.ChuyenBayService;

@Service
public class ChuyenBayServiceImpl implements ChuyenBayService {

    private RestTemplate restTemplate;
    private String theCrmRest;

    @Autowired
    public ChuyenBayServiceImpl() {
        this.restTemplate = new RestTemplate();
        theCrmRest = "http://localhost:9091/chuyenbay";
    }
    
    @Override
    public List<ChuyenBay> findChuyenBayByGaDen() {
        ResponseEntity<List<ChuyenBay>> responseEntity = restTemplate.exchange(theCrmRest + "/gaDenDaLat",
                HttpMethod.GET, null,
                new ParameterizedTypeReference<List<ChuyenBay>>() {
                });
        List<ChuyenBay> list = responseEntity.getBody();

        return list;
    }


//	@Query(value = "select * from chuyenbay where DoDai < 10000 and DoDai > 8000", nativeQuery = true)
//	List<ChuyenBay> findChuyenBayCoDoDaiLonHon10000VaBeHon8000();
//
//	@Query(value = "select * from chuyenbay where GaDi = 'SGN' and GaDen = 'BMV'", nativeQuery = true)
//	List<ChuyenBay> findChuyenBayTuSGDiBMT();
//
//	@Query(value = "select * from chuyenbay where GaDi = 'SGN' ", nativeQuery = true)
//	List<ChuyenBay> findChuyenBayTuSG();
//
//	// Cau 14
//	@Query(value = " select * from chuyenbay " + " where dodai < (select tambay from maybay "
//			+ " where Loai like '%Airbus A320%') ", nativeQuery = true)
//	List<ChuyenBay> findChuyenBayBoiMayBayA320();
//
//	// Cau 17
//	@Query(value = " select * from chuyenbay where GaDi in ( select GaDen from chuyenbay) and GaDen in (select GaDi from chuyenbay)", nativeQuery = true)
//	List<ChuyenBay> findDuongBayDiThang();
//
//	// Cau 18
//	@Query(value = "select GaDi, count(MaCB) as 'SoChuyen' from  chuyenbay group by GaDi ", nativeQuery = true)
//	List<Object> findChuyenBayTuMoiGa();
//
//	// Cau 19
//	@Query(value = " select GaDi, sum(ChiPhi) as " + " 'ChiPhi' from  chuyenbay group by GaDi ", nativeQuery = true)
//	List<Object> findChiPhiChuyenBayMoiGa();
//
//	// Cau 20
//	@Query(value = "  select * from chuyenbay where Hour(gioDi) < 12", nativeQuery = true)
//	List<ChuyenBay> findChuyenBayKhoiHanhTruoc12h();
//
//	// Cau 21
//	@Query(value = "select GaDi, count(MaCB) as "
//			+ " 'SoChuyen' from  chuyenbay where Hour(gioDi) < 12 group by GaDi ", nativeQuery = true)
//	List<Object> findSoChuyenBayGaDiTrc12h();
//
//	// Cau 28
//	@Query(value = "select * from chuyenbay where "
//			+ " dodai < all (select tambay from maybay where loai like '%boeing%')", 
//			nativeQuery = true)
//	List<ChuyenBay> findChuyenBayLaBoeing();

    

}
