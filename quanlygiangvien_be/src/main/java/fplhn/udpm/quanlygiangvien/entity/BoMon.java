package fplhn.udpm.quanlygiangvien.entity;

import fplhn.udpm.quanlygiangvien.entity.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "bo_mon")
public class BoMon extends BaseEntity {

    @Column(name = "ten", length = 255, nullable = true)
    private String ten;
}
