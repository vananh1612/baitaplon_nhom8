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
public class LopController {

	@Autowired
	private LopService lopService;

	@Autowired
	private NganhService nganhService;


	@GetMapping("/list_lop")
	public String listKhoa(Model model) {
		List<NganhDTO> dsNganh = nganhService.findAll();
		if (dsNganh == null) {
			dsNganh = new ArrayList<>();
		}
		List<LopDTO> dsLop = lopService.findAll();
		if (dsLop == null) {
			dsLop = new ArrayList<>();
		}
		model.addAttribute("dsLop", dsLop);
		model.addAttribute("dsNganh", dsNganh);
		return "lop/list_lop";
	}
	
	//ROUTER THÊM LỚP
		@GetMapping("/add_lop")
		public String addLop(Model model) {
			model.addAttribute("lop", new LopDTO());

			// Lấy danh sách khoa để đổ vào select
			List<NganhDTO> dsNganh = nganhService.findAll();
			model.addAttribute("dsNganh", dsNganh);
			return "lop/add_lop"; // Tên file HTML trong thư mục templates
		}

		@PostMapping("/add_lop")
		public String saveLop(@ModelAttribute("lop") LopDTO lopDTO) {
			lopService.save(lopDTO);
			return "redirect:/list_lop";
		}

	//ROUTER EDIT LỚP
		@GetMapping("/edit_lop/{id}")
		public ModelAndView editLop(@PathVariable("id") String id, Model model) {
			// Lấy thông tin khoa hiện tại từ database
			LopDTO lopDTO = lopService.findById(id);

			// Nếu không tìm thấy khoa với ID, trả về trang lỗi hoặc trang danh sách khoa
			if (lopDTO == null) {
				return new ModelAndView("redirect:/list_lop");
			}
			List<NganhDTO> dsNganh = nganhService.findAll();
			model.addAttribute("dsNganh", dsNganh);
			model.addAttribute("lop", lopDTO); // Truyền thông tin khoa vào model
			return new ModelAndView("lop/edit_lop"); // Trả về view "edit_khoa.html"
		}

		@PostMapping("/edit_lop")
		public String updateLop(@ModelAttribute("lop") LopDTO lopDTO) {
			try {
				lopService.editLop(lopDTO);
				return "redirect:/list_lop"; 
			} catch (IllegalArgumentException e) {
				return "redirect:/edit_lop/" + lopDTO.getID() + "?error=" + e.getMessage();
			}
		}

		// DELETE LỚP
		@GetMapping("/delete_lop/{id}")
		public String deleteLop(@PathVariable("id") String id) {
			try {
				lopService.deleteLop(id); // Gọi phương thức trong Service để xóa
			} catch (Exception e) {
				// Nếu có lỗi (ví dụ: không tìm thấy khoa), có thể log hoặc trả về thông báo
				return "redirect:/list_lop?error=Ngành Không Tồn Tại";
			}
			return "redirect:/list_lop"; // Điều hướng lại về trang danh sách khoa
		}

}
