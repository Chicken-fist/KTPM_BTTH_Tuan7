package com.jpademospringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpademospringboot.entity.NhanVien;
import com.jpademospringboot.serviceimpl.NhanVienRepository;

@RestController
@RequestMapping("/nhan-vien")
public class NhanVienController {

	@Autowired
	NhanVienRepository nhanVienRepository;

	@GetMapping("/getLuongDuoiChiDinh")
	public List<NhanVien> getNhanVienLuongDuoiChiDinh() {

		return nhanVienRepository.findNhanVienCoLuongDuoiLuongChiDinh();
	}

	@GetMapping("/getTongSoLuongNhanVien")
	public Integer getTongSoLuongNhanVien() {

		return nhanVienRepository.getTongSoLuongTraNhanVien();
	}

	@GetMapping("/getNhanVienLaiMayBayBoeing")
	public List<NhanVien> getNhanVienLaiMayBayBoeing() {

		return nhanVienRepository.findNhanVienLaiMayBayBoeing();
	}

	@GetMapping("/getNhanVienLaiMayBay747")
	public List<NhanVien> getNhanVienLaiMayBay747() {

		return nhanVienRepository.findNhanVienLaiMayBay747();
	}

	// Cau 12
	@GetMapping("/getNhanVienLaiMayBayBoeingVaAirbus")
	public List<NhanVien> getNhanVienLaiMayBayBoeingVaAirbus() {

		return nhanVienRepository.findNVCoTheLaiBoingNAirbus();
	}

	// Cau 15
	@GetMapping("/getTenPCLaiBoeing")
	public List<String> getTenPCLaiBoeing() {

		return nhanVienRepository.findTenPCLaiBoeing();
	}

	// Cau 22
	@GetMapping("/getMaPCLai3LoaiMB")
	public List<String> getMaPCLai3LoaiMB() {

		return nhanVienRepository.findMaPCLai3LoaiMB();
	}

	// Cau 24
	@GetMapping("/getTongMayBayMaPCLai")
	public List<Object> getTongMayBayMaPCLai() {

		return nhanVienRepository.findTongMayBayMaPCLai();
	}

	// Cau 25
	@GetMapping("/getNhanVienKoLaPhiCong")
	public List<NhanVien> getNhanVienKoLaPhiCong() {

		return nhanVienRepository.findNhanVienKoLaPhiCong();
	}

	// Cau 26
	@GetMapping("/getMaNVLuongCaoNhat")
	public List<String> getMaNVLuongCaoNhat() {

		return nhanVienRepository.findMaNVLuongCaoNhat();
	}

	// Cau 27
	@GetMapping("/getTongLuongTraPhiCong")
	public List<Integer> getTongLuongTraPhiCong() {

		return nhanVienRepository.findTongLuongTraPhiCong();
	}

}
