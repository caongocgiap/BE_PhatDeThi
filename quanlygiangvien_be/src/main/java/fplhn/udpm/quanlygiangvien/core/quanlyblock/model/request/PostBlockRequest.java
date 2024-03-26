package fplhn.udpm.quanlygiangvien.core.quanlyblock.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostBlockRequest {

    @NotNull(message = "Name cannot be empty")
    @NotBlank(message = "Name cannot be empty")
    private String ten;

    @NotNull(message = "Time start cannot be empty")
    private LocalDate thoiGianBatDau;

    @NotNull(message = "Time finished cannot be empty")
    private LocalDate thoiGianKetThuc;

    @NotNull(message = "Hoc ky cannot be empty")
    private Long idHocKy;

}
