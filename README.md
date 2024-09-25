# 기능 테스트 목적의 프로젝트

이 프로젝트는 기본적인 기능에 대한 간단한 동작 테스트를 목적으로 합니다.

## 기능 테스트 목록

- [a20240925](#a20240925) - jpql에서 query에 Enum을 사용하기 

## a20240925

```java
//ASIS
@Query(value = "select hc from Member hc where hc.status in ('DISCONNECTED', 'DOWN')")

//TOBE
@Query(value = "select hc from Member hc where hc.status in (study.data_jpa.jpa20240925.HealthStatus.DISCONNECTED, study.data_jpa.jpa20240925.HealthStatus.DOWN)")
```