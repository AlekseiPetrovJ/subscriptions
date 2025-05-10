package ru.petrov.subscriptions.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "type_subscription")
public class TypeSubscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(description = "Название подписки", example = "Yandex music")
    @NotBlank
    @Column(name = "name", unique = true, nullable = false)
    private String name;

//    @JsonManagedReference("sub-type")
//    @OneToMany(mappedBy = "typeSubscription", cascade = CascadeType.ALL)
//    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
//    private Set<Subscription> subscriptions;
}
