# ExcelMergeTool

This is a Java and Groovy project, build using gradle in Eclipse.

Eclipse version:  <br />
Version: Oxygen.3a Release (4.7.3a) <br />
Build id: 20180405-1200 <br />

# Below commands are useful for developers

gradle build --refresh-dependencies <br />
gradlew build <br />
gradlew run <br />

# In case there is workspace related issue, run below commands :

gradle cleanEclipse  -> to clean the Eclipse configuration completely <br />
gradle cleanEclipseProject -> to remove the .project file <br />
gradle cleanEclipseClasspath -> to empty the project's classpath <br />
gradle eclipse -> to rebuild the Eclipse configuration <br />

# To run project : 

git clone https://github.com/Abhinav3414/ExcelMergeTool.git

cd ExcelMergeTool

# wait, build? we don't have Gradle install yet? No problem, gradlew will handle it.
./gradlew build  

# first time, download the gradle 2.10..
# download project dependencies
# run the gradle build task
# ...wow, we run a Gradle task without installing Gradle!

Done.