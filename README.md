# SolucionHackerankXpertGroup
Solucion al Algoritmo Planteado



El proyecto se debe importar como un proyecto gradle. Una vez corriendo se puede consultar la api expuesta en la url 
DOMINIO/swagger-ui.html asi como realizar pruebas y ver el formato de json aceptado por la aplicacion.

A continuación se especifica el Json que corresponde a la prueba de ejemplo planteada por Hackerranck.

[
  {
    "operaciones": [
      "UPDATE 2 2 2 8",
			"QUERY 1 1 1 3 3 3",
			"UPDATE 1 1 1 23",
			"QUERY 2 2 2 4 4 4",
			"QUERY 1 1 1 3 3 3"
    ],
    "tamanoMatriz": 4
  },{
		"operaciones": [
    "UPDATE 2 2 2 1",
		"QUERY 1 1 1 1 1 1",
		"QUERY 1 1 1 2 2 2",
		"QUERY 2 2 2 2 2 2"
    ],
    "tamanoMatriz": 2
	}
]


# Respuesta a las preguntas de acceso planteadas en el documento

Ejercicio:
1.Las capas usadas para la resolucion de la prueba fueron las capas de dominio,infraestructura y aplicacion y las clases pertenecientes a cada una se pueden observar claramente en el codigo. La prueba se realizo basado en una arquitectura hexagonal.

2.Considero que esta parte  se puede ver claramente del codigo . Si no es asi , preferiria explicarla directamente mediante una llamada o por otro medio que facilite la explicacion debido a temas de tiempo.


Preguntas

1.El principio de responsabilidad unica dice que cada clase de la aplicacion debe tener una y solo una responsabilidad.Este principio es bastante importante para la legilibilidad de la aplicacion pues hace  mas facil para una persona entender como los elementos de la aplicacion se comunican entre si y entender facilmente donde se debe buscar en el codigo para localizar donde se esta llevando acabo una logica en especifico.Una buena practica que puede ayudar demasiado a tomar buenas decisiones y a localizar violaciones de este principio es por ejemplo con la inyeccion de dependencias por constructor pues cuando se detectan demasiadas dependencias en una clase esto puede ser un alto indicador de que la clase esta realizando mas tareas de las que le corresponden.


2.El codigo limpio abarca todas esas estrategias y patrones de diseño de software para hacer una construccion de software legible y mas importante aun que cada clase y metodo de codigo escrito pueda revelar facilmente su intencion.El codigo limpio es muy importante por que crea un estandar de buenas practicas que nos ahorra un gran tiempo de entendimiento del mismo. Con codigo limpio se escribe software pensando en los demas y no solo en la perspectiva del autor.Este tipo de concepto no se basa solo en la legilibilidad si no que comunmente habla tambien de la certeza de funcionalidad y consejos de como probar nuestro codigo de la mejor manera.




