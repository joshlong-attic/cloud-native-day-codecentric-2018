package example

import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler

class DemoHandler : SpringBootRequestHandler<DemoRequest, DemoResponse> {

	constructor(configurationClass: Class<*>) : super(configurationClass)

	constructor() : super()
}
