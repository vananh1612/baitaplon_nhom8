package baitaplon.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;

import baitaplon.dto.KhoaDTO;
import baitaplon.service.impl.KhoaService;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class KhoaController {


	@Autowired
	private KhoaService khoaService;

	@GetMapping("/list_khoa")
	public String listKhoa(Model model) {
		model.addAttribute("dsKhoa", khoaService.findAll());
		return "khoa/list_khoa";
	}
	


	// router thêm khoa
	@GetMapping("/add_khoa")
	public ModelAndView addKhoa(Model model) {
		model.addAttribute("khoa", new KhoaDTO());
		return new ModelAndView("khoa/add_khoa");
	}

	@PostMapping("/add_khoa")
	public String saveKhoa(@ModelAttribute("khoa") KhoaDTO khoaDto) {
		khoaService.save(khoaDto);
		return "redirect:/list_khoa";
	}

	// router edit khoa
	@GetMapping("/edit_khoa/{id}")
	public ModelAndView editKhoa(@PathVariable("id") String id, Model model) {
		// Lấy thông tin khoa hiện tại từ database
		KhoaDTO khoaDto = khoaService.findById(id);

		// Nếu không tìm thấy khoa với ID, trả về trang lỗi hoặc trang danh sách khoa
		if (khoaDto == null) {
			return new ModelAndView("redirect:/list_khoa");
		}

		model.addAttribute("khoa", khoaDto); // Truyền thông tin khoa vào model
		return new ModelAndView("khoa/edit_khoa"); // Trả về view "edit_khoa.html"
	}

	@PostMapping("/edit_khoa")
	public String updateKhoa(@ModelAttribute("khoa") KhoaDTO khoaDto) {
		try {
			khoaService.editKhoa(khoaDto);
			return "redirect:/list_khoa"; // Redirect về trang home sau khi cập nhật thành công
		} catch (IllegalArgumentException e) {
			return "redirect:/edit_khoa/" + khoaDto.getID() + "?error=" + e.getMessage();
		}
	}

	// router xóa khoa
	@GetMapping("/delete_khoa/{id}")
	public String deleteKhoa(@PathVariable("id") String id) {
		try {
			khoaService.deleteKhoa(id); // Gọi phương thức trong Service để xóa
		} catch (Exception e) {
			// Nếu có lỗi (ví dụ: không tìm thấy khoa), có thể log hoặc trả về thông báo
			return "redirect:/list_khoa?error=KhoaKhôngTồnTại";
		}
		return "redirect:/list_khoa"; // Điều hướng lại về trang danh sách khoa
	}



}
