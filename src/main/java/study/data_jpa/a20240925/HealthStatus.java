package study.data_jpa.a20240925;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public enum HealthStatus {
    DISCONNECTED, DOWN, CONNECTED;

    public static List<HealthStatus> anomayStatuses() {
        return new ArrayList<>(EnumSet.of(DISCONNECTED, DOWN));
    }
}
