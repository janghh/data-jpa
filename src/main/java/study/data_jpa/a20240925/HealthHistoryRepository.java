package study.data_jpa.a20240925;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HealthHistoryRepository extends JpaRepository<HealthHistoryEntity, Long> {

    @Query(value = "select t1 from HealthHistoryEntity t1 where t1.status in ('DISCONNECTED', 'DOWN')")
    List<HealthHistoryEntity> asis();

    @Query(value = "select t1 from HealthHistoryEntity t1 where t1.status in (study.data_jpa.a20240925.HealthStatus.DISCONNECTED, study.data_jpa.a20240925.HealthStatus.DOWN)")
    List<HealthHistoryEntity> tobe_A();

    @Query(value = "select t1 from HealthHistoryEntity t1 where t1.status in :status")
    List<HealthHistoryEntity> tobe_B(@Param("status") List<HealthStatus> statusList);

}