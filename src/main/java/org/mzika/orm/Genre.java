package org.mzika.orm;

import jakarta.persistence.*;

import javax.persistence.GeneratedValue;
import java.awt.*;

@Entity
@Table(name = "genre")
public class Genre {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}