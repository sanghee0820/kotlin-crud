# 📘 Kotlin 기본 학습
> 코틀린의 기본적인 특징을 학습하는 패키지입니다.
> 
> 👉 [Keyword.kt - 코틀린의 기본 키워드를 학습합니다.](https://github.com/sanghee0820/kotlin-crud/blob/main/src/main/kotlin/practice/kotlincrud/basic/Keyword.kt)

---

## ✅ Keyword.kt 학습 내용

| 항목                                                                                                                                           | 설명                                                              |
|----------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------|
| [typeKeyword()](https://github.com/sanghee0820/kotlin-crud/blob/main/src/main/kotlin/practice/kotlincrud/basic/Keyword.kt#L5-L30)            | 기본 타입(`Byte`, `Int`, `String`, 등)과 컬렉션 타입(`List`, `Map`, `Set`) |
| [functionKeyword()](https://github.com/sanghee0820/kotlin-crud/blob/main/src/main/kotlin/practice/kotlincrud/basic/Keyword.kt#L32-L38)       | `fun` 키워드를 이용한 함수 선언, 기본값 지정, 문자열 템플릿 사용                        |
| [whenKeyword()](https://github.com/sanghee0820/kotlin-crud/blob/main/src/main/kotlin/practice/kotlincrud/basic/Keyword.kt#L40-L47)           | `when` 구문으로 조건 분기 처리 (`switch` 대체)                              |
| [isKeyword()](https://github.com/sanghee0820/kotlin-crud/blob/main/src/main/kotlin/practice/kotlincrud/basic/Keyword.kt#L49-L59)             | `is`, `!is`를 사용한 타입 검사 및 스마트 캐스팅                                |
| [asKeyword()](https://github.com/sanghee0820/kotlin-crud/blob/main/src/main/kotlin/practice/kotlincrud/basic/Keyword.kt#L61-L68)             | `as`, `as?` 키워드를 이용한 강제/안전 타입 캐스팅                               |
| [nullableKeyword()](https://github.com/sanghee0820/kotlin-crud/blob/main/src/main/kotlin/practice/kotlincrud/basic/Keyword.kt#L70-L83)       | nullable 타입(`?`), `?.`, `?:`, `!!` 연산자                          |
| [scopeFunctionKeyword()](https://github.com/sanghee0820/kotlin-crud/blob/main/src/main/kotlin/practice/kotlincrud/basic/Keyword.kt#L85-L144) | `let`, `run`, `apply`, `with`, `also` 스코프 함수                    |
| [lambdaKeyword()](https://github.com/sanghee0820/kotlin-crud/blob/main/src/main/kotlin/practice/kotlincrud/basic/Keyword.kt#L146-L182)       | 람다식 관련                                                          |                                                         |

---

## ✅ KotlinClass.kt 학습 내용

| 항목                                                                                                                                                 | 설명                                                     |
|----------------------------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------|
| [Intro](https://github.com/sanghee0820/kotlin-crud/blob/main/src/main/kotlin/practice/kotlincrud/basic/KotlinClass.kt#L3-L9)                       | 코틀린 클래스 구조 소개                                          |
| [NormalClass](https://github.com/sanghee0820/kotlin-crud/blob/main/src/main/kotlin/practice/kotlincrud/basic/KotlinClass.kt#L12-L51)               | 주 생성자, 보조 생성자, 프로퍼티, init 블록                           |
| [OpenClass](https://github.com/sanghee0820/kotlin-crud/blob/main/src/main/kotlin/practice/kotlincrud/basic/KotlinClass.kt#L54-L78)                 | open 을 통한 상속                                           |
| [AbstractClass](https://github.com/sanghee0820/kotlin-crud/blob/main/src/main/kotlin/practice/kotlincrud/basic/KotlinClass.kt#L81-L114)            | 추상 클래스 상속 방법 및 및 메서드 구현                                |
| [InterfaceClass](https://github.com/sanghee0820/kotlin-crud/blob/main/src/main/kotlin/practice/kotlincrud/basic/KotlinClass.kt#L117-L147)          | 인터페이스의 프로퍼티 기본값 지정 및 기본 메서드                            |
| [DataClass](https://github.com/sanghee0820/kotlin-crud/blob/main/src/main/kotlin/practice/kotlincrud/basic/KotlinClass.kt#L150-L166)               | 데이터 클래스의 equals, hashCode, toString, copy, componentN등 |
| [EnumClass](https://github.com/sanghee0820/kotlin-crud/blob/main/src/main/kotlin/practice/kotlincrud/basic/KotlinClass.kt#L169-L185)               | enum 클래스 선언, 프로퍼티, 메서드                                 |
| [Sealed Class/Interface](https://github.com/sanghee0820/kotlin-crud/blob/main/src/main/kotlin/practice/kotlincrud/basic/KotlinClass.kt#L188-L250)  | sealed 클래스/인터페이스 통한 제한된 상속 및 분기 처리                     |
| [Object/Companion Object](https://github.com/sanghee0820/kotlin-crud/blob/main/src/main/kotlin/practice/kotlincrud/basic/KotlinClass.kt#L253-L309) | object 및 활용 학습                                         |
| [Top-Level](https://github.com/sanghee0820/kotlin-crud/blob/main/src/main/kotlin/practice/kotlincrud/basic/KotlinClass.kt#L312-L320)               | Top-Level 상수 및 함수 정의 학습                                |