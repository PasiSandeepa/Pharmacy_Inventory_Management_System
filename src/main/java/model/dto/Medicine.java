package model.dto;

import lombok.*;

import java.time.LocalDate;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Medicine {
    private Integer id;
    private String name;
    private String brand;
    private String batch_no;
    private LocalDate expire_date;
    private Integer quantity;
    private Double unit_price;
    private Integer reorder_level;
    private LocalDate created_at;
    private LocalDate updated_at;
}
