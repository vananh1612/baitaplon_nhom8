package baitaplon.service;

import org.springframework.stereotype.Service;

import baitaplon.dto.KhoaDTO;

@Service
public interface IKhoaService {
	KhoaDTO save(KhoaDTO khoa);
}