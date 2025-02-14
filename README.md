<h1 align="center">See Docs</h1>

<p align="center">
  <a href="http://kotlinlang.org">
      <img alt="Kotlin" src="https://img.shields.io/badge/kotlin-2.0.20-blue.svg?logo=kotlin" />
  </a>
  <a href="https://android-arsenal.com/api?level=26"><img alt="API" src="https://img.shields.io/badge/API-26%2B-brightgreen.svg?style=flat"/></a>
  <a href="https://github.com/guri999"><img alt="Profile" src="https://guri999.github.io/data/badge.svg"/></a>
</p>

<p align="center">
문서를 볼 수 있는 Android App
</p>

## Design

[Figma](https://www.figma.com/design/FYGDQieciMf0a7Af4kzI6O/SeeDocs?node-id=1-4&t=3zk4kfwCNwxk9uiX-1)

### 화면 구성

- Home: 디바이스의 문서 파일 목록을 보여줍니다.
- Bookmark: 북마크된 파일들이 모여있는 목록.
- Recent: 최근 본 파일 목록
- Pdf: PDF 화면

## 프로젝트 목표

- PDF 이미지, 텍스트 등을 볼 수 있는 서비스 구현

## Tech stack & Open-source libraries

- Minimum SKD level 26
- Kotlin based, Coroutines + Flow
- Jetpack Libraries:
    - Jetpack compose: Android UI toolkit
    - ViewModel: UI 관련 데이터를 관리하고 수명 주기를 인식하여 구성이 변경되어도 데이터 생존 보장
- Architecture:
    - Repostiory Pattern
    - MVI Architecture (Model-View-Intent)
- Kotlin Serialization
- Koin
- Ksp
- Room
- Git Hub Actions

## Architecture

MVI 패턴과 Repository Pattern으로 구성

![image](https://github.com/user-attachments/assets/5197b9d7-ccff-4aba-8089-a7d0f8170b92)


### UI Layer

MVI 패턴으로 구성

상태는 아래로 이벤트는 위로 이동하는 단방향 데이터흐름으로 구현
![image](https://github.com/user-attachments/assets/0000286e-56c6-454c-9c15-fbb4e0bcc676)


- `Intent`: 사용자의 입력 이벤트를 캡처하고, 이를 Model에게 전달할 Action이나 Event로 변환.
- `Model`: 상태 변화를 처리하고, View가 구독하여 화면을 갱신.
- `View`: 상태(Model)를 기반으로 UI를 렌더링. 사용자의 입력 이벤트를 Intent로 변환해 전달.

## 모듈화 전략

- 재사용성: 재사용 가능한 코드를 모듈화하여, 코드를 공유하고 동시에 다른 모듈에서 코드의 접근성 제한
- 병렬 빌드: 각 모듈을 병렬로 실행할 수 있어 빌드 시간 단축
- Decentralized focusing: 각 기능 별 모듈을 나누어 자체 모듈에 집중해서 작업.

## 프로젝트 중점 사항

- Contents Provider를 통한 디바이스 파일 접근
- 단위 테스트 작성
- PDF 뷰어 기능
- 대용량 파일 빠르게 처리할 수 있도록 메모리 최적화
- 테스트 자동화
