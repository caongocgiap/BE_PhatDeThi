package fplhn.udpm.quanlygiangvien.core.quanlyblock.controller;

import fplhn.udpm.quanlygiangvien.core.quanlyblock.service.impl.BlockServiceImpl;
import fplhn.udpm.quanlygiangvien.entity.Block;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/block")
public class BlockController {
    @Autowired
    BlockServiceImpl service;

    @GetMapping("/get-list/page={pageIndex}")
    public ResponseEntity<?> getPage(@PathVariable("pageIndex") Optional<Integer> pageIndex) {
        Pageable pageable = PageRequest.of(pageIndex.orElse(0), 5, Sort.by("id").descending());
        return new ResponseEntity<>(service.getPage(pageable), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getByID(@PathVariable("id") Long id) {
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> insert(@RequestBody Block newBlock) {
        return new ResponseEntity<>(service.insert(newBlock), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Block updateBlock) {
        Block block = service.getById(id).get();
        return new ResponseEntity<>(service.update(block, updateBlock), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
