function fn() {
    var env = karate.env; // get system property 'karate.env'
    karate.log('karate.env system property was:', env);
    if (!env) {
        env = 'mysql';
    }
    karate.log('karate.env system property was:', env);
    var apiUrl = karate.apiUrl || 'http://localhost:8080/';
    var system = karate.system
    var baseUrl = karate.baseUrl || "http://localhost:8080"
    var pw = process.env.ORACLE_DB_PASSWORD
    console.log("----------pw----------" + pw)
    var spring_datasource_url = karate.spring_datasource_url || ''
    var spring_datasource_username = karate.spring_datasource_username || ''
    var spring_datasource_password = karate.spring_datasource_password || pw

    if (env === 'dev' || env === 'mysql') {
        apiUrl = 'http://localhost:8080/';

        // spring_datasource_url = "jdbc:oracle:thin:@thomas.cmcadlepsyx9.us-east-1.rds.amazonaws.com:1521:thomas";
        spring_datasource_url = "jdbc:mysql://localhost:3306/groot?createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true&useSSL=false"
        spring_datasource_username = "root\n" +
            "  }"
        spring_datasource_password = "abc123!!"
    } else if (env === 'prod') {
        apiUrl = 'http://34.199.129.2/8080/';

        spring_datasource_url = "jdbc:oracle:thin:@thomas.cmcadlepsyx9.us-east-1.rds.amazonaws.com:1521:thomas";
        spring_datasource_username = "thomas"
        spring_datasource_password = pw
        var config = {
            env: this.env,
            system: this.system,
            baseUrl: "http://localhost:8080/",
            baseUrl1: this.baseUrl,
            baseUrl2: baseUrlPage,
            baseUrl3: this.baseUrlPagel,
            spring_datasource_url: spring_datasource_url,
            spring_datasource_username: spring_datasource_username,
            spring_datasource_password: spring_datasource_password,

        }
        // var accessToken = karate.callSingle('classpath:utils/CreateToken.feature', config).authToken
        // karate.configure('headers', {Authorization: 'Token ' + accessToken})
        return config;
    }