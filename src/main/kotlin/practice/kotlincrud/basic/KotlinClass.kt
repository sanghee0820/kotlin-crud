package practice.kotlincrud.basic

/*
 * 코틀린은 자바와 다르게 .kt 파일 내에 여러개의 클래스를 작성 가능하다.
 * 즉, .kt 파일의 이름과 클래스가 일치하지 않아도 된다.
 * Top-Level 선언을 지원한다
 * 클래스의 프로퍼티는 자동으로 getter와 setter가 생성된다.
 *  단, val로 선언된 프로퍼티는 getter만 생성된다.
 */


/*
 * 일반 클래스:
 * 아무 키워드도 붙이 않으면 final 클래스가 된다.
 * 아무 키워드도 붙이지 않으면 final 클래스가 되므로, 프록시 객체 생성이 필요한 JPA에서는 문제가 발생할 수 있다.
 * Kotlin 에서는 이를 해결하기 위해 open 키워드나, all-open 플러그인을 사용하는 것이 일반적이다.
 */
class NormalClass(
    /*
     * 위의 ()로 정의된 생성자는 주 생성자(primary constructor)라고 한다.
     * 주 생성자 안에 프로퍼티를 정의할 수 있다.
     * 주 생성자 안에 정의된 프로퍼티는 인스턴스 생성 시 입력값을 전달해야한다.
     */
    val normal: String
) {
    /*
     * 주 생성자 내에 프로퍼티를 정의하지 않는 경우 수동으로 프로퍼티를 정의해야한다.
     * init 블록 이나, 보조 생성자(secondary constructor)를 사용하여 프로퍼티를 초기화할 수 있다.
     */
    var age: Int
    /*
     * init 블록은 클래스가 인스턴스화될 때 실행되는 초기화 블록이다.
     *
     */
    init {
        println("NormalClass가 생성되었습니다. normal: $normal")
        this.age = 1
    }
    // 추가적인 초기화 작업을 수행할 수 있다.
    init {
        println("두 번째 init 블록이 실행되었습니다.")
    }

    /*
     * 보조 생성자(secondary constructor)는 클래스 내부에 추가적인 생성자를 정의할 수 있다.
     * 반드시 주 생성자를 호출하거나 다른 보조 생성자를 호출해야한다.
     */
    constructor(intNormal: Int): this(intNormal.toString()) {
        this.age = 10
    }
}


/*
 * open 클래스:
 * open 키워드를 붙이면 상속이 가능한 클래스가 된다.
 * JPA 엔티티로 사용할 수 있다.
 */
open class OpenClass(
    open val openProperty: String
) {

    open fun openMethod() {
        println("OpenMethod")
    }
}

/*
 * :를 통해 부모 클래스를 상속받을 수 있다.
 */
class OpenChildClass1(
    openProperty: String
): OpenClass(openProperty) { // 이 부분이 부모 클래스의 생성자를 호출하는 부분이다.

    override fun openMethod() {
        println("OpenChildMethod")
    }
}


/*
 * 추상 클래스: 자바와 같이 abstract 키워드를 붙이면 추상 클래스가 된다.
 * 추상 클래스는 인스턴스를 생성할 수 없고, 반드시 상속받아야 한다.
 * 추상 클래스는 추상 메서드를 가질 수 있으며, 추상 메서드는 구현부가 없는 메서드이다.
 */
abstract class AbstractClass(
    val abstractProperty: String
) {
    // 추상 메서드는 구현부가 없는 메서드이다.
    abstract fun abstractMethod()

    /*
     * 일반 메서드는 구현부가 있는 메서드이다.
     * 이를 상속하도록 하기 위해선 open 키워드를 붙여야 한다.
     */
    open fun normalMethod() {
        println("Normal Method")
    }
}

class AbstractChildClass(
    abstractProperty: String
): AbstractClass(abstractProperty) {

    // 추상 메서드를 구현해야 한다.
    override fun abstractMethod() {
        println("Abstract Method Implemented")
    }

    // open 처리 된 메서드를 오버라이드할 수 있다.
    override fun normalMethod() {
        println("Overridden Normal Method")
    }
}


/*
 * 인터페이스: 자바와 같이 interface 키워드를 사용하여 인터페이스를 정의할 수 있다.
 * 인터페이스에 정의된 default 매서드는 기본적으로 open 처리되어 상속이 가능하다.
 */
interface InterfaceClass {
    // 프로퍼티를 가질 수 있고, 무조건 override를 통해 구현해야 한다.
    // 단 get()을 통해 기본값을 제공하면 구현하지 않아도된다.
    val interfaceProperty: String
//       = "Default Value" // 인터페이스는 실제 값을 저장할 저장소가 없기 때문에 기본값을 지정할 수 없다.
                get() = "Default Value" // get()을 통해 기본값을 지정한 것 처럼 제공이 가능하다

    // 인터페이스의 메서드는 기본적으로 abstract이다.
    fun interfaceMethod()

    fun defaultMethod() { // 인터페이스의 메서드에 기본 구현을 제공할 수 있다.
        println("Default Method in Interface")
    }
}

class InterfaceClassImpl(
    override val interfaceProperty: String
) : InterfaceClass {

    override fun interfaceMethod() {
        println("인터페이스 메서드 구현")
    }

    override fun defaultMethod() {
        println("오버라이드된 인터페이스 기본 메서드")
    }
}


/*
    * 데이터 클래스: Java의 Record와 유사하게 데이터를 저장하기 위한 클래스이다.
    * 데이터 클래스의 주 생성자에는 하나 이상의 프로퍼티를 정의해야 한다.
    * 하지만, var로도 선언할 수 있다.
    * equals(), hashCode(), toString(), copy(), componentN() 함수가 메서드가 자동으로 생성된다.
    * 주로 데이터 전송 객체(DTO)로 사용된다.
 */
data class DataClass(
    val id: Int,
    var name: String
) {
    /*
     * copy() 매서드는 인스턴스를 복사할 때 사용된다.
     * 값의 일부를 변경할 수 있다.
     * 예시: val newData = data.copy(name = "New Name")
     */
}


/*
 * Enum 클래스: 자바의 enum과 같이 상수들을 정의할 수 있는 클래스이다.
 */
enum class EnumClass(
    val value: String
) {
    // enum 클래스는 상수들을 정의할 수 있다.
    // 각 상수는 EnumClass의 인스턴스이다.
    FIRST("First"),
    SECOND("Second"),
    THIRD("Third");

    // enum 클래스는 메서드를 가질 수 있다.
    fun printValue() {
        println("Value = $value")
    }
}


/*
* Sealed 클래스: 자바의 sealed class와 유사하게 상속을 제한할 수 있는 클래스이다.
* sealed 클래스는 상속을 제한하여 특정 클래스들만 상속할 수 있도록 한다.
* 같은 파일 내에서만 상속이 가능하다.
* 자동으로 abstract 클래스로 처리돼, 인스턴스화가 불가능하다.
* when과 함께 사용하면 모든 하위 클래스를 처리할 수 있다.
 */
sealed class SealedClass

data class SealedChildClass1(
    val name: String
) : SealedClass()

data class SealedChildClass2(
    val age: Int
) : SealedClass()

fun sealedClassFunction(input : SealedClass) {
    // sealed 클래스를 when과 함께 사용하여 모든 하위 클래스를 처리할 수 있다.
    when (input) {
        is SealedChildClass1 -> println("SealedChildClass1: ${input.name}")
        is SealedChildClass2 -> println("SealedChildClass2: ${input.age}")
    }
}

/*
 * sealed interface : 특정 구현체만 정의될 수 있도록 제한된 인터페이스이다.
 * 같은 파일 내에서만 구현 가능하며, when 식에서 exhaustive 체크를 강제할 수 있다.
 * sealed class와 달리 다중 상속이 가능하며, 상태값을 직접 가질 수는 없다.
 */
sealed interface SealedInterface {
    val interfaceProperty: String
        get() = "Default Value"

    fun interfaceMethod()
}
sealed interface SealedInterface2

data class SealedInterfaceImpl1(
    val name: String
) : SealedInterface, SealedInterface2 {
    override fun interfaceMethod() {
        println("SealedInterfaceImpl1 Method")
    }
}

data class SealedInterfaceImpl2(
    val age: Int
) : SealedInterface, SealedInterface2 {
    override fun interfaceMethod() {
        println("SealedInterfaceImpl2 Method")
    }
}
fun sealedClassCheck(sealedInterface: SealedInterface) {
    when (sealedInterface) {
        is SealedInterfaceImpl1 -> {
            sealedInterface.interfaceMethod()
        }
        is SealedInterfaceImpl2 -> {
            sealedInterface.interfaceMethod()
        }
    }
}


/*
    * Object 클래스: 자바의 Static 패턴과 유사하게 단일 인스턴스를 생성할 수 있는 클래스이다.
    * object는 JVM 내에서 lazy + thread-safe 하게 인스턴스를 생성한다.
    * 인스턴스를 단 하나만 생성하고, 전역에서 공유할 수 있다.
    * 주로 Utility 클래스나, 상태 보관 객체, sealed 타입 분기에 사용한다.
 */
object ObjectUtilityClass {
    // Object 클래스는 프로퍼티와 메서드를 가질 수 있다.
    val objectProperty: String = "Object Property"

    // Object 클래스의 메서드
    fun printObjectMessage() {
        println("Object Utility Method Called")
    }
}

fun objectUtilityFunction() {
    // Object 클래스의 프로퍼티를 사용할 수 있다.
    println(ObjectUtilityClass.objectProperty)
    ObjectUtilityClass.printObjectMessage()
}

object ObjectStatusClass {
    /*
     * const는 컴파일 타임 상수를 정의할 때 사용된다.
     * 하지만 이것보다 Top-Level 상수로 정의하는 것이 더 좋다.
     */
    const val STATUS_ACTIVE = "Active"
    const val STATUS_INACTIVE = "Inactive"
}

fun objectStatusFunction() {
    println("Status: ${ObjectStatusClass.STATUS_ACTIVE}")
    println("Status: ${ObjectStatusClass.STATUS_INACTIVE}")
}

/*
 * Enum 과 유사하게 Sealed Class와 Object 클래스를 사용하여 상태를 정의할 수 있다.
 * 하지만, SealedC Class + Object는 상태를 정의하는데 더 유연하다.
 * 예를 들어, 상태마다 추가 데이터가 필요하거나, 타입마다 로직이 달라야할 때 유용하다.
 */
sealed class ObjectSealedClass {
    object Loading : ObjectSealedClass() {
        val loadingProperty: String = "Loading State"
        val loadingProperty2: String = "Loading State 2"
        fun loadingMessage() {
            println("Property $loadingProperty")
            println("Property $loadingProperty2")
        }
    }
    object Success : ObjectSealedClass() {
        val successProperty: String = "Success State"
        fun successMessage() {
            println("Property $successProperty")
        }
    }
}


/*
 * Top-Level: 코틀린은 클래스 안에 속하지 않은 위치(파일의 최상단)에 함수, 변수, 상수 등을 선언할 수 있다.
 * Java의 static 멤버처럼 사용되며, import만으로 접근할 수 있다.
 */
const val TOP_LEVEL_CONSTANT = "Top Level Constant" // Top-Level 상수 선언

fun topLevelFunction() {
    println("Top-Level Function Called")
}