package model.dto;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
public class SaleItem {
    private Integer id;
    private Integer sale_id;
    private Integer medicine_id;
    private Integer qty;
    private Double unit_price;
    private LocalDate created_at;
}
