//package com.friendsofgroot.app.util;
//
//public class StreamLambdaHandler implements RequestStreamHandler {
//    private static SpringBootLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse> handler;
//    static {
//        try {
//            handler = SpringBootLambdaContainerHandler.getAwsProxyHandler(Application.class);
//            // If you are using HTTP APIs with the version 2.0 of the proxy model, use the getHttpApiV2ProxyHandler
//            // method: handler = SpringBootLambdaContainerHandler.getHttpApiV2ProxyHandler(Application.class);
//        } catch (ContainerInitializationException e) {
//            // if we fail here. We re-throw the exception to force another cold start
//            e.printStackTrace();
//            throw new RuntimeException("Could not initialize Spring Boot application", e);
//        }
//    }
//
//    @Override
//    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context)
//            throws IOException {
//        handler.proxyStream(inputStream, outputStream, context);
//    }
//}