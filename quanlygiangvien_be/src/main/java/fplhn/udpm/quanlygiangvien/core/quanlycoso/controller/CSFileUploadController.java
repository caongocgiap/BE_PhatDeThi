package fplhn.udpm.quanlygiangvien.core.quanlycoso.controller;

import fplhn.udpm.quanlygiangvien.core.quanlycoso.service.impl.CSImportExcel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
@RequiredArgsConstructor
public class CSFileUploadController {

    private final CSImportExcel csImportExcel;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
        // Process the uploaded file (e.g., Excel processing) here
        // Return response accordingly
        csImportExcel.importExcelCoSo(file);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}