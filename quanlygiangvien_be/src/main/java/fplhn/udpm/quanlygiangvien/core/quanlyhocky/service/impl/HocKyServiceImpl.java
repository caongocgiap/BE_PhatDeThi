package fplhn.udpm.quanlygiangvien.core.quanlyhocky.service.impl;

import fplhn.udpm.quanlygiangvien.core.quanlyhocky.repository.DBHocKyRepository;
import fplhn.udpm.quanlygiangvien.core.quanlyhocky.service.HocKyService;
import fplhn.udpm.quanlygiangvien.entity.HocKy;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HocKyServiceImpl implements HocKyService {

    private final DBHocKyRepository dbHocKyRepository;

    @Override
    public Page<HocKy> getPage(Pageable pageable) {
        return dbHocKyRepository.findAll(pageable);
    }

    @Override
    public Optional<HocKy> getById(Long id) {
        return dbHocKyRepository.findById(id);
    }

    @Override
    public HocKy insert(HocKy hocKy) {
        return dbHocKyRepository.save(hocKy);
    }

    @Override
    public HocKy update(HocKy hocKy, HocKy hocKyUpdate) {
        hocKy.setTen(hocKyUpdate.getTen());
        hocKy.setNam(hocKyUpdate.getNam());
        hocKy.setThoiGianBatDau(hocKyUpdate.getThoiGianBatDau());
        hocKy.setXoaMem(hocKyUpdate.getXoaMem());
        return dbHocKyRepository.save(hocKy);
    }

    @Override
    public boolean delete(Long id) {
        try {
            dbHocKyRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }

}
