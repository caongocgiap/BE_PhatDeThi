package fplhn.udpm.quanlygiangvien.core.quanlyhocky.controller;

import fplhn.udpm.quanlygiangvien.core.quanlyhocky.service.impl.HocKyServiceImpl;
import fplhn.udpm.quanlygiangvien.entity.HocKy;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hoc-ky")
public class HocKyController {
    @Autowired
    HocKyServiceImpl service;
    @GetMapping("/get-list/page={pageIndex}")
    public Page<HocKy> getAll(@PathVariable("pageIndex")Optional<Integer> pageIndex) {
        Pageable pageable = PageRequest.of(pageIndex.orElse(0), 5, Sort.by("id").descending());
        return service.getPage(pageable);
    }

    @GetMapping(value = "get/{id}")
    public Optional<HocKy> getById(@PathVariable("id") Long id) {
        return service.getById(id);
    }

    @PostMapping(value = "/save")
    public HocKy insert(@RequestBody HocKy newHocKy) {
        return service.insert(newHocKy);
    }

    @PutMapping(value = "/update/{id}")
    public HocKy update(@PathVariable Long id, @RequestBody HocKy hocKyUpdated) {
        HocKy hocKy = getById(id).get();
        service.update(hocKy, hocKyUpdated);
        return hocKy;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
