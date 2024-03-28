package fplhn.udpm.quanlygiangvien.core.quanlyblock.controller;

import fplhn.udpm.quanlygiangvien.core.quanlyblock.service.BlockService;
import fplhn.udpm.quanlygiangvien.entity.Block;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/block")
@CrossOrigin("*")
@RequiredArgsConstructor
public class BlockController {

    private final BlockService blockService;

    private int PAGE_SIZE = 5;

    @GetMapping("/get-list/page={pageIndex}")
    public ResponseEntity<?> getPage(@PathVariable("pageIndex") Optional<Integer> pageIndex) {
        Pageable pageable = PageRequest.of(pageIndex.orElse(0), PAGE_SIZE, Sort.by("id").descending());
        return ResponseEntity.status(HttpStatus.OK).body(blockService.getPage(pageable));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getByID(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(blockService.getById(id));
    }

    @GetMapping("/get-block-by-id-hoc-ky/{id}")
    public ResponseEntity<?> getByIdHocKy(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(blockService.getBlockByHocKyId(id));
    }

    @PostMapping("/save")
    public ResponseEntity<?> insert(@Valid @RequestBody Block newBlock) {
        return ResponseEntity.status(HttpStatus.OK).body(blockService.insert(newBlock));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Block updateBlock) {
        Block block = blockService.getById(id).get();
        return ResponseEntity.status(HttpStatus.OK).body(blockService.update(block, updateBlock));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(blockService.delete(id));
    }

}
