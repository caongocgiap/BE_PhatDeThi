package fplhn.udpm.quanlygiangvien.infrastructure.config;

import fplhn.udpm.quanlygiangvien.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DBGenConfig {

    @Autowired
    private BlockRepository blockRepository;

    @Autowired
    private BoMonRepository boMonRepository;

    @Autowired
    private BoMonTheoCoSoRepository boMonTheoCoSoRepository;

    @Autowired
    private ChucVuRepository chucVuRepository;

    @Autowired
    private ChuyenNganhRepository chuyenNganhRepository;

    @Autowired
    private ChuyenNganhTheoCoSoRepository chuyenNganhTheoCoSoRepository;

    @Autowired
    private CampusRepository campusRepository;

    @Autowired
    private CoSoRepository coSoRepository;

    @Autowired
    private GiaoVienDayMonRepository giaoVienDayMonRepository;

    @Autowired
    private HocKyRepository hocKyRepository;

    @Autowired
    private LopMonRepository lopMonRepository;

    @Autowired
    private MonHocRepository monHocRepository;

    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Autowired
    private NhanVienChucVuRepository nhanVienChucVuRepository;


}
