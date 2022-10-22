package com.microserverchuyenbay.comtroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microserverchuyenbay.entity.ChuyenBay;
import com.microserverchuyenbay.repository.ChuyenBayRepository;

@RequestMapping("/chuyenbay")
@RestController
public class ChuyenBayController {

	@Autowired
	ChuyenBayRepository chuyenBayRepository;

	// 1. Cho biết các chuyến bay đi Đà Lạt (DAD).
	@GetMapping("/gaDenDaLat")
	public List<ChuyenBay> chuyenBayDenDaLat() {
		return chuyenBayRepository.findChuyenBayByGaDen("DAD");
	}

	// 4. Cho biết các chuyến bay có độ dài đường bay nhỏ hơn 10.000km và lớn hơn
	// 8.000km.
	@GetMapping("/duongBayNhoHon10000LonHon8000")
	public List<ChuyenBay> chuyenBayCoDuongBayNhoHon10000VaLonHon8000() {
		return chuyenBayRepository.findChuyenBayCoDuongBayNhoHon10000VaLonHon8000();
	}

	// 5. Cho biết các chuyến bay xuất phát từ Sài Gòn (SGN) đi Ban Mê Thuộc (BMV).
	@GetMapping("/chuyenBayXuatPhatSaiGonDiBuonMeThuoc")
	public List<ChuyenBay> chuyenBayXuatPhatSaiGonDiBuonMeThuoc() {
		return chuyenBayRepository.findChuyenBayCoGaDiSaiGonGaDenBuonMaThuoc();
	}

	// 6. Có bao nhiêu chuyến bay xuất phát từ Sài Gòn (SGN).
	@GetMapping("/soChuyenBayXuatPhatTuSaiGon")
	public Integer chuyenBayXuatPhatTuSaiGon() {
		return chuyenBayRepository.findChuyenBayCoGaDiSaiGon();
	}

	// 14. Cho biết các chuyến bay có thể ñược thực hiện bởi máy bay Airbus A320.
	@GetMapping("/chuyenBayDuocThucHienBoiAirbusA320")
	public List<ChuyenBay> chuyenBayDuocThucHienBoiAirbusA320() {
		return chuyenBayRepository.chuyenBayDuocThucHienBoiAirbusA320();
	}

	// 17. Giả sử một hành khách muốn đi thẳng từ ga A đến ga B rồi quay trở về ga
	// A. Cho biết các đường bay nào có thể đáp ứng yêu cầu này.
	@GetMapping("/getDuongBayDiRoiTroVe")
	public List<ChuyenBay> getDuongBayDiRoiTroVe() {
		return chuyenBayRepository.getDuongBayDiRoiTroVe();
	}

	// 18. Với mỗi ga có chuyến bay xuất phát từ đó cho biết có bao nhiêu chuyến bay
	// khởi hành từ ga đó.
	@GetMapping("/chuyenBayKhoiHanhTuGa")
	public List<Object> chuyenBayKhoiHanhTuGa() {
		return chuyenBayRepository.getChuyenBayKhoiHanhTuGa();
	}

	// 19. Với mỗi ga có chuyến bay xuất phát từ đó cho biết tổng chi phí phải trả
	// cho phi công lái các chuyến bay khởi hành từ ga đó.
	@GetMapping("/tongChiPhi")
	public List<Object> tongChiPhi() {
		return chuyenBayRepository.tongChiPhi();
	}

	// 20. Cho biết danh sách các chuyến bay có thể khởi hành trước 12:00
	@GetMapping("/chuyenBayKhoiHanhTruoc12Gio")
	public List<ChuyenBay> chuyenBayKhoiHanhTruoc12Gio() {
		return chuyenBayRepository.chuyenBayKhoiHanhTruoc12Gio();
	}

	// 21. Với mỗi địa điểm xuất phát cho biết có bao nhiêu chuyến bay có thể khởi
	// hành trước 12:00.
	@GetMapping("/soChuyenBayXuatPhatTruoc12GioTaiMoiGa")
	public List<Object> soChuyenBayXuatPhatTruoc12GioTaiMoiGa() {
		return chuyenBayRepository.soChuyenBayXuatPhatTruoc12GioTaiMoiGa();
	}

	// 28. Tìm các chuyến bay có thể được thực hiện bởi tất cả các loại máy bay
	// Boeing.
	@GetMapping("/chuyenBayCoTheThucHienBoeing")
	public List<ChuyenBay> chuyenBayCoTheThucHienBoeing() {

		return chuyenBayRepository.chuyenBayCoTheThucHienBoeing();
	}

	@PostMapping("/themChuyeBay")
	public String themChuyenBay(@RequestBody ChuyenBay chuyenBay) {

		chuyenBayRepository.save(chuyenBay);

		return "redirect:/";
	}

	@DeleteMapping("/xoaChuyenBay/{id}")
	public String xoaChuyenBay(@PathVariable("id") String id) {

		chuyenBayRepository.deleteById(id);

		return "redirect:/";
	}
}
