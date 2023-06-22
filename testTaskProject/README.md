implementation 'org.springframework.boot:spring-boot-starter'
implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
implementation 'org.springframework.boot:spring-boot-starter-web'
implementation 'org.projectlombok:lombok:1.18.20'
implementation 'org.springframework.boot:spring-boot-starter-validation'
implementation 'org.liquibase:liquibase-core'
implementation group: 'org.springdoc', name: 'springdoc-openapi-starter-webmvc-ui', version: '2.0.2'
compileOnly 'org.projectlombok:lombok'
runtimeOnly 'org.postgresql:postgresql'
annotationProcessor 'org.projectlombok:lombok'
testImplementation 'org.springframework.boot:spring-boot-starter-test'

Для запуска проекта необходима БД PostgreSQL. СкриптБД инициализируется автоматически liquibase в базе данных postgres. файлы инициализации находятся в папке resources/db/changelog.
Результат выполнения программы можно протестировать в браузере по ссылкеhttp://localhost:8080/swagger-ui/index.html
При тестировании проекта следует обратить внимание на требования валидации сущностей.