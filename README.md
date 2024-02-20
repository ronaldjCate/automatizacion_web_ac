# Framework de automatización web

Para ejecutar un test, lanzar la siguiente sentencia:

```
mvn test -Dcucumber.features='src/test/resources/features/' -Dcucumber.filter.tags='@getNombreModeloAuto' -Dcucumber.plugin="json:target/site/result.json" -Dcucumber.glue='demo'
```

Una vez que termine la prueba, lanzar el siguiente comando:

```
mvn serenity:aggregate
```

Con lo que se generarán las evidencias, en la siguiente ruta:

```
target/site/serenity/index.html

```
