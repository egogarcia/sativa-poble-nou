class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/sativaTemplate/login")
        "/tarjeta-detectada"(controller:"card",action:"dispatcher")
        name createMember: "/crear-socio"(view:"/sativaTemplate/createMember")
        name searchMember: "/buscar-socio"(controller:"member", action:"list")
        name managementMembers: "/gestionar-usuarios"(controller:"member", action:"all")
        name managementGenetics: "/gestionar-geneticas" (controller:"genetic", action:"list")
        name stadistics: "/estadisticas"(controller:"geneticOrders", action:"stadistics")
        name searchPartner: "/gestionar-socio"(controller:"partner", action:"list")
        name listInvitate: "/invitados"(controller:"member", action:"guests")

        
        "500"(view:'/error')
	}
}
