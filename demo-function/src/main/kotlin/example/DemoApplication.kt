package example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.context.annotation.Bean

/**
 * If you want to run it locally, make sure that `spring-cloud-function-web` is marked as NOT provided to demo this locally.
 * <CODE>
 *   curl -d'{"id":"Spring"}' -H"Content-type: application/json" -XPOST http://localhost:8080/function
 * </CODE>
 *
 */
@SpringBootApplication
class DemoApplication {

	@Bean
	fun function() = java.util.function.Function<DemoRequest, DemoResponse> {
		DemoResponse(message = "Hello, ${it.id}!")
	}
}

class DemoResponse(var message: String? = null)
class DemoRequest(var id: String? = null)

fun main(args: Array<String>) {
	SpringApplicationBuilder()
			.sources(DemoApplication::class.java)
			.run(*args)
}