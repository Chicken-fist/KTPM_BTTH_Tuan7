package com.jpademospringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpademospringboot.entity.MayBay;
import com.jpademospringboot.serviceimpl.MayBayRepository;

@RestController
@RequestMapping("/may-bay")
public class MayBayController {

	@Autowired
	MayBayRepository mayBayRepository;

	@GetMapping("/tamBayTren10000")
	public List<MayBay> getMayBayTheoTamBay() {
		return mayBayRepository.getMayBayByTamBay();
	}
	
	@GetMapping("/getSoMayBayLoaiBoeing")
	public Integer getSoMayBayLoaiBoeing() {
		return mayBayRepository.getSoMayBayBoeing();
	}
	
	@GetMapping("/getLoaiMayBayNhanVienHoNguyenLai")
	public List<String> getLoaiMayBayNhanVienHoNguyenLai() {
		return mayBayRepository.getLoaiMayBayNhanVienHoNguyenLai();
	}
	
	//cau 11
	@GetMapping("/getMaMBNguyenLai")
	public List<Integer> getMaMBNguyenLai() {
		return mayBayRepository.findMaMBNguyenLai();
	}
	
	//Cau 13
	@GetMapping("/getLoaiMayBayVN280")
	public List<String> getLoaiMayBayVN280() {
		return mayBayRepository.findLoaiMayBayVN280();
	}
	
	//Cau 16
		@GetMapping("/getMayBayVoiTongSoNguoi")
		public List<Object> getMayBayVoiTongSoNguoi() {
			return mayBayRepository.findMayBayVoiTongSoNguoi();
		}

}
