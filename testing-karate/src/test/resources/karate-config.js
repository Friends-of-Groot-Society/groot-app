function fn() {
  var env = karate.env; // get system property 'karate.env'
  karate.log('karate.env system property was:', env);
  if (!env) {
    env = 'prod';
  }
  karate.log('karate.env system property was:', env);
  var  apiUrl = karate.apiUrl || 'http://localhost:8080/';
  spring_datasource_url = karate.spring_datasource_url  || ''
  var spring_datasource_username = karate.spring_datasource_username || ''
  var spring_datasource_password = karate.spring_datasource_password || ''


  if (env == 'dev') {
    apiUrl= 'http://localhost:8080/';

    spring_datasource_url = "jdbc:oracle:thin:@thomas.cmcadlepsyx9.us-east-1.rds.amazonaws.com:1521:thomas";
    // spring_datasource_url="jdbc:mysql://localhost:3306/db_mapl?createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true&useSSL=false"
    spring_datasource_username="root"
    spring_datasource_password="abc123!!"
  } else if (env == 'prod') {
    apiUrl= 'http://34.199.129.2/';

    spring_datasource_url = "jdbc:oracle:thin:@thomas.cmcadlepsyx9.us-east-1.rds.amazonaws.com:1521:thomas";
    spring_datasource_username="thomas"
    spring_datasource_password="Paris)utpost1"

  }
  var config = {
    env: env,
    apiUrl: 'http://34.199.129.2/',
    spring_datasource_url: spring_datasource_url,
    spring_datasource_username: spring_datasource_username,
    spring_datasource_password: spring_datasource_password,

  }
  var accessToken = karate.callSingle('classpath:utils/CreateToken.feature', config).authToken
  karate.configure('headers', {Authorization: 'Token ' + accessToken})
  return config;
}