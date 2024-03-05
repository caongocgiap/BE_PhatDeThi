package fplhn.udpm.quanlygiangvien.core.quanlyblock.service;

import fplhn.udpm.quanlygiangvien.entity.Block;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface BlockService {
    Page<Block> getPage(Pageable pageable);

    Optional<Block> getById(Long id);

    Block insert(Block newBlock);

    Block update(Block block, Block blockUpdate);

    boolean delete(Long id);
}
