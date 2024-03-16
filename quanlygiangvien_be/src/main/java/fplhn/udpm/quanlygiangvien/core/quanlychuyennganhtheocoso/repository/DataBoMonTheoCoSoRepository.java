package fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.repository;

import fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.model.response.ChuyenNganhTheoCoSoResponse;
import fplhn.udpm.quanlygiangvien.repository.ChuyenNganhRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface DataChuyenNganhTheoCoSoRepository extends ChuyenNganhRepository {

    @Query(value = """
            SELECT 
                @row_number \\:= @row_number + 1 AS stt,
                cntcs.id AS id,
                cntcs.id_bo_mon_theo_co_so AS idBoMonTheoCoSo,
                bmtcs.ten AS tenBoMonTheoCoSo,
                cntcs.id_chuyen_nganh AS idChuyenNganh,
                cn.ten AS tenChuyenNganh,
                cntcs.id_truong_mon AS idTruongMon,
                nv.ten AS tenTruongMon,
                cntcs.xoa_mem AS trangThai
            FROM 
                (SELECT @row_number \\:= :startItem) AS init,
                chuyen_nganh_theo_co_so AS cntcs
            INNER JOIN co_so AS cs
            LEFT JOIN bo_mon_theo_co_so AS bmtcs ON bmtcs.id = cntcs.id_bo_mon_theo_co_so
            LEFT JOIN chuyen_nganh AS cn ON cn.id = cntcs.id_chuyen_nganh
            LEFT JOIN nhan_vien AS nv ON nv.id = cntcs.id_truong_mon
            WHERE
                (
                    :idCoSo IS NULL
                    OR
                    cntcs.id IN(:idCoSo)
                )
            ORDER BY cntcs.id DESC
            """,
            countQuery = """
            SELECT COUNT(*) 
            FROM chuyen_nganh_theo_co_so
            INNER JOIN co_so
            WHERE
                (
                    :idCoSo IS NULL
                    OR
                    id IN(:idCoSo)
                )
            """,
            nativeQuery = true)
    Page<ChuyenNganhTheoCoSoResponse> getAllChuyenNganh(
            @Param("idCoSo") List<Long> idCoSo,
            @Param("startItem") Long startItem,
            Pageable pageable
    );

    @Query(value = """
        SELECT 
            CASE 
                WHEN COUNT(*) > 0
                THEN \\"true\\"
                ELSE \\"false\\"
            END
        FROM chuyen_nganh_theo_co_so 
        WHERE 
            id_bo_mon_theo_co_so = :idBoMonTheoCoSo AND 
            id_chuyen_nganh_theo_co_so = :idChuyenNganhTheoCoSo           
        """, nativeQuery = true)
    boolean existsChuyenNganhTheoCoSo(@Param("idBoMonTheoCoSo") Long idBoMonTheoCoSo, @Param("idChuyenNganhTheoCoSo") Long idChuyenNganhTheoCoSo);

    @Query(value = """
        SELECT 
            CASE 
                WHEN COUNT(*) > 0
                THEN \\"true\\"
                ELSE \\"false\\"
            END
        FROM chuyen_nganh_theo_co_so
        WHERE 
            id != :id AND
            id_bo_mon_theo_co_so = :idBoMonTheoCoSo AND 
            id_chuyen_nganh_theo_co_so = :idChuyenNganhTheoCoSo               
        """, nativeQuery = true)
    boolean existsChuyenNganhTheoCoSoWidthOutId(@Param("id") Long id, @Param("idBoMonTheoCoSo") Long idBoMonTheoCoSo, @Param("idChuyenNganhTheoCoSo") Long idChuyenNganhTheoCoSo);

    @Query(value = """
            SELECT 
                0 AS stt,
                cntcs.id AS id,
                cntcs.id_bo_mon_theo_co_so AS idBoMonTheoCoSo,
                bmtcs.ten AS tenBoMonTheoCoSo,
                cntcs.id_chuyen_nganh AS idChuyenNganh,
                cn.ten AS tenChuyenNganh,
                cntcs.id_truong_mon AS idTruongMon,
                nv.ten AS tenTruongMon,
                cntcs.xoa_mem AS trangThai
            FROM chuyen_nganh_theo_co_so AS cntcs
            LEFT JOIN bo_mon_theo_co_so AS bmtcs ON bmtcs.id = cntcs.id_bo_mon_theo_co_so
            LEFT JOIN chuyen_nganh AS cn ON cn.id = cntcs.id_chuyen_nganh
            LEFT JOIN nhan_vien AS nv ON nv.id = cntcs.id_truong_mon
            WHERE cntcs.id = :id
            """,
            nativeQuery = true)
    Optional<ChuyenNganhTheoCoSoResponse> getChuyenNganhById(@Param("id") Long id);
}
