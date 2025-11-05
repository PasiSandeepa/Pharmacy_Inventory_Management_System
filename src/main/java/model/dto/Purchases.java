package model.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Purchases {
    private Integer id;
    private Integer supplier_id;
    private String invoice_no;
    private LocalDateTime purchase_date;
    private Double total_amount;
    private LocalDateTime created_at;

}
