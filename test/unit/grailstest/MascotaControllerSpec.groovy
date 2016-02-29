package grailstest



import grails.test.mixin.*
import spock.lang.*

@TestFor(MascotaController)
@Mock(Mascota)
class MascotaControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.mascotaInstanceList
            model.mascotaInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.mascotaInstance!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def mascota = new Mascota()
            mascota.validate()
            controller.save(mascota)

        then:"The create view is rendered again with the correct model"
            model.mascotaInstance!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            mascota = new Mascota(params)

            controller.save(mascota)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/mascota/show/1'
            controller.flash.message != null
            Mascota.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def mascota = new Mascota(params)
            controller.show(mascota)

        then:"A model is populated containing the domain instance"
            model.mascotaInstance == mascota
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def mascota = new Mascota(params)
            controller.edit(mascota)

        then:"A model is populated containing the domain instance"
            model.mascotaInstance == mascota
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'PUT'
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/mascota/index'
            flash.message != null


        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def mascota = new Mascota()
            mascota.validate()
            controller.update(mascota)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.mascotaInstance == mascota

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            mascota = new Mascota(params).save(flush: true)
            controller.update(mascota)

        then:"A redirect is issues to the show action"
            response.redirectedUrl == "/mascota/show/$mascota.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'DELETE'
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/mascota/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def mascota = new Mascota(params).save(flush: true)

        then:"It exists"
            Mascota.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(mascota)

        then:"The instance is deleted"
            Mascota.count() == 0
            response.redirectedUrl == '/mascota/index'
            flash.message != null
    }
}
