# Secure, Flexible and Scalable Build Configuration with Maven

Maven project example accompanying article
[Secure, Flexible and Scalable Build Configuration with Maven](https://www.megadix.it/blog/maven-flexiconf/)

# Prerequisites

- Maven 3+
- Java 1.8+

# Instructions

## 1) Setup "local" profile

Before building the project you must configure `local` profile, which is active by default. An example [Filter File](https://maven.apache.org/pom.html#BaseBuild_Element) `SAMPLE-local.properties` is provided as a template:

- create a folder for application logs on your local file system, e.g.:
  - Linux/Unix-like: `/var/logs/maven-flexiconf`
  - Windows: `C:/logs/maven-flexiconf`
- open `configuration/SAMPLE-local.properties`
- copy and rename it `local.properties`
- in `local.properties` set the values of the following properties according to the folder you created above:
  - `log.path`
  - `log.rolled.path`

**In `.gitignore` there's an entry for the *local* filter file** you created (**`configuration/local.properties`**), so it cannot be committed to the repository. This way you safely modify it, putting in it local paths, passwords, etc. without worrying that sensitive data will be pushed to the repository.

## 2) Build application

### Default Build

Build command:

```
mvn package
```

As the default active profile is `local`, executing this build command will use properties from `configuration/local.properties`. The result of the build is a jar with its dependencies:

`target/maven-flexiconf-jar-with-dependencies.jar`

### Production Build

To run a production build you need to activate the `prod` profile.

To simulate an actual production build you should provide informations (especially sensitive ones) on the command line, leaving `configuration/prod.properties` untouched.

Here's an example command (make sure to copy it on a single line):

```
mvn package -Pprod "-Djdbc.url=jdbc:mysql://prod.example.org:3306/maven-flexiconf" \
  "-Djdbc.username=prod-user" \
  "-Djdbc.password=prod-password"
  "-Dlog.path=/var/logs/my-application" \
  "-Dlog.rolled.path=/var/logs/my-application/rolled"
```

## 3) Run application

On Unix/Linux/Mac:

```
java -jar target/maven-flexiconf-jar-with-dependencies.jar
```

On Windows:

```
java -jar .\target\maven-flexiconf-jar-with-dependencies.jar
```

After running the application you will find a `maven-flexiconf.log` log file in the directory you created in **Step 1**.

## 4) Experiment!

### Run different build profiles

- do a `local` build and run the application
- run a `prod` build and run the application
- check the difference in **log files**

### Create new build profiles

Try creating a new build profile, e.g. `qa` (Quality Assurance) or `integration`, overriding files in `src/main/resources-override` and putting properties in correct filter files.

Remember: **security is a top priority**. Try to understand why preventing sensitive data to leak in Git repository is important and how to ensure it.
