# board
springBoot 개념정리

### Restful 원칙
1. **클라이언트와 서버를 분리한다.**
1. **stateless 해야한다.**
    * 세션을 사용하지 않기 때문에 token 기반의 stateless 한 방식을 사용해야한다.
1. **Cashable**
    * 캐시를 잘 활용해야한다.
1. **계층적인 시스템**
    * Client -> Controller -> Service -> Repository -> DB
   


### AOP
1. **build.gradle** 의존 추가
```text          
/* AOP 설정 관련 */
implementation 'org.springframework.boot:spring-boot-starter-aop'
```
2. 어노테이션 관련
   - @Before : 메소드 호출되기 전 실행
   - @After : 메소드 호출된 후 실행
   - @AfterReturning:  메소드가 성공적으로 실행된 이후에 실행해라
   - @AfterThrowing : 메소드 실행중에 예외가 던져지면 수행해라
   - @Around : 메소드 수행 전후에 실행해라
   
   