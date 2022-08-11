Tercer informe.

Realizar un informe basándose en las compras realizadas por los proyectos con el proveedor
“Homecenter” y para la ciudad “Salento”. Este informe debe incluir: ID_Compra, 
Constructora y Banco_Vinculado.

SELECT c.ID_Compra as ID, p.constructora, p.Banco_Vinculado as Banco 
FROM Compra c 
JOIN Proyecto p
ON c.ID_Proyecto = p.ID_Proyecto
WHERE c.Proveedor = 'Homecenter' AND p.Ciudad = 'Salento';