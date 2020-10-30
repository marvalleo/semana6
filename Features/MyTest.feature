Feature: Prueba de conexion de BD y login
Scenario: Conexion BD Incorrecta
Given Probar conexion BD ""
Scenario: Conexion BD Correcta
Given Probar conexion BD "jdbc:mysql://localhost:3306/port_bco_plat"

Scenario: Caso 1: Login sin datos
Given abrir navegador
When ingresa Username "" y Password ""
Then inicia sesion

Scenario: Caso 2: Login con datos incorrectos
Given abrir navegador
When ingresa Username "leonXX" y Password "4leon1"
Then inicia sesion

Scenario: Caso 3: Login con datos correctos
Given abrir navegador
When ingresa Username "leon" y Password "leon1"
Then inicia sesion


