package baitaplon.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import baitaplon.dto.KhoaDTO;
import baitaplon.dto.LopDTO;
import baitaplon.dto.NganhDTO;
import baitaplon.dto.SinhVienDTO;
import baitaplon.service.impl.KhoaService;
import baitaplon.service.impl.LopService;
import baitaplon.service.impl.NganhService;
import baitaplon.service.impl.SinhVienService;
import baitaplon.service.impl.UserService;

@Controller
public class SinhVienController {

	@Autowired
	private LopService lopService;
	@Autowired
	private SinhVienService sinhVienService;

	@GetMapping("/list_sinhvien")
	public String danhSachSinhVien(Model model) {
		List<LopDTO> dsLop = lopService.findAll();
		if (dsLop == null) {
			dsLop = new ArrayList<>();
		}
		List<SinhVienDTO> dsSinhVien = sinhVienService.findAll();
		if (dsSinhVien == null) {
			dsSinhVien = new ArrayList<>();
		}
		model.addAttribute("dsLop", dsLop);
		model.addAttribute("dsSinhVien", dsSinhVien);

		return "sinhvien/list_sinhvien";
	}

//router thêm ngành
	@GetMapping("/add_sinhvien")
	public String addSinhVien(Model model) {
		model.addAttribute("sinhvien", new SinhVienDTO());

		// Lấy danh sách khoa để đổ vào select
		List<LopDTO> dsLop = lopService.findAll();
		model.addAttribute("dsLop", dsLop);

		return "sinhvien/add_sinhvien"; // Tên file HTML trong thư mục templates
	}

	@PostMapping("/add_sinhvien")
	public String saveSinhVien(@ModelAttribute("sinhvien") SinhVienDTO sinhVienDTO) {
		sinhVienService.save(sinhVienDTO);
		return "redirect:/list_sinhvien";
	}

//ROUTER EDIT NGÀNH
	@GetMapping("/edit_sinhvien/{id}")
	public ModelAndView editSinhVien(@PathVariable("id") String id, Model model) {
		// Lấy thông tin khoa hiện tại từ database
		SinhVienDTO sinhVienDTO = sinhVienService.findById(id);

		// Nếu không tìm thấy khoa với ID, trả về trang lỗi hoặc trang danh sách khoa
		if (sinhVienDTO == null) {
			return new ModelAndView("redirect:/list_sinhvien");
		}
		List<LopDTO> dsLop = lopService.findAll();
		model.addAttribute("dsLop", dsLop);
		model.addAttribute("sinhvien", sinhVienDTO); // Truyền thông tin khoa vào model
		return new ModelAndView("sinhvien/edit_sinhvien"); // Trả về view "edit_khoa.html"
	}

	@PostMapping("/edit_sinhvien")
	public String updateNganh(@ModelAttribute("sinhvien") SinhVienDTO sinhVienDTO) {
		try {
			sinhVienService.editSinhVien(sinhVienDTO);
			return "redirect:/list_sinhvien"; // Redirect về trang home sau khi cập nhật thành công
		} catch (IllegalArgumentException e) {
			return "redirect:/edit_sinhvien/" + sinhVienDTO.getID() + "?error=" + e.getMessage();
		}
	}

	// DELETE NGÀNH
	@GetMapping("/delete_sinhvien/{id}")
	public String deleteSinhVien(@PathVariable("id") String id) {
		try {
			sinhVienService.deleteSinhVien(id); // Gọi phương thức trong Service để xóa
		} catch (Exception e) {
			// Nếu có lỗi (ví dụ: không tìm thấy khoa), có thể log hoặc trả về thông báo
			return "redirect:/list_sinhvien?error=SinhVien Không Tồn Tại";
		}
		return "redirect:/list_sinhvien"; // Điều hướng lại về trang danh sách khoa
	}

}