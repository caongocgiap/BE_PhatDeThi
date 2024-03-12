package fplhn.udpm.quanlygiangvien.core.quanlyblock.service.impl;

import fplhn.udpm.quanlygiangvien.core.quanlyblock.repository.QLBlockRepository;
import fplhn.udpm.quanlygiangvien.core.quanlyblock.service.BlockService;
import fplhn.udpm.quanlygiangvien.entity.Block;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BlockServiceImpl implements BlockService {

    private final QLBlockRepository qlBlockRepository;

    @Override
    public Page<Block> getPage(Pageable pageable) {
        return qlBlockRepository.findAll(pageable);
    }

    @Override
    public Optional<Block> getById(Long id) {
        return qlBlockRepository.findById(id);
    }

    @Override
    public Block insert(Block newBlock) {
        return qlBlockRepository.save(newBlock);
    }

    @Override
    public Block update(Block block, Block blockUpdate) {
        block.setTen(blockUpdate.getTen());
        block.setThoiGianBatDau(blockUpdate.getThoiGianBatDau());
        block.setThoiGianKetThuc(blockUpdate.getThoiGianKetThuc());
        block.setHocKy(blockUpdate.getHocKy());
        block.setXoaMem(blockUpdate.getXoaMem());
        return qlBlockRepository.save(block);
    }

    @Override
    public boolean delete(Long id) {
        try {
            qlBlockRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public List<Block> getBlockByHocKyId(Long id) {
        return qlBlockRepository.selectBlockByIdHocKy(id);
    }

}
