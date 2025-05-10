package ru.petrov.subscriptions.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Set;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(description = "Имя пользователя", example = "Ivan")
    @NotBlank
    @Column(name = "username", nullable = false)
    private String username;

    @JsonManagedReference("user-sub")
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Set<Subscription> subscriptions;

}
