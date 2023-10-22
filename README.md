<h1 align="center">Empresa HUMAJU</h1>

:construction:Proyecto Terminado:construction:
<br>
<br>
:page_with_curl:<h4>Descripción</h4>:page_with_curl: 
<br>
<p><strong>Aplicación de escritorio cuyo propósito es la fácil administración de las ventas; clientes, los productos en existencia ,así como los pedidos que se realizan en la empresa HUMAJU. Para usarse de una manera lo más intuitiva posible.</strong></p>
<br>
<br>
Sistema de información para los procesos de compra venta de una empresa.

Definición del Problema

La empresa Humaju al presentar este tipo de problemas en las áreas de compras y ventas
le ha ocasionado lo siguiente:
 El tiempo para la elaboración de la  orden de venta y  el comprobante de pedido del
cliente, demanda demasiado tiempo ya que para emitir la orden de servicio se tiene
que validar la información con los documentos en  físico con respecto a los
productos que soliciten, además una vez realizado la venta la emisión del
comprobante se genera a través de facturas que son registradas de manera manual,
toda esta actividad genera demoras debido que al contar con toda la información en
físico no se puede acceder a ella fácilmente, incluso si el cliente es nuevo o
recurrente, siempre se tendrán que volver a tomar los datos para la emisión del
comprobante, lo cual, ocasiona demoras en la atención.  
 El tiempo de elaboración de la orden de compra para los productos faltantes, esta
actividad genera retrasos ya que los inventarios se manejan de manera escrita, lo
cual, genera que se invierta demasiado tiempo en la consolidación para la reposición
de todos los productos faltantes y en muchas ocasiones se tiene que volver hacer el
inventario de los artículos debido a que la información no es exacta.  
 El tiempo para emitir la cotización al cliente, el cual, varía de acuerdo al
requerimiento o necesidad del mismo, en donde en muchas ocasiones los clientes
quedan en cola esperando ser atendidos debido a que la atención se realiza de
manera manual y esto demanda mucho tiempo. 
 El tiempo para la elaboración del kardex valorizado, esta actividad controla y
registra todas las entradas y salidas de los productos de manera manual, lo que lleva
demasiado tiempo debido a que la información está incompleta y los materiales no
se encuentran con facilidad. 
 El tiempo para generar el pedido a los proveedores, esta actividad demanda
demasiado tiempo ya que la realizan de manera manual, debido que al no contar
con una base de datos o un sistema de información se tiene que realizar por cada
orden todos los documentos emitidos al proveedor, lo cual, de por sí ya genera
retraso en la adquisición de productos y en la atención a los clientes.   
 El nivel de Satisfacción del cliente, debido a los problemas presentados la
satisfacción que tiene el cliente hacia los servicios brindados por la empresa han
ido disminuyendo conforme a los inconvenientes mostrados. 

3.1 PLANEAMIENTO DEL PROYECTO
3.1.1 Modelamiento de Empresa 
Descripción de Empresa  
La empresa Humaju es una empresa fundada por tres amigos, Hugo, Manuel y Juan,
es por ello el nombre de HUMAJU. Esta empresa se dedica a la compra y venta de
repuestos automotrices, lo cual ya tienen cuatro años en el mercado. 
Misión 
Somos una empresa dedicada a atender las necesidades de repuestos y servicios en
el mercado automotor a través del mejor equipo humano, brindando un excelente
servicio de venta, post venta y mantenimiento a nuestros clientes. Somos
distribuidores de repuestos originales y alternativos de calidad a precios
competitivos. 
Visión  
Ser la mejor empresa importadora y comercializadora de repuestos automotrices en
el Perú, brindando un excelente servicio en venta y post-venta, generando valor
agregado para nuestros clientes y la sociedad. 


3.1.2 Visión del Producto 
Geográfico: El proyecto beneficiará al proceso de extracción de información
concerniente al proceso de Compras y Ventas de la empresa Humaju. 
Organizacional: Optimizará el proceso de extracción de información del área de
funcional de compras y ventas. 
Funcional: Mayor respaldo a la obtención de información del área de Compras y
Ventas de manera rápida, precisa, eficiente, para mayor entendimiento del personal,
y los directores generales de la empresa, de modo que la toma de decisiones sea
adecuada y precisa.
Beneficios: Los principales beneficios que se obtendrán al implementar el Sistema
de Información en la empresa Humaju: 
 El sistema puede ser utilizado simultáneamente por varios usuarios, haciendo
consultas, capturas y finalmente arrojando reportes para la toma de decisiones. 
 El acceso rápido a la información y por ende mejora en la atención a los
clientes. 
 Generación de informes e indicadores, que permiten corregir fallas difíciles de
detectar y controlar con un sistema manual. 
 Evitar pérdida de tiempo recopilando información que ya está almacenada en
base de datos que se puede compartir.




	Análisis del Sistema 
En este proceso realizó el análisis del Sistema de Información para los procesos de
compras y ventas de la empresa Humaju. 
Definición de actores del sistema  
Se ha identificado los siguientes actores de la construcción del sistema de información. 
 Asesor de Ventas: Es el actor encargado de registrar las ventas, registrar a los
clientes. realizar las cotizaciones que se soliciten. 
 Jefe de Logística: Es el actor encargado de generar las órdenes de compras, así
como también de realizar los reportes de las compras y ventas que se realizan. 
 Asistente de Logística: Es el encargado de registrar los productos, así como
también ayudar en generar los reportes.



Especificación Casos de Uso 
ECU 01 – Logueo del sistema 
Actores: Usuario  
Propósito  
Permitir al usuario el inicio y cierre de sesión, manteniendo la seguridad del sistema
mediante la validación de usuarios. 
Breve Descripción 
El caso de uso comienza cuando el usuario desea ingresar el registro de obras, para lo
cual ingresa su nombre de usuario y contraseña. Una vez terminado sus actividades
procede a cerrar sesión. 
Flujo Básico de Eventos 
 El usuario visualiza la pantalla de Login.
 El usuario digita su nombre y contraseña.
 El usuario acepta en el botón Ingresar.
 El sistema muestra el sistema al que ingreso.
 El usuario realiza la actividad requerida.
 El usuario cierra sesión.
 El sistema cierra la pantalla Principal. 
Flujos alternativos 
 Si el usuario no desea ingresar al sistema, presiona el botón cancelar en la pantalla
principal y automáticamente saldrá del sistema. 
 
 Si los datos ingresados del usuario no son válidos, el sistema detecta que se ha
ingresado información valida mostrara un mensaje de error, por el cual se debe de
ingresar los datos nuevamente.

ECU02-Registrar Cliente 
Actores: Asesor de Ventas 
Propósito  
Permitir al usuario registrar al cliente en el sistema. 
Breve Descripción 
El caso de uso comienza cuando el usuario desea registrar un cliente al sistema. 
Flujo básico de eventos 
 El usuario ingresa a la pantalla de Registrar Cliente.
 El usuario visualiza todos los datos que tiene que ingresar y se los solicita al cliente.
 El usuario ingresa todos los datos requeridos.
 El sistema guarda el registro ingresado.
 El sistema muestra el mensaje de confirmación de registro. 
Sub Flujos 
Nuevo Proyecto 
 El usuario ingresa los datos del cliente.
 El usuario confirma la acción de guardar.
 El sistema guarda y registra al cliente. 
Flujos Alternativos 
 No se ingresaron todos los datos. Si no ingresaron todos los datos el sistema
mostrara una alerta de ingresar todos los datos. 
 Si el sistema no puede registrar los datos se creará una nueva ficha. 

ECU03-Registrar Venta
Actores: Cliente, Asesor de Ventas

Propósito
Permitir al usuario registrar la venta que se está realizando a los clientes.

Breve Descripción
El caso de uso comienza cuando el usuario necesita registrar la venta de los clientes.

Flujo Básico de eventos
 El usuario visualiza la pantalla de Registrar Ventas.
 El usuario visualiza el listado de productos que se encuentran en stock.
 El usuario elige los productos solicitados por el cliente.
 El sistema le muestra los productos seleccionados con los precios correspondientes.
 El sistema muestra la cantidad total que el cliente tiene que pagar.
 El sistema guarda la venta realizada.
Flujos alternativos
 El usuario no puede dejar ningún campo solicitado vacío.
 El sistema tiene que mostrar todos los datos actualizados.

Actores: Cliente, Asesor de Ventas  
Propósito 
Permitir al usuario realizar cotizaciones a los clientes. 
Breve Descripción  
El caso de uso comienza cuando el usuario necesita realizar una cotización  
Flujo Básico de eventos 
 El usuario visualiza la pantalla de Realizar Cotización.
 El usuario selecciona los productos que desea hacer la cotización el cliente.
 El sistema le muestra los productos seleccionados si se encuentran en stock.
 El sistema le realiza la cotización.
Flujos Alternativos 
 El usuario no puede realizar la cotización si el cliente no está registrado.
 El sistema no realizara la cotización si los productos seleccionados no se encuentran
en el stock.
 

ECU05-Registrar Productos  
Actores: Jefe de Logística, Asistente de Logística 
Propósito 
Permitir al usuario registrar el producto en el sistema. 
Breve Descripción 
El caso de uso comienza cuando el jefe de logística asigna al asistente de logística
registrar los productos. 
Flujo Básico de eventos 
 El usuario visualiza la pantalla de Registrar Productos.
 El usuario registra la lista de productos actualizada.
 El usuario ingresa los datos de los productos.
 El sistema guarda los productos según su categoría.
 El sistema actualiza el stock después del registro.

Flujos alternativos
 El usuario no puede dejar ningún campo solicitado vacío.
 El sistema tiene que mostrar todos los productos actualizados.
ECU06-Generar orden de compra  
Actores: Jefe de Logística 
Propósito 
Permitir al usuario generar el orden de compra. 
Breve Descripción 
El caso de uso comienza cuando el jefe de logística genera el orden de compra hacia
los proveedores. 
Flujo Básico de eventos 
 El usuario visualiza la pantalla de realizar cotizaciones.
 El usuario seleccionar los productos faltantes.
 El sistema realiza una ficha de los productos faltantes que ha seleccionado el
usuario.
 El sistema genera la orden de compra según lo solicitado por el usuario. 
Flujos alternativos 
 El usuario no puede dejar ningún campo solicitado vacío.
 El sistema mostrara solo los productos faltantes.
ECU07-Generar reportes de stock  
Actores: Jefe de Logística, Asistente de Logística 
Propósito 
Permitir al usuario generar los reportes del stock. 
Breve Descripción 
El caso de uso comienza cuando el jefe de logística solicita los reportes de stock al
asistente de logística. 
Flujo Básico de eventos 
 El usuario visualiza la pantalla de generar reportes.
 El usuario seleccionar el reporte que desea realizar.
 El sistema le muestra las opciones que requiere para hacer el reporte (semanal,
mensual).
 El sistema mostrara una ficha general, y una estadística según lo que el usuario ha
solicitado. 
 El sistema genera el reporte y lo guarda. 
 
Flujos alternativos 
 El sistema mostrara los reportes de compras y ventas, por lo cual el usuario
seleccionara el que desee visualizar.

ECU08-Generar comprobante de pago del cliente 
Actores: Asesor de Ventas, Cliente 
Propósito 
Permitir al usuario generar comprobante de pago para cliente. 
Breve Descripción 
El caso de uso comienza cuando el usuario necesita generar un comprobante de pago
para el cliente. 
Flujo Básico de eventos 
 El usuario visualiza la pantalla de comprobante de pago.
 El usuario selecciona los productos por pagar del cliente.
 El sistema genera el comprobante de pago según lo solicitado por el usuario. 
Flujos alternativos 
 El usuario no puede dejar ningún campo solicitado vacío.
<br>
<br>
:page_with_curl:<h4>Guía de uso</h4>:page_with_curl: 
<br>
<p><strong>
 Al correr la aplicación aparece ante el usuario una ventana con tres opciones :
 
 Personal : al seleccionar esta opción tendrá que ingresar su nombre y contraseña para acceder a una de las tres categorías de empleado de la empresa, en un principio no habrá nadie registrado por lo tanto deberá escribir su nombre , contraseña y seleccionar uno de los tres empleos debajo ,al presionar el botón registrarse sus datos serán recogidos por el sistema y obtendrá los permisos para tratar diferentes aspectos de la empresa. Si se accede como Asesor de Ventas podrá administrar las ventas y registrar los nuevos clientes , si accede como Jefe de Logistica podrá registrar los pedidos que ahace la empresa a sus proveedores , y si accede como Asistente de Logistica tendrá la función de registrar los productos del almacén.

 Almacen : al seleccionar esta opción aparece una tabla con los productos que tiene la empresa; nombre del producto ,proveedor ,precio de venta y cantidad en existencia.

 Pedidos : al seleccionar esta opción aparece una tabla con los pedidos que tiene la empresa; nombre del producto ,proveedor ,precio total del pedido y cantidad pedida.

 
</strong></p>
<br>
<br>
:page_with_curl:<h4>Guía de instalación</h4>:page_with_curl: 
<br>
<p><strong>
 Debe tener instalado en su ordenador un jdk de una version preferentemente reciente para poder procesar el lenguaje de programación java. La carpeta donde se ubica el proyecto debe abrirla con algun id de programación , se recomienda el Visual Studio Code que fue el empleado en la realización de la aplicación.
</strong></p>
<br>
<br>

## Autores
<br>
<br>
<sub>Nayelys Maria Menencia Rodriguez</sub>(https://github.com/nayelysM0131)
<br> 
:ballot_box_with_check: **Tecnologías Utilizadas** :ballot_box_with_check:
<br>
<br>
:radio_button:...Visual Studio Code usando solo el lenguaje Java
<br>
<br>


**Licencia**:  (http://www.apache.org/licenses/)

 
