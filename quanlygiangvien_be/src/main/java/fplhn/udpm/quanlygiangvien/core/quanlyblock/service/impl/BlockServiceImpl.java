package fplhn.udpm.quanlygiangvien.core.quanlyblock.service.impl;

import fplhn.udpm.quanlygiangvien.core.quanlyblock.model.request.BCreateBlockRequest;
import fplhn.udpm.quanlygiangvien.core.quanlyblock.repository.DBBlockRepository;
import fplhn.udpm.quanlygiangvien.core.quanlyblock.service.BlockService;
import fplhn.udpm.quanlygiangvien.entity.Block;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class BlockServiceImpl implements BlockService {
    @Autowired
    private DBBlockRepository repo;
    @Override
    public Page<Block> getPage(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Override
    public Optional<Block> getById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Block insert(Block newBlock) {
        return repo.save(newBlock);
    }

    @Override
    public Block update(Block block, Block blockUpdate) {
        block.setTen(blockUpdate.getTen());
        block.setThoiGianBatDau(blockUpdate.getThoiGianBatDau());
        block.setThoiGianKetThuc(blockUpdate.getThoiGianKetThuc());
        block.setHocKy(blockUpdate.getHocKy());
        block.setXoaMem(blockUpdate.getXoaMem());
        return repo.save(block);
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
