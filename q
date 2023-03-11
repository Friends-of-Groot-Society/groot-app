[1mdiff --git a/pom.xml b/pom.xml[m
[1mindex 69b7e4f..5fc8053 100644[m
[1m--- a/pom.xml[m
[1m+++ b/pom.xml[m
[36m@@ -152,11 +152,6 @@[m
 			<artifactId>junit</artifactId>[m
 			<scope>test</scope>[m
 		</dependency>[m
[31m-		<dependency>[m
[31m-			<groupId>junit</groupId>[m
[31m-			<artifactId>junit</artifactId>[m
[31m-			<scope>test</scope>[m
[31m-		</dependency>[m
 		<!--	<dependency>[m
                 <groupId>org.jetbrains</groupId>[m
                 <artifactId>annotations</artifactId>[m
[1mdiff --git a/src/main/java/com/friendsofgroot/app/repositories/UsersRepository.java b/src/main/java/com/friendsofgroot/app/repositories/UsersRepository.java[m
[1mindex db026cc..94a0652 100644[m
[1m--- a/src/main/java/com/friendsofgroot/app/repositories/UsersRepository.java[m
[1m+++ b/src/main/java/com/friendsofgroot/app/repositories/UsersRepository.java[m
[36m@@ -4,6 +4,7 @@[m [mimport org.springframework.data.jpa.repository.JpaRepository;[m
 import org.springframework.stereotype.Repository;[m
 import com.friendsofgroot.app.models.User;[m
 [m
[32m+[m[32mimport java.util.List;[m
 import java.util.Optional;[m
 [m
 [m
[36m@@ -12,6 +13,13 @@[m [mpublic interface UsersRepository extends JpaRepository<User, Integer> {[m
     Optional<User> findByEmail(String email);[m
     Optional<User> findByEmailAndPassword(String email, String password);[m
 [m
[31m-    User findByUserName(String username);[m
[32m+[m[32m    User findDistinctByGroups(String groups);[m
 [m
[32m+[m[32m    User findByUserNameContaining(String userName);[m
[32m+[m
[32m+[m[32m    User findByEmailIn(List<String> email);[m
[32m+[m
[32m+[m[32m    List<User> findByEmailLike(String email);[m
[32m+[m
[32m+[m[32m    List<User> findFirst2ByOrderByEmailAsc();[m
 }[m
\ No newline at end of file[m
[1mdiff --git a/src/main/resources/application.properties b/src/main/resources/application.properties[m
[1mindex 786d269..84fb41c 100644[m
[1m--- a/src/main/resources/application.properties[m
[1m+++ b/src/main/resources/application.properties[m
[36m@@ -24,7 +24,8 @@[m [mspring.datasource.password=${ORACLE_DB_PASSWORD}[m
 [m
 spring.jpa.show-sql=true[m
 spring.jpa.format-sql=true[m
[32m+[m[32mspring.jpa.properties.hibernate.format_sql=true[m
 spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.Oracle8iDialect[m
 [m
[31m-# Hibernate ddl auto (create, create-drop, validate, update)[m
[32m+[m[32m# Hibernate ddl # none, create-only, drop, create, create-drop, validate, update[m
 spring.jpa.hibernate.ddl-auto = validate[m
