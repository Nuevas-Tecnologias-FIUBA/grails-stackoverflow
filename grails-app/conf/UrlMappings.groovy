class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		'/los-programadores-mas-capo'(controller: 'solucion', action: 'verProgramadores')

		"/"(view:"/index")
		"500"(view:'/error')
	}
}
