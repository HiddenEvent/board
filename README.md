# board
springBoot 개념정리

### ** RestFul 원칙
1. **클라이언트와 서버를 분리한다.**
1. **stateless 해야한다.**
    * 세션을 사용하지 않기 때문에 token 기반의 stateless 한 방식을 사용해야한다.
1. **Cashable**
    * 캐시를 잘 활용해야한다.
1. **계층적인 시스템**
    * Client -> Controller -> Service -> Repository -> DB