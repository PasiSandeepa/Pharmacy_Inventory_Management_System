package model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CartItem {
    private String customerName;
    private String medicineName;
    private double unitPrice;
    private int quantity;
    private double total;
    private String cashier;
}
