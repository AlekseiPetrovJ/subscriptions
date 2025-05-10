package ru.petrov.subscriptions.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "subscription")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Future(message = "Дата и время события должны быть в будущем")
    @Schema(description = "Дата и время события", example = "2026-05-10T18:30:00")
    private LocalDateTime endSubscription;

    @JsonBackReference("user-sub")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private User user;

    @ManyToOne
    @JoinColumn(name = "type_subscription_id")
    private TypeSubscription typeSubscription;
}
