package dev.invencio.Invencio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invencio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String stockId;
    public String itemName;
    public String category;
    public String quantity;
    public String price;
    public String warehouse;
    public String restockThreshold;
    @Lob
    public String description;

}
