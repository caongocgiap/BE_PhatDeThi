package fplhn.udpm.quanlygiangvien.core.quanlyhocky.service;

import fplhn.udpm.quanlygiangvien.entity.HocKy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface HocKyService {
    Page<HocKy> getPage(Pageable pageable);

    Optional<HocKy> getById(Long id);

    HocKy insert(HocKy newHocKy);

    HocKy update(HocKy hocKy, HocKy hocKyUpdate);

    boolean delete(Long id);
}
