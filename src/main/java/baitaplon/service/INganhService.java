package baitaplon.service;

import org.springframework.stereotype.Service;

import baitaplon.dto.NganhDTO;

@Service
public interface INganhService {
	NganhDTO save(NganhDTO nganh);
}