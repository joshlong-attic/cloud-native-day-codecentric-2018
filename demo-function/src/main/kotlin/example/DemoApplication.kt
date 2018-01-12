package example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class DemoApplication {

	@Bean
	fun function() = java.util.function.Function<DemoRequest, DemoResponse> {
		DemoResponse(message = "Hello, ${it.id}!")
	}
}

class DemoResponse(var message: String? = null)
class DemoRequest(var id: String? = null)