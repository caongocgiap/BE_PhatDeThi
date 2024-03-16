package fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.service;

import fplhn.udpm.quanlygiangvien.core.common.ResponseModel;
import fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.model.request.GetChuyenNganhRequest;
import fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.model.response.ChuyenNganhResponse;
import fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.model.request.PostChuyenNganhRequest;
import org.springframework.data.domain.Page;

public interface ChuyenNganhService {

    ChuyenNganhResponse getChuyenNganh(Long id);

    Page<ChuyenNganhResponse> getAllList(Long idBoMon, GetChuyenNganhRequest dataRequest);

    ResponseModel addChuyenNganh(PostChuyenNganhRequest dataRequest);

    ResponseModel updateChuyenNganh(Long id, PostChuyenNganhRequest dataRequest);

    ResponseModel deleteChuyenNganh(Long id);


}
