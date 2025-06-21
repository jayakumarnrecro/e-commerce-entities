package org.example.evaluations.evaluation.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "images")
public class Image extends BaseModel {
    
    @Column
    private String resolution;

    @Column(name = "size_in_kb")
    private Long sizeInKb;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "descriptive_name")
    private String descriptiveName;
}
