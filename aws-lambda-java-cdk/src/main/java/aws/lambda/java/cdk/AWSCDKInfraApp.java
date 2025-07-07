package aws.lambda.java.cdk;

import software.amazon.awscdk.App;
import software.amazon.awscdk.Environment;
import software.amazon.awscdk.StackProps;

public class AWSCDKInfraApp {
    public static void main(final String[] args) {
        App app = new App();

        // Optional: specify environment (can be omitted for default account/region)
        Environment env = Environment.builder()
                .account(System.getenv("CDK_DEFAULT_ACCOUNT"))
                .region(System.getenv("CDK_DEFAULT_REGION"))
                .build();

        // Create your stack
        new AWSLambdaJavaCDKStack(app, "SpringBootLambdaStack", StackProps.builder()
                .env(env)
                .build());

        app.synth();
    }
}
