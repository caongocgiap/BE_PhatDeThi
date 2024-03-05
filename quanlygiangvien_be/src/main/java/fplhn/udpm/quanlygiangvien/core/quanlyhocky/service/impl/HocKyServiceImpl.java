package fplhn.udpm.quanlygiangvien.core.quanlyhocky.service.impl;

import fplhn.udpm.quanlygiangvien.core.quanlyhocky.repository.DBHocKyRepository;
import fplhn.udpm.quanlygiangvien.core.quanlyhocky.service.HocKyService;
import fplhn.udpm.quanlygiangvien.entity.HocKy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HocKyServiceImpl implements HocKyService {
    @Autowired
    private DBHocKyRepository repo;

    @Override
    public Page<HocKy> getPage(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Override
    public Optional<HocKy> getById(Long id) {
        return repo.findById(id);
    }

    @Override
    public HocKy insert(HocKy newHocKy) {
        return repo.save(newHocKy);
    }

    @Override
    public HocKy update(HocKy hocKy, HocKy hocKyUpdate) {
        hocKy.setTen(hocKyUpdate.getTen());
        hocKy.setThoiGianBatDau(hocKyUpdate.getThoiGianBatDau());
        hocKy.setXoaMem(hocKyUpdate.getXoaMem());
        return repo.save(hocKy);
    }

    @Override
    public boolean delete(Long id) {
        try {
            repo.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
