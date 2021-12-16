### DDD-Order Kotlin 

> 이 레포는 해당 [강의 레포](https://github.com/gregshiny/example-order) 의 내용을 Kotlin 으로 변형한 레포입니다. (공부용)

- `java-spring` 으로 구현되어 있는 강의 내용을 `kotlin-spring` 으로 변경하는데 목적이 있습니다. 

- java 와 kotlin 을 통한 spring 이 처음이라, 많이 미흡하지만 참고하는 용도로 활용정도로만 생각해주세요.



#### Branch

- `master` -> `Order Server` 에 대해서만 구현 되어 있음.

- `order/expand-gift-with-sqs` 

  MSA 용으로 AWS SQS 와 연동이 되어있는 부분이 구현되어 있습니다. 

  [DDD-gift-repo](https://github.com/heojae/DDD-gift-kotlin) 와 연동 되어 있습니다. 



#### DB

- `Docker` 를 통해서, `Mysql` 을 활용할 수 있음.
- `docker-compose up`
- `13306`





