<%@ page import="grailstest.Mascota" %>



<div class="fieldcontain ${hasErrors(bean: mascotaInstance, field: 'nombre', 'error')} required">
	<label for="nombre">
		<g:message code="mascota.nombre.label" default="Nombre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombre" required="" value="${mascotaInstance?.nombre}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: mascotaInstance, field: 'edad', 'error')} required">
	<label for="edad">
		<g:message code="mascota.edad.label" default="Edad" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="edad" type="number" min="1" value="${mascotaInstance.edad}" required=""/>

</div>

