# Compilar y ejecutar

Compilar con Maven (desde la raíz del repositorio):

```powershell
cd gal.uvigo.esei.aed1_cubirds
mvn package
```

Ejecutar la clase `Main` (desde el módulo):

```powershell
cd gal.uvigo.esei.aed1_cubirds
java -cp target/classes gal.uvigo.esei.aed1.cubirds.iu.Main
```

Si prefieres ejecutar con el plugin `exec-maven-plugin` (si está configurado):

```powershell
mvn -f gal.uvigo.esei.aed1_cubirds exec:java -Dexec.mainClass="gal.uvigo.esei.aed1.cubirds.iu.Main"
```

Pruebas unitarias (si existen):

```powershell
cd gal.uvigo.esei.aed1_cubirds
mvn test
```
