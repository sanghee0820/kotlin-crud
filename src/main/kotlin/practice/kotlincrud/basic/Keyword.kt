package practice.kotlincrud.basic

class Keyword {

    fun typeKeyword() {
        //기본 타입
        val byte: Byte = 1 /* 바이트 타입 */
        val short: Short = 1 /* 쇼트 타입 */
        val int: Int = 1 /* 정수 타입 */
        val long: Long = 1L /* 롱 타입*/
        val float: Float = 1.0f /* 플로트 타입*/
        val double: Double = 1.0 /* 더블 타입*/
        val char: Char = 'A' /* 문자 타입 */
        val boolean: Boolean = true /* 불리언 타입 */
        val string: String = "Hello, Kotlin" /* 문자열 타입 */
        val pair: Pair<String, Int> = Pair("Kotlin", 1) /* Pair 타입 */
        val triple: Triple<String, Int, Boolean> = Triple("Kotlin", 1, true) /* Triple 타입 */
        val array: Array<Int> = arrayOf(1, 2, 3) /* 배열 타입 */

        // 컬렉션 타입
        /* 변경 불가능한 타입 */
        val list: List<String> = listOf("Kotlin", "Java", "Python") /* 리스트 타입 */
        val set: Set<String> = setOf("Kotlin", "Java", "Python") /* 셋 타입 */
        val map: Map<String, Int> = mapOf("Kotlin" to 1, "Java" to 2, "Python" to 3) /* 맵 타입 */

        /* 변경 가능한 타입 */
        val mutableList: MutableList<String> = mutableListOf("Kotlin", "Java", "Python") /* 변경 가능한 리스트 타입 */
        val mutableSet: MutableSet<String> = mutableSetOf("Kotlin", "Java", "Python") /* 변경 가능한 셋 타입 */
        val mutableMap: MutableMap<String, Int> = mutableMapOf("Kotlin" to 1, "Java" to 2, "Python" to 3) /* 변경 가능한 맵 타입 */
    }

    fun functionKeyword /* fun 키워드로 함수를 선언할 수 있다.*/ (
        input: String = "input" /* 매개 변수가 없는 경우 기본값을 정의할 수 있다.*/
    ) : String /* 반환 타입을 정의할 수 있다. */ {

        println("입력된 값 : $input") // $로 문자열 내에 변수를 삽입할 수 있다.
        return "코틀린 공부를 시작해요"
    }

    fun whenKeyword(input: String = "코틀린") {
        // switch 문법은 코틀린에서는 when 키워드를 사용한다.
        when (input) {
            "코틀린" -> println("코틀린을 선택했습니다.")
            "자바" -> println("자바를 선택했습니다.")
            else -> println("알 수 없는 언어입니다.")
        }
    }

    fun isKeyword(input: Any) {
        // is 키워드를 사용하여 타입을 검사할 수 있다.
        // is 키워드를 사용하면 객체가 스마트 캐스팅되어 타입이 일치하는 경우 해당 타입으로 변환된다.
        if (input is String) {
            println("입력된 값은 문자열입니다: $input")
        }
        // !is 키워드를 사용하여 타입이 일치하지 않는 경우를 검사할 수 있다.
        if (input !is Int) {
            println("입력된 값은 정수가 아닙니다: $input")
        }
    }

    fun asKeyword(input1: Any, input2: Any) {
        // as 키워드를 사용하여 타입을 변환할 수 있다.
        // as 키워드는 강제 타입 변환을 수행하며, null일 경우 예외가 발생할 수 있다.
        val unsafeTypeCasting = input1 as String

        // as? 키워드를 사용하여 안전한 타입 변환을 수행할 수 있다.
        val safeTypeCasting = input2 as? String
    }

    fun nullableKeyword(
        // 기본적으로 코틀린은 null을 허용하지 않는다.
        nullableInput : String?, // 만약 null을 허용하고 싶다면 타입 뒤에 ?를 붙여서 nullable 타입으로 선언할 수 있다.
        nonNullableInput : String
    ) {
        /*
            1. 안전한 호출 연산자(?.)를 사용하여 null이 아닐 때만 메서드를 호출할 수 있다.
            2. 엘비스 연산자(?:)를 사용하여 null인 경우 대체 값을 제공할 수 있다.
            3. !! 연산자를 사용하여 null이 아님을 보장할 수 있지만, null인 경우 예외가 발생한다.
        */
        println(nullableInput?.length) // null이 출력된다.
        println(nullableInput?.length ?: "null 값입니다.") // null일 경우 "null 값입니다."가 출력된다.
        println(nullableInput!!.length) // null인 경우 NullPointerException이 발생한다. -> 그러므로 지양해야한다.
    }

    fun scopeFunctionKeyword(
        letInput : String?,
        runInput : String?
    ) {
        /*
            .let : 객체를 인자로 받아서 람다식 내부에서 사용하고, 람다식의 결과를 반환한다.
            it을 통해 람다식의 인자를 참조할 수 있다.
            null이 아닌 경우에만 실행되며, null인 경우에는 실행되지 않는다.
        */
        letInput?.let {
            println("The number is $it") // it은 람다식의 인자를 나타낸다.
        }

        /*
            .run : 객체를 인자로 받아서 람다식 내부에서 사용하고, 람다식의 결과를 반환한다.
            this를 통해 람다식의 인자를 참조할 수 있다.
            null인 경우에도 실행되며, null인 경우에는 null을 반환한다.
        */
        val result : Int = runInput?.run {
            println("The number is $this") // this는 람다식의 인자를 나타낸다.
            this.length // 마지막 표현식의 결과가 반환된다.
        } ?: 1 // null인 경우에는 1을 반환한다.

        /*
            .apply : 객체를 인자로 받아서 람다식 내부에서 사용하고, 객체 자체를 반환한다.
            this를 통해 람다식의 인자를 참조할 수 있다.
            주로 객체의 초기화나 설정에 사용된다.
         */
        class ApplyClass(
            var name : String = "defaultName",
            var age : Int = 0
        )
        val apply = ApplyClass().apply {
            this.name = "applyName"
            this.age = 20
            // 자기 자신을 반환한다.
        }

        /*
            .with : 외부 객체를 인자로 받아서 람다식 내부에서 사용하고, 람다식의 결과를 반환한다.
            this를 통해 람다식의 인자를 참조할 수 있다.
            주로 객체의 프로퍼티나 메서드를 호출할 때 사용된다.
         */
        val sb = StringBuilder()
        with(sb) {
            append("Hello, ")
            append("World!")
        }

        /*
            .also : 객체를 인자로 받아서 람다식 내부에서 사용하고, 객체 자체를 반환한다.
            주로 디버깅이나 로깅에 사용된다.
            this를 통해 람다식의 인자를 참조할 수 있다.
         */
        val alsoList = mutableListOf("Kotlin", "Java", "Python")
        alsoList.also {
            println("The list contains: $it") // it은 람다식의 인자를 나타낸다.
        }.add("JavaScript") // also는 객체 자체를 반환하므로, 추가 작업을 이어서 수행할 수 있다.

    }

    /*
        코틀린은 함수를 일급 객체로 취급한다.
        즉, 함수를 변수에 할당하거나 다른 함수의 인자로 전달할 수 있다.
        이를 통해 함수형 프로그래밍을 지원하며, 람다식과 고차 함수를 사용할 수 있다.
     */
    fun lambdaKeyword(
        op1: () -> Unit,
        op2: (Int, Int) -> Int,
        nullableOp : ((Int, Int) -> Int)? // nullableOp는 null일 수도 있는 람다식
    ) {
        /*
            람다식은 함수형 프로그래밍을 지원하는 코틀린의 중요한 기능 중 하나이다.
            람다식은 함수의 인자로 전달되거나 변수에 할당될 수 있다.
            람다식은 중괄호({})로 정의되며, 매개변수와 반환 타입을 명시할 수 있다.
         */
        val sum: (Int, Int) -> Int = { a, b -> a + b } // 두 개의 정수를 받아서 합을 반환하는 람다식
        println("Sum: ${sum(1, 2)}") // Sum: 3

        // Unit 타입의 람다식은 반환값이 없음을 나타낸다.
        val greet: (String) -> Unit = { name -> println("Hello, $name!") } // 문자열을 받아서 인사하는 람다식
        greet("Kotlin") // Hello, Kotlin!

        op1() // Unit 타입의 람다식 호출
        val result = op2(3, 4) // 두 개의 정수를 받아서 연산하는 람다식 호출

        // nullableOp는 ?.let을 사용하거나 ?.invoke를 사용하여 null이 아닐 때만 호출할 수 있다.
        nullableOp?.let {
            it(5, 6) // nullableOp가 null이 아닐 때만 호출
        }
        nullableOp?.invoke(5, 6)

        //컬렉션 관련 함수
        val numbers = listOf(1, 2, 3, 4, 5)
        val filterIterator = numbers.filter{
            it % 2 == 0
        } // 짝수만 필터링 해 iterator를 반환한다.
    }
}