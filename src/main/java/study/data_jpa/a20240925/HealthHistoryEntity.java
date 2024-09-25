package study.data_jpa.a20240925;

import lombok.*;

import javax.persistence.*;

@ToString
@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HealthHistoryEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String username;

    @Enumerated(EnumType.STRING)
    private HealthStatus status;

    public HealthHistoryEntity(String username, HealthStatus status) {
        this.username = username;
        this.status = status;
    }
}