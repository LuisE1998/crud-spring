package exampleSpring.crud.autors;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="autor")
public class AutorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "autor_sequence")
    @SequenceGenerator(name = "autor_sequence", sequenceName = "autor_id_seq", allocationSize = 1)
    private Long id;

    @Column
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
}
