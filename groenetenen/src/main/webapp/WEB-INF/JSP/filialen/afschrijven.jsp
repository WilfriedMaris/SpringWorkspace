<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='form' uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix='v' uri='http://vdab.be/tags'%>
<!doctype html>
<html lang='nl'>
<head>	
	<v:head title="Afschrijven"/>
</head>
<body>
	<v:menu />
	<h1>Filiaal afschrijven</h1>
	<form:form commandName="afschrijvenForm">
		<form:label path="filialen">
			Filiaal:
			<form:errors path='filialen'/>
		</form:label>
		<form:checkboxes path="filialen" items="${filialen}" itemLabel="naam" itemValue="id" element="div"/>
		<input type="submit" value="Afschrijven"/>
	</form:form>
</body>
</html>