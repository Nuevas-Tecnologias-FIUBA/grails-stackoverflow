<!DOCTYPE html>
<html>
	<head>
		<title>Welcome to Grails</title>
	</head>
	<body>
		<table>
			<tr>
				<td>nombre de usuario</td>
				<td>lenguajes</td>
			</tr>
			<g:each in="${programadores}" var="programador">
				<tr>
					<td>${programador.nombreDeUsuario}</td>
					<td>${programador.lenguajes}</td>
					<td>
						<g:link action="verProgramador" id="${programador.id}">
							ver perfil
						</g:link>
					</td>
				</tr>
			</g:each>
		</table>
	</body>
</html>
