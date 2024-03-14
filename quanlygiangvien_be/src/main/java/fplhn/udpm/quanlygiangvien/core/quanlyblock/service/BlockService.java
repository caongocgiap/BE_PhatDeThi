package fplhn.udpm.quanlygiangvien.core.quanlyblock.service;

import fplhn.udpm.quanlygiangvien.entity.Block;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BlockService {

    Page<Block> getPage(Pageable pageable);

    Optional<Block> getById(Long id);

    Block insert(Block newBlock);

    Block update(Block block, Block blockUpdate);

    boolean delete(Long id);

    List<Block> getBlockByHocKyId(Long id);

}