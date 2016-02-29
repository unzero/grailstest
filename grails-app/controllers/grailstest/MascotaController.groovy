package grailstest



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class MascotaController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Mascota.list(params), model:[mascotaInstanceCount: Mascota.count()]
    }

    def show(Mascota mascotaInstance) {
        respond mascotaInstance
    }

    def create() {
        respond new Mascota(params)
    }

    @Transactional
    def save(Mascota mascotaInstance) {
        if (mascotaInstance == null) {
            notFound()
            return
        }

        if (mascotaInstance.hasErrors()) {
            respond mascotaInstance.errors, view:'create'
            return
        }

        mascotaInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'mascota.label', default: 'Mascota'), mascotaInstance.id])
                redirect mascotaInstance
            }
            '*' { respond mascotaInstance, [status: CREATED] }
        }
    }

    def edit(Mascota mascotaInstance) {
        respond mascotaInstance
    }

    @Transactional
    def update(Mascota mascotaInstance) {
        if (mascotaInstance == null) {
            notFound()
            return
        }

        if (mascotaInstance.hasErrors()) {
            respond mascotaInstance.errors, view:'edit'
            return
        }

        mascotaInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Mascota.label', default: 'Mascota'), mascotaInstance.id])
                redirect mascotaInstance
            }
            '*'{ respond mascotaInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Mascota mascotaInstance) {

        if (mascotaInstance == null) {
            notFound()
            return
        }

        mascotaInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Mascota.label', default: 'Mascota'), mascotaInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'mascota.label', default: 'Mascota'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
