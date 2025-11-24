package model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PurchaseTableModel {
    private Integer id;
    private String date;    // created_at as String
    private String type;    // "Purchase"
    private Double amount;  // total_amount
}