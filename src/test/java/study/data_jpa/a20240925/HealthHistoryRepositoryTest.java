package study.data_jpa.a20240925;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
@Rollback(false)
@TestInstance(TestInstance.Lifecycle.PER_CLASS) // Test 클래스가 한 번만 생성됨
class HealthHistoryRepositoryTest {

    @Autowired
    HealthHistoryRepository repo;

    @BeforeAll
    public void setup() {
        repo.save( new HealthHistoryEntity("member-normal", HealthStatus.CONNECTED) );
        repo.save( new HealthHistoryEntity("member-dis", HealthStatus.DISCONNECTED) );
        repo.save( new HealthHistoryEntity("member-down", HealthStatus.DOWN) );
    }

    @Test
    public void asis(){
        List<HealthHistoryEntity> anomalies = repo.asis();

        System.out.println("=========================================");
        System.out.println("anomalies.size() = " + anomalies.size());
        anomalies.forEach(System.out::println);
        System.out.println("=========================================");
    }

    @Test
    public void tobe_A(){
        List<HealthHistoryEntity> anomalies = repo.tobe_A();

        System.out.println("=========================================");
        System.out.println("anomalies.size() = " + anomalies.size());
        anomalies.forEach(System.out::println);
        System.out.println("=========================================");
    }

    @Test
    public void tobe_B(){
        List<HealthHistoryEntity> anomalies = repo.tobe_B(HealthStatus.anomayStatuses());

        System.out.println("=========================================");
        System.out.println("anomalies.size() = " + anomalies.size());
        anomalies.forEach(System.out::println);
        System.out.println("=========================================");
    }

}