1. Primer informe. 

Generar un informe basándose en la tabla con la información respectiva al “Líder”. El 
listado debe contener: el ID_Lider, el Nombre, el Primer_Apellido y la Ciudad_Residencia. 
Este informe debe estar ordenado por la “Ciudad_Residencia” de forma alfabética.

SELECT ID_Lider as Id, Nombre, Primer_Apellido as Apellido, Ciudad_Residencia as Ciudad 
FROM Lider l 
ORDER BY Ciudad_Residencia;