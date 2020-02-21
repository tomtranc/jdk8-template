package lambda.exception;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.jar.JarException;

import static lambda.exception.LambdaWrapper.throwingConsumerWrapper;

/**
 * This sample class shows how to use lambda expression with method that throws checked exceptions
 */
public class TestLambdaThrowException {

    private void methodWithException(Integer arg1) throws IOException, JarException {
        throw new JarException("Some Jar Exception caused by " + arg1);
    }

    @Test
    public void testLambdaThrowingException() {
        List<Integer> integers = Arrays.asList(3, 9, 7, 0, 10, 20);
        integers.forEach(throwingConsumerWrapper(i -> methodWithException(i)));
    }
}
