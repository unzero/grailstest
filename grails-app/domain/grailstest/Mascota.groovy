package grailstest

class Mascota {

	String nombre
	int edad 

    static constraints = {
    	nombre(minSize:1)
    	edad(min:1)
    }
}
