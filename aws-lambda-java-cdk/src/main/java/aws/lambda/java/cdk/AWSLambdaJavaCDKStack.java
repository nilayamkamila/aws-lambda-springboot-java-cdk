package aws.lambda.java.cdk;

import software.amazon.awscdk.Duration;
import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.apigateway.LambdaRestApi;
import software.amazon.awscdk.services.lambda.Code;
import software.amazon.awscdk.services.lambda.Function;
import software.amazon.awscdk.services.lambda.Runtime;
import software.constructs.Construct;


public class AWSLambdaJavaCDKStack extends Stack {
    public AWSLambdaJavaCDKStack(final Construct scope, final String id) {
        this(scope, id, null);
    }

    public AWSLambdaJavaCDKStack(final Construct scope, final String id, final StackProps props) {
        super(scope, id, props);

        Function lambda = Function.Builder.create(this, "SpringBootLambda")
                .runtime(Runtime.JAVA_17)
                .memorySize(1024)
                .timeout(Duration.seconds(30))
                .handler("org.example.aws.lambda.springboot.handler.StreamLambdaHandler")
                .code(Code.fromAsset("../aws-lambda-springboot-java/target/aws-lambda-springboot-java-1.0-SNAPSHOT.jar"))
                .build();

        LambdaRestApi api = LambdaRestApi.Builder.create(this, "SpringBootLambdaApi")
                .handler(lambda)
                .proxy(true)
                .build();
    }
}