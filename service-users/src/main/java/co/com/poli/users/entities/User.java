package co.com.poli.users.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;

@Setter
@Getter
@Entity
@Table(name = "users")
public class User {

    @Id
    @NotEmpty(message = "El nit/numero no puede ser vacio")
    @Size(min = 8, message = "El tamaño del nit/numero debe ser minimo de 8")
    @Column(name = "id", unique = true,nullable = false,updatable = false)
    private Long id;

    @NotEmpty(message = "El nombre no puede ser vacio")
    @Column(name="name")
    private String name;

    @NotEmpty(message = "El apellido no puede ser vacio")
    @Column(name="last_name")
    private String lastName;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
