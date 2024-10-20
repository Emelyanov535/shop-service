package ru.mediasoft.shop.persistence.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.mediasoft.shop.enumeration.CategoryType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "t_product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductEntity {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "UUID")
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(unique = true, nullable = false)
    private Long article;
    private String description;
    @Enumerated(EnumType.STRING)
    private CategoryType category;
    @Column(columnDefinition = "DECIMAL(10, 2)", nullable = false)
    private BigDecimal price;
    @Column(nullable = false)
    private int amount;
    private LocalDateTime changedAmount;
    private LocalDate createdAt;
    @Column(nullable = false)
    private Boolean isAvailable;
    @OneToMany(mappedBy = "key.product",
            cascade = CascadeType.ALL)
    private List<OrderProductEntity> orderProducts;
}
