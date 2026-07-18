# 1. 빌드 환경
# 빌드를 해야 하므로 JRE가 아닌 JDK 이미지를 사용
FROM eclipse-temurin:17-jdk-alpine AS builder

# 2. 작업 공간 설정
WORKDIR /app

# 프로젝트 빌드에 필요한 모든 파일을 도커 안으로 복사합니다.
COPY gradlew .
COPY gradle ./gradle
COPY build.gradle settings.gradle ./

# 4. 소스 코드 복사: 실제 내가 짠 Java 코드들을 통째로 복사
COPY src ./src

# [중요] 윈도우에서 작성된 gradlew 파일의 줄바꿈(CRLF) 오류를 리눅스(LF)에 맞게 수정하고, 실행 권한을 줍니다.
RUN sed -i 's/\r$//' gradlew
RUN chmod +x ./gradlew

# 도커 안에서 직접 빌드하여 .jar 파일을 생성합니다.
RUN ./gradlew bootJar


# 2단계: 실행 환경
# 실행만 하면 되므로 더 가벼운 JRE 이미지를 사용.
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# 1단계(builder)에서 완성된 .jar 파일만 가벼운 실행 환경으로 쏙 빼옵니다.
COPY --from=builder /app/build/libs/*.jar app.jar

# 스프링부트 profile 설정 (application-dev.yml 등을 읽게 함)
ENV PROFILE="dev"

# 애플리케이션 실행
ENTRYPOINT ["java", "-jar", "app.jar", "--spring.profiles.active=${PROFILE}"]