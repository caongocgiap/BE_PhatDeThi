package fplhn.udpm.quanlygiangvien.core.quanlycoso.repository;

import fplhn.udpm.quanlygiangvien.core.quanlycoso.model.response.CSCoSoResponse;
import fplhn.udpm.quanlygiangvien.repository.CoSoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CSCoSoRepository extends CoSoRepository {

    @Query(value = "SELECT id as idCoSo, ten as tenCoSo, xoa_mem as xoaMemCoSo" +
            " FROM co_so cs" +
            " WHERE  cs.id IN :searchTermList", nativeQuery = true)
    Page<CSCoSoResponse> paginateAndSearch(Pageable pageable, @Param("searchTermList")Set<String> lisTenCoSo);

    @Query(value = "SELECT id as idCoSo, ten as tenCoSo, xoa_mem as xoaMemCoSo " +
            "FROM co_so ", nativeQuery = true)
    List<CSCoSoResponse> getAll();

    @Query(value = "SELECT id " +
            " FROM co_so cs" +
            " WHERE cs.ten like CONCAT('%',:searchTermList,'%')", nativeQuery = true)
    Set<String> searchName(@Param("searchTermList")String lisTenCoSo);


    Boolean existsByTen(String ten);

}
