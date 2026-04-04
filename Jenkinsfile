pipeline {
    agent any

    stages {
        stage('Step 1: Checkout') {
            steps {
                echo 'GitHub에서 코드를 가져옵니다...'
                checkout scm
            }
        }

        stage('Step 2: Build') {
            steps {
                echo 'Spring Boot 프로젝트 빌드를 시작합니다...'
                // 리눅스/맥 기준입니다. 윈도우라면 sh 대신 bat을 쓰세요.
                sh 'chmod +x gradlew'
                sh './gradlew clean build -x test'
            }
        }

        stage('Step 3: Result') {
            steps {
                echo '빌드가 완료되었습니다!'
                // 빌드된 jar 파일이 어디 있는지 확인용
                sh 'ls -l build/libs/'
            }
        }
    }
}