package fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.model.response;

import fplhn.udpm.quanlygiangvien.infrastructure.constant.XoaMem;

public interface BoMonTheoCoSoResponse {

    Long getId();

    Long getIdBoMon();

    Long getIdCoSo();

    String getTenCoSo();

    XoaMem getTrangThai();

}
