package fplhn.udpm.quanlygiangvien.entity;

import fplhn.udpm.quanlygiangvien.entity.base.BaseEntity;
import fplhn.udpm.quanlygiangvien.infrastructure.constant.Ca;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "lop_mon")
public class LopMon extends BaseEntity {

    @Column(name = "ma_lop", length = 255, nullable = true)
    @Nationalized
    private String maLop;

    @Column(name = "ngay")
    private LocalDate ngay;

    @Enumerated(EnumType.STRING)
    @Column(name = "ca")
    private Ca ca;

    @ManyToOne
    @JoinColumn(name = "id_mon_hoc")
    private MonHoc monHoc;

    @ManyToOne
    @JoinColumn(name = "id_block")
    private Block block;

    @ManyToOne
    @JoinColumn(name = "id_campus")
    private Campus campus;

    @ManyToOne
    @JoinColumn(name = "id_nhan_vien")
    private NhanVien nhanVien;
}
