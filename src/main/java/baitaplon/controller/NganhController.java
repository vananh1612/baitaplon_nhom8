package baitaplon.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import baitaplon.dto.KhoaDTO;
import baitaplon.dto.LopDTO;
import baitaplon.dto.NganhDTO;
import baitaplon.model.khoa;
import baitaplon.model.lop;
import baitaplon.model.nganh;
import baitaplon.reponsitory.ILopReponsitory;
import baitaplon.service.impl.KhoaService;
import baitaplon.service.impl.LopService;
import baitaplon.service.impl.NganhService;

import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class NganhController {


	@Autowired
	private KhoaService khoaService;

	@Autowired
	private NganhService nganhService;


	@GetMapping("/list_nganh")
	public String listKhoa(Model model) {
		List<NganhDTO> dsNganh = nganhService.findAll();
		if (dsNganh == null) {
			dsNganh = new ArrayList<>();
		}
		model.addAttribute("dsNganh", dsNganh);

		
		return "nganh/list_nganh";
	}
	
//router thêm ngành
	@GetMapping("/add_nganh")
	public String addNganh(Model model) {
		model.addAttribute("nganh", new NganhDTO());

		// Lấy danh sách khoa để đổ vào select
		List<KhoaDTO> dsKhoa = khoaService.findAll();
		model.addAttribute("dsKhoa", dsKhoa);

		return "nganh/add_nganh"; // Tên file HTML trong thư mục templates
	}

	@PostMapping("/add_nganh")
	public String saveNganh(@ModelAttribute("nganh") NganhDTO nganhDto) {
		nganhService.save(nganhDto);
		return "redirect:/list_nganh";
	}

//ROUTER EDIT NGÀNH
	@GetMapping("/edit_nganh/{id}")
	public ModelAndView editNganh(@PathVariable("id") String id, Model model) {
		// Lấy thông tin khoa hiện tại từ database
		NganhDTO nganhDTO = nganhService.findById(id);

		// Nếu không tìm thấy khoa với ID, trả về trang lỗi hoặc trang danh sách khoa
		if (nganhDTO == null) {
			return new ModelAndView("redirect:/list_nganh");
		}
		List<KhoaDTO> dsKhoa = khoaService.findAll();
		model.addAttribute("dsKhoa", dsKhoa);
		model.addAttribute("nganh", nganhDTO); // Truyền thông tin khoa vào model
		return new ModelAndView("nganh/edit_nganh"); // Trả về view "edit_khoa.html"
	}

	@PostMapping("/edit_nganh")
	public String updateNganh(@ModelAttribute("nganh") NganhDTO nganhDTO) {
		try {
			nganhService.editNganh(nganhDTO);
			return "redirect:/list_nganh"; // Redirect về trang home sau khi cập nhật thành công
		} catch (IllegalArgumentException e) {
			return "redirect:/edit_nganh/" + nganhDTO.getID() + "?error=" + e.getMessage();
		}
	}

	// DELETE NGÀNH
	@GetMapping("/delete_nganh/{id}")
	public String deleteNganh(@PathVariable("id") String id) {
		try {
			nganhService.deleteKhoa(id); // Gọi phương thức trong Service để xóa
		} catch (Exception e) {
			// Nếu có lỗi (ví dụ: không tìm thấy khoa), có thể log hoặc trả về thông báo
			return "redirect:/list_nganh?error=Ngành Không Tồn Tại";
		}
		return "redirect:/list_nganh"; // Điều hướng lại về trang danh sách khoa
	}


}
