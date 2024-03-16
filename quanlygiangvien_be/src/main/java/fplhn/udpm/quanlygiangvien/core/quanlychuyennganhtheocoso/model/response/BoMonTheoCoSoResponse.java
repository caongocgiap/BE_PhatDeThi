package fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.model.response;

import fplhn.udpm.quanlygiangvien.infrastructure.constant.XoaMem;

public interface ChuyenNganhTheoCoSoResponse {

    Long getId();

    Long getStt();

    Long idBoMonTheoCoSo();

    String getTenBoMonTheoCoSo();

    Long getIdChuyenNganh();

    String getTenChuyenNganh();

    Long getIdTruongMon();

    String getTenTruongMon();

    XoaMem getTrangThai();

}
