package model.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Purchase_items {

    private Integer id;
    private Integer purchase_id;
    private Integer medicine_id;
    private String batch_no;
    private LocalDateTime expiry_date;
    private Integer qty;
    private Double unit_price;
    private LocalDateTime created_at;
}